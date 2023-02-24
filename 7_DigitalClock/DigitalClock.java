import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DigitalClock extends JFrame{

    JLabel lab;
    Timer timer;

    DigitalClock(){
        clock();
        
    }

    public void clock(){

        setSize(400,300);
        setLayout(new BorderLayout());
       


        lab = new JLabel();
        lab.setFont(new Font("Arial", Font.BOLD,48));
        lab.setHorizontalAlignment(JLabel.CENTER);
        updateTime();
        add(lab);

        timer = new Timer(1000, e -> updateTime());
        timer.start();
    

    }

   



    private void updateTime(){
        Date n = new Date();
        SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");

        String time = f.format(n);

        lab.setText(time);


    }




    public static void main(String[] args) {
        
        DigitalClock frame = new DigitalClock();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Digital Clock");
    }

    
}
