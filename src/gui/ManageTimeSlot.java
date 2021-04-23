/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author KC
 */
public class ManageTimeSlot extends JFrame implements ActionListener {

    JFrame mainFrame = new JFrame();

    JPanel mainPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JLabel header;
    JPanel addPanel = new JPanel();
    JPanel editPanel = new JPanel();
    JPanel deletePanel = new JPanel();
    JPanel viewPanel = new JPanel();
    JPanel exitPanel = new JPanel();

    JButton addButton;
    JButton editButton;
    JButton deleteButton;
    JButton viewButton;
    JButton exitButton;
    
    JTextField tf1,tf2,tf3;  
    JButton b1,b2; 

    public ManageTimeSlot() {
        header = new JLabel("Manage Time Slot");
        addButton = new JButton("ADD");
        editButton = new JButton("EDIT");
        deleteButton = new JButton("DELETE");
        viewButton = new JButton("VIEW");
        exitButton = new JButton("EXIT");
        
        mainFrame.setSize(400, 400);
        mainFrame.setTitle("Manage Gym Room");

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //mainPanel.setBackground(Color.white);
        centerPanel.setBackground(Color.white);
        addPanel.setBackground(Color.white);
        editPanel.setBackground(Color.white);
        deletePanel.setBackground(Color.white);
        viewPanel.setBackground(Color.white);
        exitPanel.setBackground(Color.white);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(null);
        centerPanel.setBounds(25, 35, 325, 300);
        mainFrame.add(mainPanel);
        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(6, 1, 0, -5));

        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Times New Roman", Font.BOLD, 24));

        centerPanel.add(header);

        centerPanel.add(addPanel);
        addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        addPanel.add(addButton);
        addButton.setFont(new Font("Times New Roman", 0, 18));

        centerPanel.add(editPanel);
        editPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        editPanel.add(editButton);
        editButton.setFont(new Font("Times New Roman", 0, 18));

        centerPanel.add(deletePanel);
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        deletePanel.add(deleteButton);
        deleteButton.setFont(new Font("Times New Roman", 0, 18));

        centerPanel.add(viewPanel);
        viewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        viewPanel.add(viewButton);
        viewButton.setFont(new Font("Times New Roman", 0, 18));

        centerPanel.add(exitPanel);
        exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        exitPanel.add(exitButton);
        exitButton.setFont(new Font("Times New Roman", 0, 18));

        addButton.setActionCommand("Add");
        addButton.addActionListener(this);

        /*setResizable(false);
        setVisible(false);
        setResizable(false);*/
        mainFrame.setResizable(true);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        
        editButton.setActionCommand("Edit");
        editButton.addActionListener(this);
        
        deleteButton.setActionCommand("Delete");
        deleteButton.addActionListener(this);
        
        viewButton.setActionCommand("View");
        viewButton.addActionListener(this);
        
        exitButton.setActionCommand("Exit");
        exitButton.addActionListener(this);
        
        
        
        
    }

    public void addTimeSlot() {
        
            JFrame addMenu = new JFrame("Add Time Slot");

            addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainPanel.add(centerPanel);
            
           JTextField t1 = new JTextField("Enter Customer ID");  
            t1.setBounds(50,100, 200,30);  

           JTextField t2 = new JTextField("Enter Time Start");  
            t2.setBounds(50,150, 200,30);  

            JTextField t3 = new JTextField("Enter Time End");  
            t3.setBounds(50,200, 200,30);  

            JButton b1 = new JButton("Save");  
            b1.setBounds(250,300,75,30); 

            
            addMenu.add(t1); addMenu.add(t2); addMenu.add(t3); addMenu.add(b1);
                        
            addMenu.setLayout(null);
            addMenu.setVisible(true);
            addMenu.setResizable(false);
            addMenu.setSize(400, 400);
            
        
    }
      
        public void editTimeSlot() {
            JFrame addMenu = new JFrame("Edit Time Slot");
            JTextField t1,t2;
            
            addMenu.setLayout(null);
            addMenu.setVisible(true);
            addMenu.setResizable(false);
            addMenu.setSize(400, 400);

            addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mainPanel.add(centerPanel);
            
            String customerID[]={"1","2","3"};
            JComboBox cb = new JComboBox(customerID); ; 
            cb.setBounds(50,50,90,20);
            addMenu.add(cb);

            t1 = new JTextField("Enter Time Start");  
            t1.setBounds(50,100, 200,30);  
            addMenu.add(t1);
            t2=new JTextField("Enter Time End");  
            t2.setBounds(50,150, 200,30);  
            addMenu.add(t2);
        
            JButton edit = new JButton("Edit");  
            edit.setBounds(190,300,75,30); 
            addMenu.add(edit);
            
            JButton save = new JButton("Save");  
            save.setBounds(280,300,75,30); 
            addMenu.add(save);
        
    }
 
    public void deleteTimeSlot() {
        JFrame addMenu = new JFrame("Delete Time Slot");

        String customerID[]={"1","2","3"};
        JComboBox cb = new JComboBox(customerID); ; 
        cb.setBounds(50,50,90,20);
        addMenu.add(cb);
        
        JTextField t1 = new JTextField("Enter Time Start");  
        t1.setBounds(50,100,200,30);  
        addMenu.add(t1);
        JTextField t2=new JTextField("Enter Time End");  
        t2.setBounds(50,150,200,30);  
        addMenu.add(t2);
       

        addMenu.setLayout(null);
        addMenu.setVisible(true);
        addMenu.setResizable(false);
        addMenu.setSize(400, 400);

        addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.add(centerPanel);
        
        JButton delete = new JButton("Delete");  
        delete.setBounds(190,300,75,30); 
        addMenu.add(delete);
        
        JButton save = new JButton("Save");  
        save.setBounds(280,300,75,30); 
        addMenu.add(save);
  
    }
     
       public void viewTimeSlot() {
            JFrame addMenu = new JFrame("View Time Slot");

            addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            mainPanel.add(centerPanel);
            
                JButton b1 = new JButton("Cancel");  
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
                addMenu.setSize(400,400);

                
                addMenu.setVisible(true);    
                        
            //addMenu.setLayout(null);
            //addMenu.setResizable(false);
            //addMenu.setSize(400, 400);
    }  
   
      
    public void exitTimeSlot() {
      
    }
    
    public static void main(String[] args) {
        ManageTimeSlot manage = new ManageTimeSlot();
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Add")) {
            JOptionPane.showMessageDialog(this, "Click Add");
            mainFrame.setResizable(false);
            mainFrame.setVisible(false);
            addTimeSlot();
        }
        
        else if (command.equals("Edit")) {
            JOptionPane.showMessageDialog(this, "Click Edit");
            mainFrame.setResizable(false);
            mainFrame.setVisible(false);
            editTimeSlot(); 
        } 
        
        else if (command.equals("Delete")) {
            JOptionPane.showMessageDialog(this, "Click Delete");
            mainFrame.setResizable(false);
            mainFrame.setVisible(false);
            deleteTimeSlot();   
        }
        
        else if (command.equals("View")) {
            JOptionPane.showMessageDialog(this, "Click View");
            mainFrame.setResizable(false);
            mainFrame.setVisible(false);
            viewTimeSlot();   
        }
        
        else
        {
            JOptionPane.showMessageDialog(this, "Click Exit");
            mainFrame.setResizable(false);
            mainFrame.setVisible(false);
            exitTimeSlot();   
        }
        
 
        
    }
    
    
}
