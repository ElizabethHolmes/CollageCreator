package collagecreator;

import java.lang.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class CollageCreator {
    
    public static String portraitDirectoryName;
    public static String landscapeDirectoryName;
    
    //Methods for resizing photo and adding to a panel
    
    public static void createLandscapeLabel (String filename, JPanel panel) {
        try {
            //Image pic = ImageIO.read(new File ("/Users/ElizabethSutton/Desktop/Photos/Landscape/"+filename));
            Image pic = ImageIO.read(new File (landscapeDirectoryName+"/"+filename));
            Image resizedpic = pic.getScaledInstance(800,600,Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(resizedpic));
            panel.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void createPortraitLabel (String filename, JPanel panel) {
        try {
            Image pic = ImageIO.read(new File(portraitDirectoryName+"/"+filename));
            Image resizedpic = pic.getScaledInstance(600,800,Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(resizedpic));
            panel.add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
    public static void main(String[] args) {
        
        //Setting directory names
        landscapeDirectoryName = args[0];
        portraitDirectoryName = args[1];
        
        //Creating containers
        JFrame frame = new JFrame();
        frame.setSize(3900,2622);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.WHITE);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.PAGE_AXIS));
               
        //Creating lists of files to use
        File landscapeDirectory = new File(landscapeDirectoryName);
        File portraitDirectory = new File(portraitDirectoryName);
        ArrayList<String> portraitList = new ArrayList(Arrays.asList(portraitDirectory.list())); 
        ArrayList<String> landscapeList = new ArrayList(Arrays.asList(landscapeDirectory.list()));
        
        //Randomising the file order
        Collections.shuffle(portraitList);
        Collections.shuffle(landscapeList);
        
        //Adding photos to panels
        for (int i=0; i<18; i++) {
            if (i<4) {              
                createLandscapeLabel(landscapeList.get(i), panel1);
            } else if (i<7) {
                createPortraitLabel(portraitList.get(i-4), panel2);
            } else if (i<11) {
                createLandscapeLabel(landscapeList.get(i-3), panel3);
            } else if (i<14) {
                createPortraitLabel(portraitList.get(i-8), panel4);
            } else {
                createLandscapeLabel(landscapeList.get(i-6), panel5);
            }
           
        }

        //Adding panels to frame
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.setVisible(true);
        
        //Saving contents of frame as file
        Container content = frame.getContentPane();
        BufferedImage img = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        content.printAll(g2d);
        g2d.dispose();
        try {
            ImageIO.write(img, "jpg", new File("collage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    System.exit(0);
    }
}
