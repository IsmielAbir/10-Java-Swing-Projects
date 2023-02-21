import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
public class BMI extends JFrame implements ActionListener{

    Container c;
    JLabel t,tw,th, resultLabel;
    JTextField w,h;
    JButton b,ce;
    Font f;


    BMI(){
        bmi_calculation();

    }

    public void bmi_calculation(){

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        f = new Font("Arial", Font.BOLD, 24);

        t = new JLabel("BMI Application");
        t.setBounds(160, 20, 250, 30);
        t.setFont(f);
        c.add(t);

        tw = new JLabel("Enter Your Weight (kg): ");
        tw.setBounds(20,80,350,30);
        tw.setFont(f);
        c.add(tw);

        w = new JTextField();
        w.setBounds(300,80,150,30);
        w.setFont(f);
        c.add(w);

        th = new JLabel("Enter Your height (m) : ");
        th.setBounds(20,130,350,30);
        th.setFont(f);
        c.add(th);

        h = new JTextField();
        h.setBounds(300,130,150,30);
        h.setFont(f);
        c.add(h);

        b = new JButton("BMI");
        b.setBounds(300,190,150,30);
        b.setFont(f);
        c.add(b);


        ce = new JButton("Clear");
        ce.setBounds(160,340,150,30);
        ce.setFont(f);
        c.add(ce);

        resultLabel = new JLabel("");
        resultLabel.setBounds(20, 250, 500, 30);
        resultLabel.setFont(f);
        c.add(resultLabel);


        b.addActionListener(this);
        ce.addActionListener(this);

        

    }
    

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b){
            double ww = Double.parseDouble(w.getText());
            double hh = Double.parseDouble(h.getText());

            double r = ww / (hh*hh);

            
            if(r<=18.5){
                String s = String.format("Underweight: Your BMI is %.2f.", r);
                resultLabel.setText(s);
            }

            
            else if(r>=18.5 && r<=24.9){
                String s = String.format("Normal weight: Your BMI is %.2f.", r);
                resultLabel.setText(s);
            }

            else if(r>=25 && r<=29.9){
                String s = String.format("Overweight: Your BMI is %.2f.", r);
                resultLabel.setText(s);
            }

            else if(r>=30){
                String s = String.format("Obesity: Your BMI is %.2f.", r);
                resultLabel.setText(s);
            }


          


        }
        else if(e.getSource()==ce){
            w.setText("");
            h.setText("");
            resultLabel.setText("");

        }

    }

    public static void main(String[] args) {
        BMI frame = new BMI();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350,20,500,500);
        frame.setTitle("BMI Calculator");
    }
}
