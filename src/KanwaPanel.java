import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class KanwaPanel extends JPanel
{
    private int x,y;
    private static final int WIDTH = 645;
    private static final int HEIGHT = 400;
    public static int wybor;
    public  ArrayList<Point> punktyKwadrat = new ArrayList<>();
    public  ArrayList<Point> punktyElipsa = new ArrayList<>();
    public void rysKwadrat(Graphics g2d)
    {
        int a,b;

        for(Point o : punktyKwadrat)
        {
            a= (int)o.getX();
            b= (int)o.getY();
            g2d.fillRect(a,b,20, 20);
            repaint();
        }
    }

    public void rysElipsa(Graphics g2d)
    {
        int a,b;

        for(Point o : punktyElipsa)
        {
            a= (int)o.getX();
            b= (int)o.getY();
            g2d.fillOval(a,b,20, 20);
            repaint();
        }
    }

    public void usunKwadrat(Point punkt)
    {
        int x2,y2;   //współrzędne do usunięcia
        for(Point o : punktyKwadrat)
        {
            x2 = (int) o.getX();
            y2 = (int) o.getY();
            if(x >= x2 && y >= y2 && x <= x2 + 20 && y <= y2 + 20)
                punkt = o;
        }
        punktyKwadrat.remove(punkt);
        repaint();
    }

    public void usunElipse(Point punkt)
    {
        int x2,y2;   //współrzędne do usunięcia
        for(Point o : punktyElipsa)
        {
            x2 = (int) o.getX();
            y2 = (int) o.getY();
            if(x >= x2 && y >= y2 && x <= x2 + 20 && y <= y2 + 20)
                punkt = o;
        }
        punktyElipsa.remove(punkt);
        repaint();
    }

    public KanwaPanel()
    {
        setLayout(null);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.MAGENTA);
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                //Tam gdzie klikniemy, tam bedzie sie rysowac kwadrat

                if(wybor == 75)
                {
                    x = e.getX();
                    y = e.getY();
                    punktyKwadrat.add(new Point(x, y));
                    repaint();
                }

                if(wybor == 69)
                {
                    x = e.getX();
                    y = e.getY();
                    punktyElipsa.add(new Point(x, y));
                    repaint();
                }

                //Jeżeli chcemy usunąć element należy kliknąć
                //na niego prawym przyciskiem myszy

                if(e.getButton() == MouseEvent.BUTTON3)
                {
                    Point usun = null;
                    usunKwadrat(usun);
                    usunElipse(usun);
                }
            }
        });
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);

        rysKwadrat(g2d);
        rysElipsa(g2d);

    }
}
