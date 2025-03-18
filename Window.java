package clock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Window extends JFrame {
    private JLabel heading;
    private JLabel clocklabel;
    private Font font = new Font("", Font.BOLD, 35);

    Window() {
        super.setTitle("Clock");
        super.setSize(500, 500);
        super.setLocation(300, 50);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.createGUI();
        this.startclock();
        super.setVisible(true);
    }

    public void createGUI() {
        heading = new JLabel("MY CLOCK", SwingConstants.CENTER);
        clocklabel = new JLabel("clock", SwingConstants.CENTER);

        heading.setFont(font);
        clocklabel.setFont(font);

        heading.setForeground(Color.orange);
        clocklabel.setForeground(Color.BLACK);

        this.setLayout(new GridBagLayout()); 
        this.getContentPane().setBackground(new Color(0xE0F7FA)); 

        JPanel cardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

               
                g2d.setColor(new Color(0, 0, 0, 50));
                g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 30, 30);

                
                g2d.setColor(Color.WHITE);
                g2d.fillRoundRect(0, 0, getWidth() - 10, getHeight() - 10, 30, 30);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(350, 250);
            }
        };

        cardPanel.setLayout(new GridLayout(2, 1, 0, 20)); 
        cardPanel.setOpaque(false); 

        cardPanel.add(heading);
        cardPanel.add(clocklabel);

        this.add(cardPanel);
    }

    public void startclock() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
                String dateTime = sdf.format(d);
                clocklabel.setText(dateTime);
            }
        });
        timer.start();
    }
}
