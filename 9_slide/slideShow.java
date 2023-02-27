import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Container;

public class slideShow extends JFrame implements ActionListener{


    Container c;
    JPanel jp;
    JButton btn1, btn2;
    ImageIcon icon;
    JLabel lab;
    CardLayout card;

    slideShow(){


        slide();

       addImage();


    }

    public void addImage(){

        String[] imageName = {"1.JPG", "2.JPG", "3.JPG", "4.JPG"};


        for(String n:imageName){
            icon = new ImageIcon("assets/"+n);

            Image img = icon.getImage();
            Image newImage = img.getScaledInstance(jp.getWidth(), jp.getHeight(), Image.SCALE_SMOOTH);

            icon = new ImageIcon(newImage);
            lab = new JLabel(icon);
            jp.add(lab);
        }


    }


    public void slide(){

        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        card = new CardLayout();

        jp = new JPanel(card);
        jp.setBounds(20,10,450,450);
        c.add(jp);

        btn1 = new JButton("Next");
        btn1.setBounds(390,480, 80,40);
        c.add(btn1);


        btn2 = new JButton("Previous");
        btn2.setBounds(20,480, 100,40);
        c.add(btn2);

        btn1.addActionListener(this);
        btn2.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btn1){
            card.previous(jp);

        }
        if(e.getSource()==btn2){
            card.next(jp);
        }
    }

    


    public static void main(String[] args) {

        slideShow frame = new slideShow();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(10,50,500,600);
        frame.setTitle("Slide Show");
        

        
    }
}