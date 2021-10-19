package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class CubeService extends JFrame implements MouseListener, MouseMotionListener {




    private final int width=200;
    private final int height=200;
    private final JPanel panel;
    private float distance;
    private float angle;
    Point prevMove = new Point();
    private Cube cube;

  CubeService(){
      super("3D ");


      angle = (float) Math.toRadians(40);
      distance = (width / 2) / (float) (Math.tan(angle / 2));

      panel = new JPanel() {
          @Override
          protected void paintComponent(Graphics g) {
              super.paintComponent(g);
              cube.project(g);
          }
      };
      panel.setPreferredSize(new Dimension(300, 300));
      add(panel);
      pack();
      setLocationRelativeTo(null);

      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      cube = new Cube();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    class Cube {

        public int size = 50;
        Vector3D upperLeftFront, upperRightFront, lowerLeftFront, lowerRightFront;
        Vector3D upperLeftBack, upperRightBack, lowerLeftBack, lowerRightBack;



        public Cube() {

            int startx = width / 10 ;
            int starty = height / 4 ;
            upperLeftFront = new Vector3D(startx, starty, 0);
            upperRightFront = new Vector3D(startx + size, starty, 0);
            lowerLeftFront = new Vector3D(startx, starty+size, 0);
            lowerRightFront = new Vector3D(startx + size, starty + size, 0);

            upperLeftBack = new Vector3D(startx, starty, -size);
            upperRightBack = new Vector3D(startx + size, starty, -size);
            lowerLeftBack = new Vector3D(startx, starty+size, -size);
            lowerRightBack = new Vector3D(startx + size, starty + size, -size);
        }

        public void move(int dx, int dy)
        {
            upperLeftFront.x += dx;
            upperRightFront.x += dx;
            lowerLeftFront.x += dx;
            lowerRightFront.x += dx;
            upperLeftBack.x += dx;
            upperRightBack.x += dx;
            lowerLeftBack.x += dx;
            lowerRightBack.x += dx;

            upperLeftFront.y += dy;
            upperRightFront.y += dy;
            lowerLeftFront.y += dy;
            lowerRightFront.y += dy;
            upperLeftBack.y += dy;
            upperRightBack.y += dy;
            lowerLeftBack.y += dy;
            lowerRightBack.y += dy;

        }


        public void project(Graphics g) {


            Point pointUpperLeftFront = upperLeftFront.to2D();
            Point pointUpperRightFront = upperRightFront.to2D();
            Point pointLowerLeftFront = lowerLeftFront.to2D();
            Point pointLowerRightFront = lowerRightFront.to2D();
            Point pointUpperLeftBack= upperLeftBack.to2D();
            Point pointUpperRightBack= upperRightBack.to2D();
            Point pointLowerLeftBack= lowerLeftBack.to2D();
            Point pointLowerRightBack= lowerRightBack.to2D();

            Graphics2D g2d =(Graphics2D)g;
            Color red = Color.RED;
            Color green = Color.GREEN;
            Color blue = Color.BLUE;
            Color magenta = Color.MAGENTA;
            Color cyan = Color.CYAN;
            Color yellow = Color.YELLOW;
            Color black = Color.BLACK;
            Color white = Color.WHITE;

            g2d.setColor(Color.GREEN);
            Polygon pFront = new Polygon();
            pFront.addPoint(pointLowerRightFront.x, pointLowerRightFront.y);
            pFront.addPoint(pointLowerLeftFront.x, pointLowerLeftFront.y);
            pFront.addPoint(pointUpperLeftFront.x, pointUpperLeftFront.y);
            pFront.addPoint(pointUpperRightFront.x, pointUpperRightFront.y);



            g2d.drawPolygon(pFront);
            g2d.fillPolygon(pFront);

            Polygon pBottom = new Polygon();
            g2d.setColor(Color.MAGENTA);
            pBottom.addPoint(pointLowerRightFront.x, pointLowerRightFront.y);
            pBottom.addPoint(pointLowerLeftFront.x, pointLowerLeftFront.y);
            pBottom.addPoint(pointLowerLeftBack.x, pointLowerLeftBack.y);
            pBottom.addPoint(pointLowerRightBack.x, pointLowerRightBack.y);
            g2d.drawPolygon(pBottom);
            g2d.fillPolygon(pBottom);

            Polygon pUp = new Polygon();
            g2d.setColor(Color.CYAN);
            pUp.addPoint(pointUpperRightFront.x, pointUpperRightFront.y);
            pUp.addPoint(pointUpperRightBack.x, pointUpperRightBack.y);
            pUp.addPoint(pointUpperLeftBack.x, pointUpperLeftBack.y);
            pUp.addPoint(pointUpperLeftFront.x, pointUpperLeftFront.y);
            g2d.drawPolygon(pUp);
            g2d.fillPolygon(pUp);
            Polygon pLeft = new Polygon();
            g2d.setColor(Color.RED);
            pLeft.addPoint(pointLowerLeftFront.x, pointLowerLeftFront.y);
            pLeft.addPoint(pointLowerLeftBack.x, pointLowerLeftBack.y);
            pLeft.addPoint(pointUpperLeftBack.x, pointUpperLeftBack.y);
            pLeft.addPoint(pointUpperLeftFront.x, pointUpperLeftFront.y);
            g2d.drawPolygon(pLeft);
            g2d.fillPolygon(pLeft);
            Polygon pRight= new Polygon();
            g2d.setColor(Color.YELLOW);
            pRight.addPoint(pointUpperRightFront.x, pointUpperRightFront.y);
            pRight.addPoint(pointLowerRightFront.x, pointLowerRightFront.y);
            pRight.addPoint(pointLowerRightBack.x, pointLowerRightBack.y);
            pRight.addPoint(pointUpperRightBack.x,pointUpperRightBack.y);
            g2d.drawPolygon(pRight);
            g2d.fillPolygon(pRight);
            g2d.setColor(Color.BLUE);
            Polygon pBack = new Polygon();
            pBack.addPoint(pointUpperRightBack.x, pointUpperRightBack.y);
            pBack.addPoint(pointUpperLeftBack.x, pointUpperLeftBack.y);
            pBack.addPoint(pointLowerLeftBack.x, pointLowerLeftBack.y);
            pBack.addPoint(pointLowerRightBack.x, pointLowerRightBack.y);
            g2d.drawPolygon(pBack);
            GradientPaint rToW = new GradientPaint(pointUpperRightBack,red,pointLowerLeftBack,white);
            g2d.setPaint(rToW);

            g2d.fillPolygon(pBack);

        }



    }

    private float rotX, rotY, rotZ = 0f;

    class Vector3D {
        public float x, y, z;

        public Vector3D(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public String toString() {
            return "(" + x + "," + y + "," + z + ")";
        }

        public Point to2D() {

            Vector3D v = new Vector3D(x, y, z);
            rotateVector(v, rotY, -rotX, rotZ);

            Point p;

            float Z = distance + v.z;
            p = new Point((int) (distance * v.x / Z), (int) (distance * v.y / Z));


            p.x += width / 2;
            p.y += height / 2;


            return p;
        }
    }




    @Override
    public void mouseMoved(MouseEvent e) {
        prevMove = e.getPoint();

    }
    float ROT_FACTOR = 100;

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX()-prevMove.x;
        int dy = e.getY()-prevMove.y;

        if (e.isShiftDown()) {

            if (e.isShiftDown()) {
                rotX += dx/ROT_FACTOR;
                rotY += 0;
                rotZ += dy/ROT_FACTOR;
            } else {
                rotX += dx/ROT_FACTOR;
                rotY += dy/ROT_FACTOR;
                rotZ += 0;
            }
        } else {
            cube.move(dx,dy);
        }

        panel.repaint();
        prevMove = e.getPoint();
    }


    public void rotateVector(Vector3D p, float thetaX, float thetaY, float thetaZ) {
        float aX, aY, aZ;

        float camX = 0;
        float camY = 0;
        float camZ = 0;

        aX = p.x;
        aY = p.y;
        aZ = p.z;


        aY = p.y;
        aZ = p.z;
        p.y = (float) ((aY-camY)*Math.cos(thetaX)-(aZ-camZ)*Math.sin(thetaX));
        p.z = (float) ((aY-camY)*Math.sin(thetaX)+(aZ-camZ)*Math.cos(thetaX));

        aX = p.x;
        aZ = p.z;
        p.x = (float) ((aX-camX)*Math.cos(thetaY)+(aZ-camZ)*Math.sin(thetaY));
        p.z = (float) (-(aX-camX)*Math.sin(thetaY)+(aZ-camZ)*Math.cos(thetaY));

        aY = p.y;
        aX = p.x;
        p.x = (float) ((aX-camX)*Math.cos(thetaZ)-(aY-camY)*Math.sin(thetaZ));
        p.y = (float) ((aY-camY)*Math.cos(thetaZ)+(aX-camX)*Math.sin(thetaZ));

    }
}
