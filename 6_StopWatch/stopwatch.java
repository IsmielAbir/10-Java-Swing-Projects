import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class stopwatch extends JFrame implements ActionListener{

    JLabel lab;
    long startTime;
    long stopTime;
    Timer timer;

    stopwatch(){
       
        setSize(400,300);
        setLayout(new BorderLayout());

        lab = new JLabel("00:00:00");
        lab.setFont(new Font("Arial", Font.BOLD, 44));
        lab.setHorizontalAlignment(JLabel.CENTER);
        add(lab, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1,3,4,8));
        
        JButton start = new JButton("Start");
        buttonPanel.add(start);

        JButton stop = new JButton("Stop");
        buttonPanel.add(stop);

        JButton reset = new JButton("Reset");
        buttonPanel.add(reset);

        add(buttonPanel, BorderLayout.NORTH);

        start.addActionListener(this);
        stop.addActionListener(this);
        reset.addActionListener(this);

        timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent m){
                long el = (System.currentTimeMillis() - startTime)/1000;
                String time = String.format("%02d:%02d:%02d", el / 3600, (el % 3600) / 60, el % 60);
                lab.setText(time);
            }
        });
    }

    public void actionPerformed(ActionEvent e){
        String c = e.getActionCommand();
        if(c.equals("Start")) {
            startTime = System.currentTimeMillis();
            timer.start();
        }

        else if(c.equals("Stop")) {
            stopTime = System.currentTimeMillis();
            timer.stop();
        }

        else if(c.equals("Reset")) {
            startTime = 0;
            stopTime = 0;
            lab.setText("00:00:00");
        }
    }

    public static void main(String[] args) {
        stopwatch frame = new stopwatch();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Stopwatch");
    }  
}