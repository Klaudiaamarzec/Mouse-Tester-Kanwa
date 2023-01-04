import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Random;

public class Guzik extends JFrame implements ActionListener
{
    private final JButton button = new JButton("RUN");
    private final JButton close = new JButton("CLOSE");
    private final JButton cancel = new JButton("CANCEL");

    Random random = new Random();
    public void close()
    {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public void newWindow()
    {
        KanwaFrame window2 = new KanwaFrame("KANWA");
        window2.setVisible(true);
    }

    private void setButton()
    {
        button.setLocation(250,175);
    }

    public void newPanel()
    {
        setSize(640, 480);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.setBounds(250,175,100,50);
        button.setBackground(Color.PINK);
        add(button);
        button.addActionListener(this);
        button.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseEntered(MouseEvent e)  //NAJECHANIE NA PRZYCISK - BEZ KLIKNIĘCIA
            {
                //STREFA OCHRONNA
                //Jak najedziemy na guzik powoli od dolu to nie ucieka

                if(e.getY() != 49)  //Współrzędna od dołu
                    button.setLocation(random.nextInt(540),random.nextInt(430));
            }
        });
        //button.addMouseListener(this);
        close.setBounds(450,350, 100, 25);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.white);
        add(close);
        close.addActionListener(this);
        cancel.setBounds(50,350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        add(cancel);
        cancel.addActionListener(this);
    }
    public Guzik(String title)
    {
        super(title);
        newPanel();
    }

    public static void main(String[] args)
    {
        try
        {
            Guzik window = new Guzik("Mouse Tester");
            window.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button) //Jeżeli uda się złapać guzik to wtedy ma się otworzyć KANWA!
            newWindow();

        if(e.getSource() == close)
            close();

        if(e.getSource() == cancel)
            setButton();

    }
}
