package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import main.Controller;

import basic.*;
import java.util.ArrayList;
import main.*;

/**
 * the first start page of gui, can go to register page or login into system
 *
 * @author KC
 */
public class ManageTimeSlot extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;
    private JComboBox timeslotidList;
    private JTextField timeslotidText;
    private JTextField timestartText;
    private JTextField timeendText;
 
    
    //private JFrame mainFrame;
    //private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Create the Login frame.
     */
    public ManageTimeSlot() {
        c.loadDatabase("gbsdb");//connect db
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 330);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel centerPanel = new JPanel();
        contentPane.setBounds(26, 36, 325, 226);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Manage Time Slot");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(210, 14, 204, 29);
        contentPane.add(title);

        JLabel timeslotidLabel = new JLabel("Select ID");
        timeslotidLabel.setLabelFor(this);
        timeslotidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeslotidLabel.setBounds(200, 70, 70, 15);
        contentPane.add(timeslotidLabel);
               
         
        String[] listAvailable = getTimeSlotList();
        timeslotidList = new JComboBox(listAvailable);
        timeslotidList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectCbListActionPerformed(e);
            }
        });
        timeslotidList.setBounds(300, 70, 100, 21);
        contentPane.add(timeslotidList);
        
        JLabel timeidLabel = new JLabel("Time Slot ID");
        timeidLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeidLabel.setBounds(200, 115, 100, 15);
        contentPane.add(timeidLabel);

        timeslotidText = new JTextField();
        timeslotidText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeslotidText.setBounds(300, 112, 100, 21);
        contentPane.add(timeslotidText);
        timeslotidText.setColumns(10);
        
        JLabel timestartLabel = new JLabel("Time Start");
        timestartLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timestartLabel.setBounds(200, 155, 100, 15);
        contentPane.add(timestartLabel);

        timestartText = new JTextField();
        timestartText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timestartText.setBounds(300, 150, 100, 21);
        contentPane.add(timestartText);
        timestartText.setColumns(10);
        
        JLabel timeendLabel = new JLabel("Time End");
        timeendLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeendLabel.setBounds(200, 190, 54, 15);
        contentPane.add(timeendLabel);

        timeendText = new JTextField();
        timeendText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeendText.setBounds(300, 190, 100, 21);
        contentPane.add(timeendText);
        timeendText.setColumns(10);
 
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
            saveCusButtonActionPerformed(e);  
            }
        });
        editTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        editTimeSlot.setBounds(110, 206, 85, 23);
        contentPane.add(editTimeSlot);
        
        
        JButton deleteTimeSlot = new JButton("Delete");   
        deleteTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delCusButtonActionPerformed(e);
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
                exitButtonActionPerformed(e);
            }
        });
        exitTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        exitTimeSlot.setBounds(450, 206, 85, 23);
        contentPane.add(exitTimeSlot);

        centerPanel.setLayout(new GridLayout(5, 1, 0, -5));

    }
    
        private String[] getTimeSlotList() {
        ArrayList<TimeSlot> list = c.getAllTimeSlot();
        Object[] time = list.toArray();
        String[] dataList = new String[list.size()];
        for (int i = 0; i < time.length; i++) {
            dataList[i] = Integer.toString(((TimeSlot) time[i]).ID);
        }
        return dataList;
    }
        
    private void selectCbListActionPerformed(ActionEvent evt) {
        timeslotidText.setText((String) timeslotidList.getItemAt(timeslotidList.getSelectedIndex()));//username
        String TimeID = (String) timeslotidList.getItemAt(timeslotidList.getSelectedIndex());//get username from combobox
        int timeslotSelect = Integer.valueOf(TimeID);
        TimeSlot time = c.getTimeSlot(timeslotSelect);//get customer from database base on username given
        timestartText.setText(time.getTimeStart());//name
        timeendText.setText(time.getTimeEnd());//passsword

    }
        
    private void addButtonActionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null, "Click Add");
                 
            JFrame addMenu = new JFrame("Add Time Slot");

            addMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
            
            addMenu.setLayout(null);
            addMenu.setVisible(true);
            addMenu.setResizable(false);
            addMenu.setSize(600, 400);   

    }
    
        private void saveCusButtonActionPerformed(ActionEvent evt) {
        //store index of selected
        int indexSelect =  timeslotidList.getSelectedIndex();
        //get the username
        String IDSelect = (String) timeslotidList.getItemAt(indexSelect);
        //customer object to update
        int idselect = Integer.parseInt(IDSelect);
        TimeSlot timeslot = c.getTimeSlot(idselect);
        
        timeslot.setTimeStart(timestartText.getText());
        timeslot.setTimeEnd(timeendText.getText());
        if (timeslotidList.getItemCount() != 0) {
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to change " + IDSelect  + " ?");
            if (a == JOptionPane.YES_OPTION) {
                //send to update control
                if (c.updateTimeSlot(timeslot)) {//update success will true
                    //not need reflsesh comboBox, when select username at combobox will search in database
                    JOptionPane.showMessageDialog(null, "Done Save");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot edit!", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }
        
        private void clearTextField() {
        timeslotidText.setText("");
        timestartText.setText("");
        timeendText.setText("");
 
    }

    private void loadList() {
        String[] listAvailable = getTimeSlotList();
        timeslotidList.removeAllItems();//clear all item comboBoxList
        for (String list : listAvailable) {
            timeslotidList.addItem(list);//add item into comboBoxList
        }
    }

    private void delCusButtonActionPerformed(ActionEvent evt) {
        //store index of selected
        int indexSelect = timeslotidList.getSelectedIndex();
        //get the username
        String timeidSelect = (String) timeslotidList.getItemAt(indexSelect);
        int idselect = Integer.parseInt(timeidSelect);
        if (timeslotidList.getItemCount() > 0) {
            //ask confime?
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + timeidSelect + " ?");
            if (a == JOptionPane.YES_OPTION) {
                //customer object pass to controller to update
                TimeSlot ts = c.getTimeSlot(idselect);
                if (ts != null) {//valid to delete
                    if (c.deleteTimeSlot(ts)) {//delete Success from database
                        if (timeslotidList.getItemCount() == 1) {
                            clearTextField();
                            timeslotidList.removeAllItems();//clear all item comboBoxList
                        }else{
                            timeslotidList.removeItem(timeslotidList.getItemAt(indexSelect));//update combobox
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Fail to delete!!\nBecause this customer have a booking record in system!!\nPlease check the booking record", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot delete!", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }
                   
        private void viewButtonActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Click View");
           JFrame addMenu = new JFrame("View Time Slot");

            addMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
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
    private void exitButtonActionPerformed(ActionEvent evt) {
        System.exit(0);
    }
        
}
