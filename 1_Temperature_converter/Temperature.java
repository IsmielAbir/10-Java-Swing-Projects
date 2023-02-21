import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

public class Temperature extends JFrame implements ActionListener{

    Container c;
    JLabel text, cel,cel1, fer, k, text1, cel2, fer1, text2, cel3;
    JTextField celT, ferT, celT1, ferT1, k1, celT2;
    JButton b1, c1,b2,c2,b3,c3;
    Font f;
    Temperature(){
        temp();
    }

    public void temp(){

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        f = new Font("Areal", Font.BOLD, 24);

        text = new JLabel("Temperature Conversion Application");
        text.setBounds(310,20,450,30);
        text.setFont(f);
        c.add(text);


        cel = new JLabel("1. Celsius to Fahrenheit");
        cel.setBounds(20,100,300,30);
        cel.setFont(f);
        c.add(cel);


        cel1 = new JLabel("Celsius: ");
        cel1.setBounds(150,160,200,30);
        cel1.setFont(f);
        c.add(cel1);

        celT = new JTextField();
        celT.setBounds(250,160,180,30);
        celT.setFont(f);
        c.add(celT);


        fer = new JLabel("Fahrenheit: ");
        fer.setBounds(110,220,250,30);
        fer.setFont(f);
        c.add(fer);

        ferT = new JTextField();
        ferT.setBounds(250,220,180,30);
        ferT.setFont(f);
        c.add(ferT);


        b1 = new JButton("Convert");
        b1.setBounds(480, 160, 150, 30);
        b1.setFont(f);
        c.add(b1);

        c1 = new JButton("Clear");
        c1.setBounds(480, 220, 150, 30);
        c1.setFont(f);
        c.add(c1);


        text1 = new JLabel("2. Fahrenheit to Celsius");
        text1.setBounds(20,300,300,30);
        text1.setFont(f);
        c.add(text1);

        cel2 = new JLabel("Fahrenheit: ");
        cel2.setBounds(110,360,200,30);
        cel2.setFont(f);
        c.add(cel2);

        celT1 = new JTextField();
        celT1.setBounds(250,360,180,30);
        celT1.setFont(f);
        c.add(celT1);


        fer1 = new JLabel("Celsius: ");
        fer1.setBounds(150,420,250,30);
        fer1.setFont(f);
        c.add(fer1);

        ferT1 = new JTextField();
        ferT1.setBounds(250,420,180,30);
        ferT1.setFont(f);
        c.add(ferT1);


        b2 = new JButton("Convert");
        b2.setBounds(480, 360, 150, 30);
        b2.setFont(f);
        c.add(b2);

        c2 = new JButton("Clear");
        c2.setBounds(480, 420, 150, 30);
        c2.setFont(f);
        c.add(c2);
        


        text2 = new JLabel("3. Celsius to Kelvin:");
        text2.setBounds(20,500,300,30);
        text2.setFont(f);
        c.add(text2);

        cel3 = new JLabel("Celsius: ");
        cel3.setBounds(150,560,200,30);
        cel3.setFont(f);
        c.add(cel3);

        celT2 = new JTextField();
        celT2.setBounds(250,560,180,30);
        celT2.setFont(f);
        c.add(celT2);


        k = new JLabel("Celsius: ");
        k.setBounds(150,620,250,30);
        k.setFont(f);
        c.add(k);

        k1 = new JTextField();
        k1.setBounds(250,620,180,30);
        k1.setFont(f);
        c.add(k1);


        b3 = new JButton("Convert");
        b3.setBounds(480, 560, 150, 30);
        b3.setFont(f);
        c.add(b3);

        c3 = new JButton("Clear");
        c3.setBounds(480, 620, 150, 30);
        c3.setFont(f);
        c.add(c3);
        



        b1.addActionListener(this);
        c1.addActionListener(this);
        b2.addActionListener(this);
        c2.addActionListener(this);
        b3.addActionListener(this);
        c3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==c1){
            celT.setText("");
            ferT.setText("");
        }

        else if(e.getSource()==b1){
            double celceius = Double.parseDouble(celT.getText());
            double cal = (celceius * 1.8) + 32;
            
            String n = String.valueOf(cal);

            ferT.setText(n);

        }

       else if(e.getSource()==c2){
            celT1.setText("");
            ferT1.setText("");
        }

        else if(e.getSource()==b2){
            double celceius = Double.parseDouble(celT1.getText());
            double cal = (celceius -32 ) /1.8;
            
            String n = String.valueOf(cal);

            ferT1.setText(n);

        }

        else if(e.getSource()==c3){
            celT2.setText("");
            k1.setText("");
        }

        else if(e.getSource()==b3){
            double celceius = Double.parseDouble(celT2.getText());
            double cal = (celceius +273.15 );
            
            String n = String.valueOf(cal);

            k1.setText(n);

        }
    }


    public static void main(String[] args) {
        Temperature frame = new Temperature();
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setBounds(300,40,1050,800);
         frame.setTitle("Temperature Converter");

    }
}