package com.company;

import javax.swing.*;
import java.awt.*;

public class Canva extends JPanel {

    private final JLabel labelR = new JLabel("R");
    private final JLabel labelG = new JLabel("G");
    private final JLabel labelB = new JLabel("B");
    private final JLabel labelC = new JLabel("C");
    private final JLabel labelM = new JLabel("M");
    private final JLabel labelY = new JLabel("Y");
    private final JLabel labelK = new JLabel("K");

    private final JLabel labelRr = new JLabel("R");
    private final JLabel labelGg = new JLabel("G");
    private final JLabel labelBb = new JLabel("B");
    private final JLabel labelCc = new JLabel("C");
    private final JLabel labelMm = new JLabel("M");
    private final JLabel labelYy = new JLabel("Y");
    private final JLabel labelKk = new JLabel("K");
    private final JButton convertButtonRGBToCMYK = new JButton();
    private final JButton convertButtonCMYKToRGB = new JButton();
    private final JSlider RSlider = new JSlider(0,255);
    private final JSlider GSlider = new JSlider(0,255);
    private final JSlider BSlider = new JSlider(0,255);
    private final JSlider CSlider = new JSlider(0,255);
    private final JSlider MSlider = new JSlider(0,255);
    private final JSlider YSlider = new JSlider(0,255);
    private final JSlider KSlider = new JSlider(0,255);
    private final JPanel littleSquare = new JPanel();
    private final JTextField RField = new JTextField();
    private final JTextField GField = new JTextField();
    private final JTextField BField = new JTextField();
    private final JTextField CField = new JTextField();
    private final JTextField MField = new JTextField();
    private final JTextField YField = new JTextField();
    private final JTextField KField = new JTextField();




    Canva()
    {
        this.setLayout(null);
        setButtons();
        setColorSquare();
        setSliders();
        setLabels();
        RField.setBounds(30,150,60,20);
        GField.setBounds(110,150,60,20);
        BField.setBounds(190,150,60,20);
        CField.setBounds(270,150,60,20);
        MField.setBounds(350,150,60,20);
        YField.setBounds(430,150,60,20);
        KField.setBounds(510,150,60,20);
        this.add(RField);
        this.add(GField);
        this.add(BField);
        this.add(CField);
        this.add(MField);
        this.add(YField);
        this.add(KField);

    }



    private void updateK(int value) {
        KField.setText(String.valueOf(value));
        setSquareBackgroundCMYK(
                CSlider.getValue(),
                MSlider.getValue(),
                YSlider.getValue(),
                value
                );

    }

    private void setSquareBackgroundCMYK(int C, int M, int Y, int K) {

        float red = 255* (((float)(255-C)/255)*((float)(255-K)/255));
        float green =255* (((float)(255-M)/255)*((float)(255-K)/255));
        float blue = 255*(((float)(255-Y)/255)*((float)(255-K)/255));


        Color color = new Color((int)red,(int)green,(int)blue);
        littleSquare.setBackground(color);
        setRGBValues((int)red,(int)green,(int)blue);

    }

    private void setRGBValues(int red, int green, int blue) {

        RField.setText(String.valueOf(red));
        GField.setText(String.valueOf(green));
        BField.setText(String.valueOf(blue));
    }

    private void updateY(int value) {
        YField.setText(String.valueOf(value));
        setSquareBackgroundCMYK(
                CSlider.getValue(),
                MSlider.getValue(),
                value,
                KSlider.getValue());
    }

    private void updateM(int value) {
        MField.setText(String.valueOf(value));
        setSquareBackgroundCMYK(
                CSlider.getValue(),
                value,
                YSlider.getValue(),
                KSlider.getValue()
        );
    }

    private void updateC(int value) {
        CField.setText(String.valueOf(value));
        setSquareBackgroundCMYK(
                value,
                MSlider.getValue(),
                YSlider.getValue(),
                KSlider.getValue()
        );
    }



    private void updateB(int value) {
        BField.setText(String.valueOf(value));
        setSquareBackgroundRGB(RSlider.getValue(),GSlider.getValue(),value);
    }



    private void updateG(int value) {
        GField.setText(String.valueOf(value));
        setSquareBackgroundRGB(RSlider.getValue(),value,BSlider.getValue());
    }

    private void updateR(int value) {
        RField.setText(String.valueOf(value));
        setSquareBackgroundRGB(value,GSlider.getValue(),BSlider.getValue());

    }

    private void setSquareBackgroundRGB(int R, int G, int B) {
        Color color = new Color(R,G,B);
        littleSquare.setBackground(color);
        setCMYKValues(R,G,B);

    }

    private void setCMYKValues(int r, int g, int b) {

        float cyan=0 ;
        float magenta=0;
        float yellow=0;
        float black=0;
        if(r==0&&g==0&&b==0)
        {
            CField.setText(String.valueOf(0));
            MField.setText(String.valueOf(0));
            YField.setText(String.valueOf(0));
            KField.setText(String.valueOf(1));
        }
        else
        {
            float red = (float)r/255;
            float green = (float)g/255;
            float blue =(float) b/255;

            float max = red;
            if(green>max)
            {
                max=green;
            }
            if(blue>max)
            {
                max=blue;
            }
            float white = max;
             cyan = (white-red)/white;
             magenta = (white-green)/white;
             yellow = (white-blue)/white;
             black = 1-white;
        }
        CField.setText(String.valueOf(cyan));
        MField.setText(String.valueOf(magenta));
        YField.setText(String.valueOf(yellow));
        KField.setText(String.valueOf(black));

        CSlider.setValue( (int) (cyan*255));
        MSlider.setValue( (int) (magenta*255));
        YSlider.setValue( (int) (yellow*255));
        KSlider.setValue( (int) (black*255));

    }

    private void setLabels() {
        labelRr.setBounds(10,150,10,20);
        labelGg.setBounds(90,150,10,20);
        labelBb.setBounds(170,150,10,20);
        labelCc.setBounds(250,150,10,20);
        labelMm.setBounds(330,150,10,20);
        labelYy.setBounds(410,150,10,20);
        labelKk.setBounds(490,150,10,20);
        labelR.setBounds(10,30,10,20);
        labelG.setBounds(10,60,10,20);
        labelB.setBounds(10,90,10,20);
        labelC.setBounds(350,30,10,20);
        labelM.setBounds(350,60,10,20);
        labelY.setBounds(350,90,10,20);
        labelK.setBounds(350,120,10,20);
        this.add(labelB);
        this.add(labelG);
        this.add(labelK);
        this.add(labelY);
        this.add(labelC);
        this.add(labelM);
        this.add(labelR);
        this.add(labelBb);
        this.add(labelGg);
        this.add(labelKk);
        this.add(labelYy);
        this.add(labelCc);
        this.add(labelMm);
        this.add(labelRr);
    }

    private void setSliders() {
        RSlider.setBounds(30,30 ,150,20);
        GSlider.setBounds(30,60 ,150,20);
        BSlider.setBounds(30,90 ,150,20);
        CSlider.setBounds(180,30 ,150,20);
        MSlider.setBounds(180,60 ,150,20);
        YSlider.setBounds(180,90 ,150,20);
        KSlider.setBounds(180,120 ,150,20);
        RSlider.addChangeListener(e->updateR(RSlider.getValue()));
        GSlider.addChangeListener(e->updateG(GSlider.getValue()));
        BSlider.addChangeListener(e->updateB(BSlider.getValue()));
        CSlider.addChangeListener(e->updateC(CSlider.getValue()));
        MSlider.addChangeListener(e->updateM(MSlider.getValue()));
        YSlider.addChangeListener(e->updateY(YSlider.getValue()));
        KSlider.addChangeListener(e->updateK(KSlider.getValue()));
        this.add(RSlider);
        this.add(GSlider);
        this.add(BSlider);
        this.add(CSlider);
        this.add(MSlider);
        this.add(YSlider);
        this.add(KSlider);
    }

    private void setColorSquare() {
        littleSquare.setBounds(400,90,150,20);
        littleSquare.setBackground(Color.CYAN);
        this.add(littleSquare);
    }

    private void setButtons() {
        convertButtonCMYKToRGB.setBounds(400,60,150,20);
        convertButtonRGBToCMYK.setBounds(400,30,150,20);
        convertButtonRGBToCMYK.setText("RGB to CMYK");
        convertButtonCMYKToRGB.setText("CMYK to RGB");
        convertButtonRGBToCMYK.addActionListener(e-> {
                setCMYKValues(
                        Integer.parseInt(RField.getText()),
                        Integer.parseInt(GField.getText()),
                        Integer.parseInt(BField.getText()));

                setSquareBackgroundRGB(
                        Integer.parseInt(RField.getText()),
                        Integer.parseInt(GField.getText()),
                        Integer.parseInt(BField.getText()));
        });
        this.add(convertButtonCMYKToRGB);
        this.add(convertButtonRGBToCMYK);
    }
}
