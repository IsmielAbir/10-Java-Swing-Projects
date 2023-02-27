
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.*;

public class vowel extends JFrame{

    Container c;
    JLabel lab1, lab2, alab, elab, ilab, olab, ulab;
    JTextArea textArea;
    JScrollPane scroll;
    Font f;

    int total=0, a=0,e=0,i=0,o=0,u=0;

    vowel(){

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        f = new Font("Arial", Font.BOLD, 20);

        lab1 =  new JLabel("Enter the Text: ");
        lab1.setBounds(20,20,160,20);
        lab1.setFont(f);
        c.add(lab1);


        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scroll = new JScrollPane(textArea);
        scroll.setBounds(180, 20, 550, 400);
        textArea.setFont(f);
        c.add(scroll);


        lab2 = new JLabel();
        lab2.setBounds(180,440,360,20);
        lab2.setFont(f);
        c.add(lab2);

        alab = new JLabel();
        alab.setBounds(180,480,360,20);
        alab.setFont(f);
        c.add(alab);

        elab = new JLabel();
        elab.setBounds(180,520,360,20);
        elab.setFont(f);
        c.add(elab);

        ilab = new JLabel();
        ilab.setBounds(180,560,360,20);
        ilab.setFont(f);
        c.add(ilab);

        olab = new JLabel();
        olab.setBounds(180,600,360,20);
        olab.setFont(f);
        c.add(olab);

        ulab = new JLabel();
        ulab.setBounds(180,640,360,20);
        ulab.setFont(f);
        c.add(ulab);


        textArea.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent ke){
                //throw new UnsupportedOperationException("Not Supported");
            }

            @Override
            public void keyPressed(KeyEvent ke){
                //throw new UnsupportedOperationException("Not Supported");

                if(ke.getSource() == textArea){
                    if(ke.VK_A==ke.getKeyCode()){
                        a++;
                        total++;
                    }

                    if(ke.VK_E==ke.getKeyCode()){
                        e++;
                        total++;
                    }

                    if(ke.VK_I==ke.getKeyCode()){
                        i++;
                        total++;
                    }

                    if(ke.VK_O==ke.getKeyCode()){
                        o++;
                        total++;
                    }

                    if(ke.VK_U==ke.getKeyCode()){
                        u++;
                        total++;
                    }
                }

                lab2.setText("Total number of Vowel: "+total);
                alab.setText("Total number of A: "+a);
                elab.setText("Total number of E: "+e);
                ilab.setText("Total number  of I: "+i);
                olab.setText("Total number of O: "+o);
                ulab.setText("Total number of U: "+u);

            }

            @Override
            public void keyReleased(KeyEvent ke){
                //throw new UnsupportedOperationException("Not Supported");
            }


        });

        
    }


    public static void main(String[] args) {
        vowel frame = new vowel();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,20,800,800);
        frame.setTitle("Count Vowel");
    
    }
    
}
