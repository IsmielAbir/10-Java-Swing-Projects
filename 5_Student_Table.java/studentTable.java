import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;

public class studentTable extends JFrame implements ActionListener{

    Container c;
    JLabel lab1, lab2, lab3, lab4, lab5;
    JTextField t1,t2,t3,t4;
    Font f;
    JButton b1,b2,b3,b4;
    JTable table;
    DefaultTableModel model;
    JScrollPane scroll;


    String[] col = {"First Name", "Last Name", "Phone", "Semester"};
    String[] row = new String[4];

    studentTable(){
        SMTable();
    }

    public void SMTable(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.CYAN);

        f = new Font("Arial", Font.BOLD, 24);

        lab1 = new JLabel("Student Management Table");
        lab1.setBounds(450,60,400,30);
        lab1.setFont(f);
        c.add(lab1);

        lab2 = new JLabel("First Name: ");
        lab2.setBounds(70,140,150,30);
        lab2.setFont(f);
        c.add(lab2);

        lab3 = new JLabel("Last Name: ");
        lab3.setBounds(70,210,150,30);
        lab3.setFont(f);
        c.add(lab3);


        lab4 = new JLabel("Phone: ");
        lab4.setBounds(70,280,150,30);
        lab4.setFont(f);
        c.add(lab4);

        lab5 = new JLabel("Semester: ");
        lab5.setBounds(70,350,150,30);
        lab5.setFont(f);
        c.add(lab5);

   
        t1 = new JTextField();
        t1.setBounds(250, 140, 200, 30);
        t1.setFont(f);
        c.add(t1);

        t2 = new JTextField();
        t2.setBounds(250, 210, 200, 30);
        t2.setFont(f);
        c.add(t2);

        t3 = new JTextField();
        t3.setBounds(250, 280, 200, 30);
        t3.setFont(f);
        c.add(t3);

        t4 = new JTextField();
        t4.setBounds(250, 350, 200, 30);
        t4.setFont(f);
        c.add(t4);

        b1 = new JButton("ADD");
        b1.setBounds(70,430, 100, 40);
        b1.setFont(f);
        c.add(b1);

        b2 = new JButton("UPDATE");
        b2.setBounds(200,430, 150, 40);
        b2.setFont(f);
        c.add(b2);

        b3 = new JButton("DELETE");
        b3.setBounds(380,430, 150, 40);
        b3.setFont(f);
        c.add(b3);

        b4 = new JButton("CLEAR");
        b4.setBounds(560,430, 150, 40);
        b4.setFont(f);
        c.add(b4);


        table = new JTable();


        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table.setModel(model);
        table.setRowHeight(30);
        table.setFont(f);
        table.setBackground(Color.lightGray);
        table.setSelectionBackground(Color.GREEN);

        scroll = new JScrollPane(table);
        scroll.setBounds(70, 520, 1030, 200);
        c.add(scroll);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);



        table.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent me){
                int numRow = table.getSelectedRow();

                String fn = model.getValueAt(numRow, 0).toString();
                String ln = model.getValueAt(numRow, 1).toString();
                String ph = model.getValueAt(numRow, 2).toString();
                String se = model.getValueAt(numRow, 3).toString();

                t1.setText(fn);
                t2.setText(ln);
                t3.setText(ph);
                t4.setText(se);
            }
    
         });
        

    }


    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==b1){

            row[0] = t1.getText(); 
            row[1] = t2.getText(); 
            row[2] = t3.getText(); 
            row[3] = t4.getText(); 
            model.addRow(row);

        }

        else if(e.getSource()==b2){

            int numsel = table.getSelectedRow();

            String f_n = t1.getText();
            String l_n = t2.getText();
            String p_n = t3.getText();
            String s_n = t4.getText();

            
            model.setValueAt(f_n, numsel, 0);
            model.setValueAt(l_n, numsel, 1);
            model.setValueAt(p_n, numsel, 2);
            model.setValueAt(s_n, numsel, 3);

            
        }

        else if(e.getSource()==b3){

            int n = table.getSelectedRow();
            if(n>=0)
            model.removeRow(n);
            else
            JOptionPane.showMessageDialog(null, "Row is not Exist");
            
        }


        else if(e.getSource()==b4){

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            
        }

    }

    public static void main(String[] args) {
        studentTable frame = new studentTable();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 20, 1200, 800);
        frame.setTitle("Student Management Table");
    }
    
}
