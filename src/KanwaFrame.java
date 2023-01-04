import javax.swing.*;
import java.awt.event.*;

public class KanwaFrame extends JFrame
{
    JLabel napis = new JLabel("Wprowadź z klawiatury, jaką figurę chcesz narysować: ");
    JLabel kwadrat = new JLabel(" - Kwadrat: K");
    JLabel elipsa = new JLabel(" - Elipsa: E");
    KanwaPanel panel = new KanwaPanel();
    JButton clear = new JButton("WYCZYŚĆ");

    public KanwaFrame(String title)
    {
        super(title);
        newPanel();
    }

    public void newPanel()
    {
        setSize(700, 580);
        setResizable(true);
        setLayout(null);
        setFocusable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        JPanel contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setFocusable(true);

        panel.setBounds(20,90,645,400);
        panel.setFocusable(true);
        contentPane.add(panel);

        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                //Jeżeli użytkownik naciśnie "K" na klawiaturze
                //to będzie się rysować kwadrat

                if(e.getKeyCode() == 75)
                {
                    KanwaPanel.wybor =75;
                    System.out.println("Wybrano K");
                }

                //Elipsa - jeżeli użytkownik naciśnie "E"
                if(e.getKeyCode() == 69)
                {
                    KanwaPanel.wybor =69;
                    System.out.println("Wybrano E");
                }
            }
        });

        clear.setBounds(20,500,100,25);
        add(clear);
        clear.addActionListener(e -> {
            panel.punktyElipsa.clear();
            panel.punktyKwadrat.clear();
            requestFocusInWindow();
        });

        napis.setBounds(30, 5, 300, 15);
        add(napis);
        kwadrat.setBounds(30, 25, 100, 15);
        add(kwadrat);
        elipsa.setBounds(30, 45, 100, 15);
        add(elipsa);
    }
}
