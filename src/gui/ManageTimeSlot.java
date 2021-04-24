package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * the first start page of gui, can go to register page or login into system
 *
 * @author KC
 */
public class ManageTimeSlot extends JFrame {

    private JPanel contentPane;
    private JTextField timeslotidText;
    private JTextField timestartText, timeendText;
    private JFrame mainFrame;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Create the Login frame.
     */
    public ManageTimeSlot() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 300);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel centerPanel = new JPanel();
        contentPane.setBounds(26, 36, 325, 226);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Manage Time Slot");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(210, 14, 204, 29);
        contentPane.add(title);

        JLabel userLabel = new JLabel("Time Slot ID");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userLabel.setBounds(200, 70, 70, 15);
        contentPane.add(userLabel);
        
        String timeslotID[] = {"1","2","3"};
        JComboBox timeslotIDlabel = new JComboBox(timeslotID);
        timeslotIDlabel.setBounds(300,60,100,30);
        contentPane.add(timeslotIDlabel);
        

        JLabel timestartLabel = new JLabel("Time Start");
        timestartLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timestartLabel.setBounds(200, 115, 60, 15);
        contentPane.add(timestartLabel);

        timestartText = new JTextField();
        timestartText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timestartText.setBounds(300, 112, 100, 21);
        contentPane.add(timestartText);

        JLabel timeendLabel = new JLabel("Time End");
        timeendLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeendLabel.setBounds(200, 155, 54, 15);
        contentPane.add(timeendLabel);

        timeendText = new JTextField();
        timeendText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeendText.setBounds(300, 150, 100, 21);
        contentPane.add(timeendText);
  
        JButton AddTimeSlot = new JButton("Add");
        AddTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addButtonActionPerformed(e);
                
            }


        });
        AddTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        AddTimeSlot.setBounds(20, 206, 85, 23);
        contentPane.add(AddTimeSlot);

        JButton editTimeSlot = new JButton("Edit");
        editTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            int a = JOptionPane.showConfirmDialog(editTimeSlot,"Are You Sure Edit?");
              switch (a) {
            case JOptionPane.YES_OPTION:
                System.out.println("You clicked YES"); break;
            case JOptionPane.NO_OPTION:
                System.out.println("You clicked NO"); break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("You clicked Cancel"); break;
                }
            }
        });
        editTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        editTimeSlot.setBounds(110, 206, 85, 23);
        contentPane.add(editTimeSlot);
        
        
        JButton deleteTimeSlot = new JButton("Delete");   
        deleteTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(deleteTimeSlot,"Are You Sure Delete?");
              switch (a) {
            case JOptionPane.YES_OPTION:
                System.out.println("You clicked YES"); break;
            case JOptionPane.NO_OPTION:
                System.out.println("You clicked NO"); break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("You clicked Cancel"); break;
                }
            }
        });
        deleteTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        deleteTimeSlot.setBounds(200, 206, 85, 23);
        contentPane.add(deleteTimeSlot);
        
       JButton viewTimeSlot = new JButton("View");
        viewTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewButtonActionPerformed(e);
            }
        });
        viewTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        viewTimeSlot.setBounds(290, 206, 85, 23);
        contentPane.add(viewTimeSlot);
        
        JButton exitTimeSlot = new JButton("Exit");
        exitTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        exitTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        exitTimeSlot.setBounds(450, 206, 85, 23);
        contentPane.add(exitTimeSlot);

        centerPanel.setLayout(new GridLayout(5, 1, 0, -5));

    }
    
    private void addButtonActionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null, "Click Add");
                 
            JFrame addMenu = new JFrame("Add Time Slot");

            addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
            
            JLabel t1 = new JLabel("Enter Customer ID");  
            t1.setBounds(100,100, 200,30); 
            addMenu.add(t1);
            
            JTextField tt1 = new JTextField();
            tt1.setBounds(250,100, 200,30);
            addMenu.add(tt1);
            
           JLabel t2 = new JLabel("Enter Time Start");  
            t2.setBounds(100,150, 200,30); 
            addMenu.add(t2);

            JTextField tt2 = new JTextField();  
            tt2.setBounds(250,150, 200,30); 
            addMenu.add(tt2);
  
            JLabel t3 = new JLabel("Enter Time End");  
            t3.setBounds(100,200, 200,30);  
            addMenu.add(t3);
            
            JTextField tt3 = new JTextField();  
            tt3.setBounds(250,200, 200,30);  
            addMenu.add(tt3);
            
            
            JButton b1 = new JButton("Save");  
            b1.setBounds(200,300,75,30); 
            addMenu.add(b1);
            
  
            JButton b2 = new JButton("Exit");  
            b2.setBounds(290,300,75,30); 
            addMenu.add(b2);
                
            addMenu.setLayout(null);
            addMenu.setVisible(true);
            addMenu.setResizable(false);
            addMenu.setSize(600, 400);   
       
    }
                   
        private void viewButtonActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Click View");
           JFrame addMenu = new JFrame("View Time Slot");

            addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JButton b1 = new JButton("Exit");  
                b1.setBounds(250,300,95,30); 
                addMenu.add(b1);
                
                String data[][]={ {"1","0800","1000"},    
                                    {"2","1000","1200"},    
                                    {"3","1400","1600"}};   
                
                String column[] = {"ID","Time Start","Time End"};   
                
                JTable jt = new JTable(data,column);    
                jt.setBounds(30,40,200,300);          
                JScrollPane sp = new JScrollPane(jt);    
                addMenu.add(sp);          
                addMenu.setSize(600,400);

                
                addMenu.setVisible(true);    
 
    }
        
}
