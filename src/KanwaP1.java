import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class KanwaP1 extends JPanel {
    public int x, y;
    private static final int WIDTH = 645;
    private static final int HEIGHT = 400;
    static int wybor;
    public ArrayList<Point> punkty = new ArrayList<>();
    int ilosc = punkty.size();

    public void rysKwadrat(Graphics g2d) {
        int a, b;

        for (Point o : punkty) {
            a = o.x;
            b = o.y;
            g2d.setColor(Color.BLACK);
            g2d.fillRect(a, b, 20, 20);
            repaint();
        }
    }

    public void rysElipsa(Graphics g2d) {
        int a, b;

        for (Point o : punkty) {
            a = o.x;
            b = o.y;
            g2d.setColor(Color.BLACK);
            g2d.fillOval(a, b, 20, 20);
            repaint();
        }
    }

    public KanwaP1() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //Pobieranie współrzędych

                if (wybor == 75 || wybor == 69) {
                    //punkty.removeAll(punkty);
                    x = e.getX();
                    y = e.getY();
                    punkty.add(new Point(x, y));
                    repaint();
                }
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //Jeżeli użytkownik naciśnie "K" na klawiaturze
                //to będzie się rysować kwadrat

                if (e.getKeyCode() == 75)
                    wybor = 75;

                //Elipsa - jeżeli użytkownik naciśnie "E"
                if (e.getKeyCode() == 69)
                    wybor = 69;

            }
        });
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.MAGENTA);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        for (Point o : punkty) {
            int a, b;
            a = (int) o.getX();
            b = (int) o.getY();
            g2d.setColor(Color.BLACK);
            repaint();

            switch (wybor) {
                case 75:
                    g2d.fillRect(a, b, 20, 20);
                    break;

                case 69:
                    g2d.fillOval(a, b, 20, 20);
                    break;
            }

            /*if(wybor == 75)
            {

            }
            else if(wybor == 69)
            {
                g2d.fillOval(a,b,20, 20);
            }*/
        }

        /*if(wybor == 75)
        {
            //RYSOWANIE KWADRATÓW
            rysKwadrat(g2d);
        }
        if(wybor == 69)
        {
            //RYSOWANIE ELIPS
            rysElipsa(g2d);
        }*/
    }

}