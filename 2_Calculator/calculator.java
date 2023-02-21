import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Container;

public class calculator extends JFrame implements ActionListener{

    Container c;
    JTextField text;
    Font f;

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0, bp,bm,bmu,bd,be,bc;

    calculator(){
        calculation();
    }

    public void calculation(){

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        f = new Font("Arial", Font.BOLD, 24);

        text = new JTextField();
        text.setBounds(5,5,288,50);
        text.setBackground(Color.lightGray);
        text.setFont(f);
        c.add(text);


        b7 = new JButton("7");
        b7.setBounds(5, 100, 60, 30);
        b7.setFont(f);
        c.add(b7);

        b8 = new JButton("8");
        b8.setBounds(80, 100, 60, 30);
        b8.setFont(f);
        c.add(b8);

        b9 = new JButton("9");
        b9.setBounds(155, 100, 60, 30);
        b9.setFont(f);
        c.add(b9);

        bp = new JButton("+");
        bp.setBounds(230, 100, 60, 30);
        bp.setFont(f);
        c.add(bp);




        
        b4 = new JButton("4");
        b4.setBounds(5, 140, 60, 30);
        b4.setFont(f);
        c.add(b4);

        b5 = new JButton("5");
        b5.setBounds(80, 140, 60, 30);
        b5.setFont(f);
        c.add(b5);

        b6 = new JButton("6");
        b6.setBounds(155, 140, 60, 30);
        b6.setFont(f);
        c.add(b6);

        bm = new JButton("-");
        bm.setBounds(230, 140, 60, 30);
        bm.setFont(f);
        c.add(bm);





        
        b1 = new JButton("1");
        b1.setBounds(5, 180, 60, 30);
        b1.setFont(f);
        c.add(b1);

        b2 = new JButton("2");
        b2.setBounds(80, 180, 60, 30);
        b2.setFont(f);
        c.add(b2);

        b3 = new JButton("3");
        b3.setBounds(155, 180, 60, 30);
        b3.setFont(f);
        c.add(b3);

        bmu = new JButton("*");
        bmu.setBounds(230, 180, 60, 30);
        bmu.setFont(f);
        c.add(bmu);




        
        bc = new JButton("C");
        bc.setBounds(5, 220, 60, 30);
        bc.setFont(f);
        c.add(bc);

        b0 = new JButton("0");
        b0.setBounds(80, 220, 60, 30);
        b0.setFont(f);
        c.add(b0);

        be = new JButton("=");
        be.setBounds(155, 220, 60, 30);
        be.setFont(f);
        c.add(be);

        bd = new JButton("/");
        bd.setBounds(230, 220, 60, 30);
        bd.setFont(f);
        c.add(bd);



        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        bp.addActionListener(this);
        bm.addActionListener(this);
        bmu.addActionListener(this);
        bd.addActionListener(this);
        be.addActionListener(this);
        bc.addActionListener(this);




    }


    


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==bc)
        text.setText("");

        else if(e.getSource()==b1)
        text.setText(text.getText()+"1");

        else if(e.getSource()==b2)
        text.setText(text.getText()+"2");
        else if(e.getSource()==b3)
        text.setText(text.getText()+"3");

        else if(e.getSource()==b4)
        text.setText(text.getText()+"4");
        else if(e.getSource()==b5)
        text.setText(text.getText()+"5");

        else if(e.getSource()==b6)
        text.setText(text.getText()+"6");
        else if(e.getSource()==b7)
        text.setText(text.getText()+"7");

        else if(e.getSource()==b8)
        text.setText(text.getText()+"8");
        else if(e.getSource()==b9)
        text.setText(text.getText()+"9");

        else if(e.getSource()==b0)
        text.setText(text.getText()+"0");
        else if(e.getSource()==bp)
        text.setText(text.getText()+"+");

     


        else if(e.getSource()==bm)
        text.setText(text.getText()+"-");
        else if(e.getSource()==bmu)
        text.setText(text.getText()+"*");

        else if(e.getSource()==bd)
        text.setText(text.getText()+"/");


        else if(e.getSource()==be){
            String expression = text.getText();
            String[] numbers = expression.split("[+\\-*/]");
            double num1 = Double.parseDouble(numbers[0]);
            double num2 = Double.parseDouble(numbers[1]);
            double result = 0;
            if(expression.contains("+"))
            result = num1+num2;
            else if(expression.contains("-"))
            result = num1-num2;
            else if(expression.contains("*"))
            result = num1*num2;
            else if(expression.contains("/"))
            result = num1/num2;

            text.setText(Double.toString(result));

        }
    }

  

    public static void main(String[] args) {
        
        calculator frame = new calculator();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.setBounds(600,200,315,300);
    }
}