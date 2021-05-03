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

        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

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
        timeslotidText.setEditable(false);
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
        AddTimeSlot.setBounds(20, 240, 85, 23);
        contentPane.add(AddTimeSlot);

        JButton editTimeSlot = new JButton("Edit");
        editTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editButtonActionPerformed(e);
            }
        });
        editTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        editTimeSlot.setBounds(110, 240, 85, 23);
        contentPane.add(editTimeSlot);

        JButton deleteTimeSlot = new JButton("Delete");
        deleteTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delCusButtonActionPerformed(e);
            }
        });
        deleteTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        deleteTimeSlot.setBounds(200, 240, 85, 23);
        contentPane.add(deleteTimeSlot);

        JButton viewTimeSlot = new JButton("View");
        viewTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewButtonActionPerformed(e);
            }
        });
        viewTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        viewTimeSlot.setBounds(290, 240, 85, 23);
        contentPane.add(viewTimeSlot);

        JButton exitTimeSlot = new JButton("Exit");
        exitTimeSlot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });
        exitTimeSlot.setFont(new Font("Tahoma", Font.PLAIN, 12));
        exitTimeSlot.setBounds(470, 240, 85, 23);
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
        AddTimeSLot frame = new AddTimeSLot();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame

    }

    private void editButtonActionPerformed(ActionEvent evt) {
        //store index of selected
        int indexSelect = timeslotidList.getSelectedIndex();
        //get the username
        String IDSelect = (String) timeslotidList.getItemAt(indexSelect);
        //customer object to update
        int idselect = Integer.parseInt(IDSelect);
        TimeSlot timeslot = c.getTimeSlot(idselect);
        String t1 = timestartText.getText();
        String t2 = timeendText.getText();
        if (!t1.isEmpty() && !t2.isEmpty()) {//check notempty textfield
            timeslot.setTimeStart(timestartText.getText());
            timeslot.setTimeEnd(timeendText.getText());
            if (timeslotidList.getItemCount() != 0) {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure Edit Time Slot " + IDSelect + " ?");
                if (a == JOptionPane.YES_OPTION) {
                    //send to update control
                    if (c.updateTimeSlot(timeslot)) {
                        JOptionPane.showMessageDialog(null, "Done Save");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Empty list, cannot edit!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void clearTextField() {
        timeslotidText.setText("");
        timestartText.setText("");
        timeendText.setText("");

    }

    private void delCusButtonActionPerformed(ActionEvent evt) {
        //store index of selected
        int indexSelect = timeslotidList.getSelectedIndex();
        //get the username
        String timeidSelect = (String) timeslotidList.getItemAt(indexSelect);
        int idselect = Integer.parseInt(timeidSelect);
        String t1 = timestartText.getText();
        String t2 = timeendText.getText();
        if (!t1.isEmpty() && !t2.isEmpty()) {//check notempty textfield
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
                            } else {
                                timeslotidList.removeItem(timeslotidList.getItemAt(indexSelect));//update combobox
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Fail to delete!!\nBecause this customer have a booking record in system!!\nPlease check the booking record", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Empty list, cannot delete!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void viewButtonActionPerformed(ActionEvent evt) {
        ViewAllTimeSlot frame = new ViewAllTimeSlot();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame

    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        AdminMenu frame = new AdminMenu();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame
    }

}
