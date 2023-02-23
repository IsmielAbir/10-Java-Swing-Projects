import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;

public class Library extends JFrame implements ActionListener{

    Container c;
    JLabel text, t1, t2,t3,t4,t5,t6;
    JTextField f1,f2,f3,f4,f5,f6;
    JButton b1,b2;
    Font f;
    JTable table;
    JScrollPane scroll;
    DefaultTableModel model;


    String[] col = {"ISBN", "Title", "Author", "Student Name", "Student ID", "Date"};
    String[] row = new String[6];

    Library(){
        lib();
    }

    public void lib(){

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.cyan);

        f = new Font("Arial", Font.BOLD, 22);

        text = new JLabel("Library Management System");
        text.setBounds(580,20,400,30);
        text.setFont(f);
        c.add(text);

        t1 = new JLabel("Enter ISBN: ");
        t1.setBounds(40,90,200,30);
        t1.setFont(f);
        c.add(t1);

        f1 = new JTextField();
        f1.setFont(f);
        f1.setBounds(200,90,200,30);
        c.add(f1);

        t2 = new JLabel("Enter Title: ");
        t2.setBounds(40,150,200,30);
        t2.setFont(f);
        c.add(t2);

        f2 = new JTextField();
        f2.setFont(f);
        f2.setBounds(200,150,200,30);
        c.add(f2);

        
        t3 = new JLabel("Enter Author: ");
        t3.setBounds(40,210,200,30);
        t3.setFont(f);
        c.add(t3);

        f3 = new JTextField();
        f3.setFont(f);
        f3.setBounds(200,210,200,30);
        c.add(f3);


        t4 = new JLabel("Student Name: ");
        t4.setBounds(40,270,200,30);
        t4.setFont(f);
        c.add(t4);

        f4 = new JTextField();
        f4.setFont(f);
        f4.setBounds(200,270,200,30);
        c.add(f4);


        t5 = new JLabel("Student ID: ");
        t5.setBounds(40,330,200,30);
        t5.setFont(f);
        c.add(t5);

        f5 = new JTextField();
        f5.setFont(f);
        f5.setBounds(200,330,200,30);
        c.add(f5);


        t6 = new JLabel("Borrow Date: ");
        t6.setBounds(40,390,200,30);
        t6.setFont(f);
        c.add(t6);

        f6 = new JTextField();
        f6.setFont(f);
        f6.setBounds(200,390,200,30);
        c.add(f6);


        b1 = new JButton("Submit");
        b1.setBounds(40,460,120,40);
        b1.setFont(f);
        c.add(b1);

        b2 = new JButton("Clear");
        b2.setBounds(200,460,120,40);
        b2.setFont(f);
        c.add(b2);


       table = new JTable();

       model = new DefaultTableModel();
       model.setColumnIdentifiers(col);

       table.setModel(model);
       table.setRowHeight(30);
       table.setFont(f);
       table.setBackground(Color.WHITE);
       table.setSelectionBackground(Color.GREEN);
    

       scroll = new JScrollPane(table);
       scroll.setBounds(500, 80, 900, 600);
       c.add(scroll);
        


        b1.addActionListener(this);
        b2.addActionListener(this);


        

    }

    


    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b2){

        f1.setText("");
        f2.setText("");
        f3.setText("");
        f4.setText("");
        f5.setText("");
        f6.setText("");

        }

        else if(e.getSource()==b1){
            row[0] = f1.getText();
            row[1] = f2.getText();
            row[2] = f3.getText();
            row[3] = f4.getText();
            row[4] = f5.getText();
            row[5] = f6.getText();
            model.addRow(row);
        }

        



        

    }


    public static void main(String[] args) {

        Library frame = new Library();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50,20,1500,800);
        frame.setTitle("Library Management");
        
    }
}