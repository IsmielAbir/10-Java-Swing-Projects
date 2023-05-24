import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ImageViewerEditor extends JFrame {
    
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openItem, saveItem;
    
    public ImageViewerEditor() {
        setTitle("Image Viewer and Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openImage();
            }
        });
        
        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });
        
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        setVisible(true);
    }
    
    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            try {
                BufferedImage image = ImageIO.read(file);
                JLabel label = new JLabel(new ImageIcon(image));
                getContentPane().removeAll();
                getContentPane().add(label);
                pack();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void saveImage() {
        JOptionPane.showMessageDialog(this, "Not implemented yet", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        new ImageViewerEditor();
    }
}
