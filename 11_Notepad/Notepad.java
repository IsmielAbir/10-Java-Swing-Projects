import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Notepad extends JFrame implements ActionListener{

    JTextArea text;
    private String fileName = "Untitled";
    UndoManager undoManager;

    JMenuBar menuBar;
    JMenu file, edit, format, help;
    JMenuItem newItem, openItem, saveItem, saveAsItem, exitItem, copyItem, pasteItem, undoItem, deleteItem, wordItem, aboutItem;

    Notepad(){
        dream();
        undoManager = new UndoManager();
        text.getDocument().addUndoableEditListener(undoManager);
    }
    public void dream(){
        setSize(400,400);
        setLayout(new BorderLayout());


        text = new JTextArea();
        text.setFont(new Font("Arial", Font.PLAIN, 14));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(text);


        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        file = new JMenu("File");
        edit = new JMenu("Edit");
        format = new JMenu("Format");
        help = new JMenu("Help");

        newItem = new JMenuItem("New Window");
        newItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));

        openItem = new JMenuItem("Open");
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        saveItem = new JMenuItem("Save");
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAsItem = new JMenuItem("Save as");
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        exitItem = new JMenuItem("Exit");
        copyItem = new JMenuItem("Copy");
        copyItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));

        pasteItem = new JMenuItem("Paste");
        pasteItem.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));

        undoItem = new JMenuItem("Undo");
        undoItem.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));

        deleteItem = new JMenuItem("Delete");
        wordItem = new JMenuItem("Word Wrap");
        aboutItem = new JMenuItem("About");



        add(scroll, BorderLayout.CENTER);


        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(format);
        menuBar.add(help);


        file.add(newItem);
        file.addSeparator();
        file.add(openItem);
        file.addSeparator();
        file.add(saveItem);
        file.addSeparator();
        file.add(saveAsItem);
        file.addSeparator();
        file.add(exitItem);


        edit.add(copyItem);
        edit.addSeparator();
        edit.add(pasteItem);
        edit.addSeparator();
        edit.add(undoItem);
        edit.addSeparator();
        edit.add(deleteItem);


        format.add(wordItem);
        help.add(aboutItem);


        newItem.addActionListener(this);
        exitItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        saveAsItem.addActionListener(this);
        copyItem.addActionListener(this);
        pasteItem.addActionListener(this);
        undoItem.addActionListener(this);
        deleteItem.addActionListener(this);
        wordItem.addActionListener(this);
        aboutItem.addActionListener(this);


    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==newItem){
           Notepad ab = new Notepad();
           ab.setVisible(true);
           ab.setDefaultCloseOperation(Notepad.DISPOSE_ON_CLOSE);
           ab.setTitle("New Dream");
        }

        else if(e.getSource()==exitItem){
            System.exit(0);
        }
      else if(e.getSource()==deleteItem){
        System.exit(0);
      }
      else if(e.getSource()==aboutItem){
        JOptionPane.showMessageDialog(this, "This is a simple notepad application created using Java Swing. Developed by Ismiel Abir", "About Notepad", JOptionPane.INFORMATION_MESSAGE);

      }
      else if(e.getSource()==wordItem){
        JOptionPane.showMessageDialog(this, "Word Wrap Option Is On", "Word Wrap", JOptionPane.INFORMATION_MESSAGE);
       
      }
      else if(e.getSource()==undoItem){
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
        
      }
      else if(e.getSource()==copyItem){
        text.copy();
      }
      else if(e.getSource()==pasteItem){
        text.paste();
      }
      else if(e.getSource()==openItem){
        JFileChooser fileChoser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "dream");
        fileChoser.setFileFilter(filter);
        int r = fileChoser.showOpenDialog(this);
        if(r==JFileChooser.APPROVE_OPTION){
          fileName = fileChoser.getSelectedFile().getPath();
          setTitle(fileName+ "- Dream");
          try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            text.read(reader,null);
            reader.close();
          }
          catch(IOException ex){
            ex.printStackTrace();

          }
        }
      
    }
    else if(e.getSource()==saveItem){
      JFileChooser fileChooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "dream");
      fileChooser.setFileFilter(filter);
      int r = fileChooser.showOpenDialog(this);
      if(r==JFileChooser.APPROVE_OPTION){
        fileName = fileChooser.getSelectedFile().getPath();
        if (!fileName.endsWith(".dream")) {
          fileName += ".txt";
      }
        setTitle(fileName+"- Dream");
        try{
          FileWriter writer = new FileWriter(fileName);
          text.write(writer);
          writer.close();
          
        }
        catch(IOException ex){
          ex.printStackTrace();
        }
      }
    }
    else if(e.getSource()==saveAsItem){
      JFileChooser fileChooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "dream");
      fileChooser.setFileFilter(filter);
      int r = fileChooser.showOpenDialog(this);
      if(r==JFileChooser.APPROVE_OPTION){
        fileName = fileChooser.getSelectedFile().getPath();
        if(!fileName.endsWith(".dream")){
          fileName+=".txt";

        }
        setTitle(fileName+"- Dream");
      }
      try{
        FileWriter writer = new FileWriter(fileName);
        text.write(writer);
        writer.close();

      }
      catch(IOException ex){
        ex.printStackTrace();
      }
    }

  }
    public static void main(String[] args) {
        Notepad frame = new Notepad();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Dream");
        
    }
}
