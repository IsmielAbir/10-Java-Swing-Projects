import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class To_Do_List extends JFrame implements ActionListener{

    JTextField text;
    JButton btn, btn1;
    JList<String> list;
    DefaultListModel<String> model;

    To_Do_List(){
        sequence();
    }

    public void sequence(){
        setSize(400,400);
        setLayout(new BorderLayout());

      JPanel inputPanel = new JPanel(new BorderLayout());

        btn = new JButton("Add");
        btn.setFont( new Font("Arial", Font.BOLD, 26));
        inputPanel.add(btn, BorderLayout.EAST);

        text = new JTextField();
        text.setFont( new Font("Arial", Font.BOLD, 26));
        inputPanel.add(text, BorderLayout.CENTER);

        btn1 = new JButton("Remove");
        btn1.setFont( new Font("Arial", Font.BOLD, 26));
        add(btn1, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.NORTH);



        model = new DefaultListModel<>();
        list = new JList<>(model);

        JScrollPane scroll = new JScrollPane(list);

        add(scroll, BorderLayout.CENTER);
        
        btn.addActionListener(this);
        btn1.addActionListener(this);


    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn){
            String t = text.getText();
            if(!t.equals("")){
                String listItem = String.format("%d. %s", model.getSize() + 1, t);
                model.addElement(listItem);
                text.setText("");
            }

        }
        else if(e.getSource()==btn1){
            int i = list.getSelectedIndex();
            if(i !=-1){
                model.remove(i);
            }
        }
    }



    public static void main(String[] args) {
        To_Do_List frame = new To_Do_List();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("To Do List");

    }
}
