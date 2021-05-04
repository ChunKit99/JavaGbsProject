/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import basic.BookingGym;
import basic.Customer;
import basic.GymRoom;
import basic.TimeSlot;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
 * @author WoeiChi Liong
 */
public class ChangeBooking extends JFrame {

    Controller c = Controller.getInstance();
    JButton backButton;
    private JPanel contentPane;
    private JComboBox bookIdList;
    private JTextField timeID;
    private JTextField gymID;
    private JTextField date;
    JComboBox tIdList;
    JComboBox gIdList;
    LocalDate dateToday = LocalDate.now();

    public ChangeBooking() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 600, 300);
	        setVisible(false);
	        setResizable(false);
	        setTitle("Manage Booking");

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
	        contentPane.setLayout(null);

	        JLabel title = new JLabel("Manage Booking");
	        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	        title.setBounds(210, 22, 204, 29);
	        contentPane.add(title);

	        JLabel idLabel = new JLabel("ID");
	        idLabel.setLabelFor(this);
	        idLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        idLabel.setBounds(200, 73, 70, 15);
	        contentPane.add(idLabel);

	        String[] listAvailable = getBooking();
	        bookIdList = new JComboBox(listAvailable);
	        bookIdList.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                selectListActionPerformed(e);
	            }
	        });
	        bookIdList.setBounds(300, 70, 150, 21);
	        contentPane.add(bookIdList);

	        JLabel tidLabel = new JLabel("Time ID");
	        tidLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        tidLabel.setBounds(200, 147, 60, 15);
	        contentPane.add(tidLabel);

	        JLabel gidLabel = new JLabel("Gym ID");
	        gidLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        gidLabel.setBounds(200, 110, 54, 15);
	        contentPane.add(gidLabel);

	        JLabel dtLabel = new JLabel("Date");
	        dtLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        dtLabel.setBounds(200, 184, 54, 15);
	        contentPane.add(dtLabel);

	        date = new JTextField(dateToday.toString());
	        date.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        date.setBounds(300, 181, 150, 21);
	        date.setEditable(false);
	        contentPane.add(date);

	        JButton saveGymRoom = new JButton("Save");
	        saveGymRoom.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                editButtonActionPerformed(e);
	            }
	        });

	        saveGymRoom.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        saveGymRoom.setBounds(10, 221, 85, 23);
	        contentPane.add(saveGymRoom);

	        JButton deleteGymRoom = new JButton("Delete");
	        deleteGymRoom.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                deleteButtonActionPerformed(e);
	            }
	        });
	        deleteGymRoom.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        deleteGymRoom.setBounds(110, 221, 85, 23);
	        contentPane.add(deleteGymRoom);

	        JButton exitGymRoom = new JButton("Back");
	        exitGymRoom.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                backButtonActionPerformed(e);
	            }
	        });
	        exitGymRoom.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
	        exitGymRoom.setBounds(450, 221, 85, 23);
	        contentPane.add(exitGymRoom);

	        String timeSlotList[] = getTimeSlot();
	        tIdList = new JComboBox(timeSlotList);
	        tIdList.setBounds(300, 144, 150, 22);
	        contentPane.add(tIdList);

	        String gymRoomList[] = getGymRoom();
	        gIdList = new JComboBox(gymRoomList);
	        gIdList.setBounds(300, 106, 150, 21);
	        contentPane.add(gIdList);

	        centerPanel.setLayout(new GridLayout(5, 1, 0, -5));
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
    private int getGymIndex(int id) {
        ArrayList<GymRoom> gymList = c.getAllGymRoom();
        Object[] gymRoom = gymList.toArray();
        for (int i = 0; i < gymList.size(); i++) {
            if (((GymRoom) gymRoom[i]).ID == id) {
                return i;
            }
        }
        return 0;
    }

    private int getTimeIndex(int id) {
        ArrayList<TimeSlot> timeList = c.getAllTimeSlot();
        Object[] timeslot = timeList.toArray();
        for (int i = 0; i < timeList.size(); i++) {
            if (((TimeSlot) timeslot[i]).ID == id) {
                return i;
            }
        }
        return 0;
    }

    private BookingGym getBook(int index) {
        ArrayList<BookingGym> list = c.getBookingGym(((Customer) c.getLoggedUser()).username);
        Object[] book = list.toArray();
        return ((BookingGym) book[index]);

    }
//    private String[] getTInBook(){
//        ArrayList<BookingGym> list = c.getBookingGym(((Customer) c.getLoggedUser()).username);
//        Object[] book = list.toArray();
//        String[] data = new String[list.size()];
//        for (int i = 0; i < book.length; i++) {
//            data[i] = Integer.toString(((BookingGym) book[i]).getTimeSlot().ID);
//        }
//        return data;
//    }
//    private String[] getGInBook(){
//        ArrayList<BookingGym> list = c.getBookingGym(((Customer) c.getLoggedUser()).username);
//        Object[] book = list.toArray();
//        String[] data = new String[list.size()];
//        for (int i = 0; i < book.length; i++) {
//            data[i] = Integer.toString(((BookingGym) book[i]).getGymRoom().ID);
//        }
//        return data;
//    }
    private String[] getBooking() {
        ArrayList<BookingGym> list = c.getBookingGym(((Customer) c.getLoggedUser()).username);
        Object[] book = list.toArray();
        String[] dataList = new String[list.size()];
        for (int i = 0; i < book.length; i++) {
            dataList[i] = Integer.toString(((BookingGym) book[i]).ID);
        }
        return dataList;
    }

    private void selectListActionPerformed(ActionEvent evt) {
        int indexSelect = bookIdList.getSelectedIndex();
        BookingGym bookSelect = getBook(indexSelect);
        int indexTToSet = getTimeIndex(bookSelect.getTimeSlot().ID);
        int indexGToSet = getGymIndex(bookSelect.getGymRoom().ID);
        tIdList.setSelectedIndex(indexTToSet);
        gIdList.setSelectedIndex(indexGToSet);
        date.setText(dateToday.toString());
    }

    private void editButtonActionPerformed(ActionEvent e) {

        int indexSelect = bookIdList.getSelectedIndex();
        int indexTSelect = tIdList.getSelectedIndex();
        int indexGSelect = gIdList.getSelectedIndex();
        BookingGym bookSelect = getBook(indexSelect);
        TimeSlot timeSeletct = getTime(indexTSelect);
        GymRoom gymSeletct = getGym(indexGSelect);
        int idselect = bookSelect.ID;
        bookSelect.setGymRoom(gymSeletct);
        bookSelect.setTimeSlot(timeSeletct);
        if (bookIdList.getItemCount() != 0) {
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to Edit Booking Record " + idselect + " ?");
            if (a == JOptionPane.YES_OPTION) {
                //send to update control
                if (c.updateBookingGym(bookSelect)) {
                    JOptionPane.showMessageDialog(null, "Done Save");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot edit!", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        int indexSelect = bookIdList.getSelectedIndex();
        int indexTSelect = tIdList.getSelectedIndex();
        int indexGSelect = gIdList.getSelectedIndex();
        BookingGym bookSelect = getBook(indexSelect);
        int idselect = bookSelect.ID;
        if (bookIdList.getItemCount() > 0) {
            //ask confime?
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete Booking Record " + idselect + " ?");
            if (a == JOptionPane.YES_OPTION) {
                if (bookSelect != null) {//valid to delete
                    if (c.deleteBookingGym(bookSelect)) {//delete Success from database
                        JOptionPane.showMessageDialog(null, "Done delete!\nYou Will Go Back To Gym Booking Menu!");
                        backButtonActionPerformed(e);
//                        if (bookIdList.getItemCount() == 1) {
//                            bookIdList.removeAllItems();//clear all item comboBoxList
//                            tIdList.removeAllItems();
//                            gIdList.removeAllItems();
//                        } else {
//                            bookIdList.removeItem(bookIdList.getItemAt(indexSelect));//update combobox
//                            tIdList.removeItem(tIdList.getItemAt(indexTSelect));
//                            gIdList.removeItem(gIdList.getItemAt(indexGSelect));
//                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Fail to delete!!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot delete!", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void backButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        CustomerMenu menu = new CustomerMenu();
        menu.setVisible(true);
    }
}
