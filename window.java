package clock;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class window extends JFrame {
  private JLabel heading;
  private JLabel clocklabel;
  private Font font = new Font("", Font.BOLD,35);
    window()
    {
        super.setTitle("Clock");

        super.setSize(400,400);
        super.setLocation(300,50);
        this.createGUI();
        this.startclock();

        super.setVisible(true);
    }
public void createGUI()
{
    heading = new JLabel("MY CLOCK");
    clocklabel = new JLabel("clock");
    heading.setFont(font);
    clocklabel.setFont(font);

    this.setLayout(new GridLayout(2,1));
    this.add(heading);
    this.add(clocklabel);
    this.getContentPane().setBackground(Color.CYAN);
    heading.setForeground(Color.orange);
    clocklabel.setForeground(Color.BLACK);
}
public void startclock()
{
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           // String dateTime = new Date().toLocaleString();
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a"); //you can change specifier according yourself
            String dateTime=sdf.format(d);
            clocklabel.setText(dateTime);
        }
    });
    timer.start();
}
}