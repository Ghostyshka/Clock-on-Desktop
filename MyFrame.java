import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    String time;
    String day;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock");
        this.setLayout(new FlowLayout());
        this.setSize(400, 250);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,50));
        timeLabel.setForeground(Color.blue);
        timeLabel.setBackground( Color.orange);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN,30));


        this.add(timeLabel);
        this.add(dayLabel);
        this.setVisible(true);

        setTime();
    }
    public void setTime(){
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
