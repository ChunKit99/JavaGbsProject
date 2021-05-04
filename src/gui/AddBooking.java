/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import basic.Customer;
import basic.GymRoom;
import basic.TimeSlot;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import main.Controller;

/**
 *
 * @author Ong Hui Gie
 */
public class AddBooking extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;
    private JComboBox gymRoomIdLabel;
    private JComboBox timeSlotListLabel;
    LocalDate date = LocalDate.now();

    public AddBooking() {

        JFrame addBook = new JFrame("Add Booking");

        addBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(200, 200, 600, 300);
        setResizable(false);
        setVisible(true);
        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setBounds(26, 36, 325, 226);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Add Booking");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        title.setBounds(210, 14, 204, 29);
        contentPane.add(title);

        JLabel roomIdLabel = new JLabel("Gym Room ID");
        roomIdLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        roomIdLabel.setBounds(150, 70, 200, 30);
        contentPane.add(roomIdLabel);

        String gymRoomList[] = getGymRoom();
        gymRoomIdLabel = new JComboBox(gymRoomList);
        gymRoomIdLabel.setBounds(270, 75, 170, 20);
        contentPane.add(gymRoomIdLabel);

        JLabel timeSlotLable = new JLabel("Time Slot ID");
        timeSlotLable.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        timeSlotLable.setBounds(150, 120, 200, 30);
        contentPane.add(timeSlotLable);

//        JButton viewTime = new JButton("View Time Slot");
//        viewTime.setBounds(400, 125, 170, 30);
//        viewTime.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                viewTimeButtonActionPerformed(e);
//            }
//        });
//        contentPane.add(viewTime);
        String timeSlotList[] = getTimeSlot();
        timeSlotListLabel = new JComboBox(timeSlotList);
        timeSlotListLabel.setBounds(270, 125, 170, 20);
        contentPane.add(timeSlotListLabel);

        JLabel bookingDate = new JLabel("Booking Date");
        bookingDate.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        bookingDate.setBounds(150, 170, 200, 30);
        contentPane.add(bookingDate);

        JTextField tf = new JTextField();
        tf.setBounds(270, 175, 100, 20);
        tf.setText(" " + date);
        contentPane.add(tf);
        contentPane.setVisible(true);
        tf.setEditable(false);

        JButton b1 = new JButton("Add");
        b1.setBounds(190, 220, 75, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addActionPerformed(e);
            }
        });
        contentPane.add(b1);

        JButton backButton = new JButton("Cancel");
        backButton.setBounds(350, 220, 75, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                contentPane.setVisible(false);
            }
        });
        contentPane.add(backButton);
    }

    private String[] getTimeSlot() {
        ArrayList<TimeSlot> timeList = c.getAllTimeSlot();
        Object[] timeslot = timeList.toArray();
        String[] list = new String[timeList.size()];
        for (int i = 0; i < timeList.size(); i++) {
            list[i] = Integer.toString(((TimeSlot) timeslot[i]).ID) + " - " + ((TimeSlot) timeslot[i]).findNameTime();
        }
        return list;
    }

    private String[] getGymRoom() {
        ArrayList<GymRoom> gymList = c.getAllGymRoom();
        Object[] gymRoom = gymList.toArray();
        String[] list = new String[gymList.size()];
        for (int i = 0; i < gymList.size(); i++) {
            list[i] = Integer.toString(((GymRoom) gymRoom[i]).ID) + " - " + ((GymRoom) gymRoom[i]).getName() + " : " + ((GymRoom) gymRoom[i]).getLevel();
        }
        return list;
    }

    private GymRoom getGym(int index) {
        ArrayList<GymRoom> gymList = c.getAllGymRoom();
        Object[] gymRoom = gymList.toArray();
        return ((GymRoom) gymRoom[index]);

    }

    private TimeSlot getTime(int index) {
        ArrayList<TimeSlot> timeList = c.getAllTimeSlot();
        Object[] timeslot = timeList.toArray();
        return ((TimeSlot) timeslot[index]);

    }

    private void addActionPerformed(ActionEvent e) {
        //do the add about
        //find the index select
        int indexTimeSelect = timeSlotListLabel.getSelectedIndex();
        int indexGymSelect = gymRoomIdLabel.getSelectedIndex();
        //find the object gym and time base on index
        GymRoom gymSelect = getGym(indexGymSelect);
        TimeSlot timeSelect = getTime(indexTimeSelect);
        //user login, c.getLoggedUser();
        // call controller add booking gym method
        //addBookingGym(String username, int gymID, int timeID, LocalDate dateBook)
        if (c.addBookingGym(((Customer) c.getLoggedUser()).username, gymSelect.ID, timeSelect.ID, date)){//add booking success
            JOptionPane.showMessageDialog(null, "Done Add Booking!\nYou will return to Gym Booking Menu.");
            CustomerMenu menu = new CustomerMenu();
            setVisible(false);
            menu.setVisible(true);
        }else{
                JOptionPane.showMessageDialog(null, "Fail To Add Booking!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void backButtonActionPerformed(ActionEvent e) {
        CustomerMenu menu = new CustomerMenu();
        setVisible(false);
        menu.setVisible(true);
    }
}
