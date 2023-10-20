import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    JLabel timeLabel, dayLabel, dateLabel;
    String time, day, date;
    SimpleDateFormat timeFormat, dayFormat, dateFormat;

    Color colorTimeLabel = new Color(54, 54, 54);
    Color colorDayLabel = new Color(90, 90, 90);
    Color colorDateLabel = new Color(134, 134, 134);

    Timer timer;

    public MyFrame() {

        this.setTitle("Clock");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); //new FlowLayout()
        this.setSize(400, 325);
        getContentPane().setBackground(Color.BLUE);
        this.setResizable(false);

        timeLabel = new JLabel();
        timeLabel.setBounds( 0, 0, 400, 100);
        timeLabel.setOpaque(true);
        timeLabel.setBackground(colorTimeLabel);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setVerticalAlignment(JLabel.CENTER);

        dayLabel = new JLabel();
        dayLabel.setBounds(0, 100, 400, 100);
        dayLabel.setOpaque(true);
        dayLabel.setBackground(colorDayLabel);
        dayLabel.setForeground(Color.WHITE);
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        dayLabel.setVerticalAlignment(JLabel.CENTER);

        dateLabel = new JLabel();
        dateLabel.setBounds(0, 200, 400, 100);
        dateLabel.setOpaque(true);
        dateLabel.setBackground(colorDateLabel);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setVerticalAlignment(JLabel.CENTER);

        this.add(dateLabel);
        this.add(dayLabel);
        this.add(timeLabel);
        this.setVisible(true);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }

    public void updateTime() {
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        time = timeFormat.format(Calendar.getInstance().getTime());
        dayFormat = new SimpleDateFormat("EEEE");
        day = dayFormat.format(Calendar.getInstance().getTime());
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(Calendar.getInstance().getTime());

        timeLabel.setText(time);
        dayLabel.setText(day);
        dateLabel.setText(date);
    }

}
