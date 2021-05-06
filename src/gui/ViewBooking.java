package gui;

import basic.BookingGym;
import basic.Customer;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import main.Controller;

/**
 *
 * @author WoeiChi Liong
 */
public class ViewBooking extends JFrame {

    Controller c = Controller.getInstance();

    public ViewBooking() {
        setTitle("View Booking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setVisible(false);
        setResizable(false);
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 500, 95, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        });
        add(backButton);

        ArrayList<BookingGym> list = c.getBookingGym(((Customer) c.getLoggedUser()).username);
        String column[] = {"Booking ID", "CUSTOMER NAME", "BOOKING DATE", "GYM ROOM ID", "TIME SLOT ID"};
        Object[] booking = list.toArray();
        String[][] dataList = new String[list.size()][column.length];
        for (int i = 0; i < booking.length; i++) {
            dataList[i][0] = Integer.toString(((BookingGym) booking[i]).ID);
            dataList[i][1] = ((BookingGym) booking[i]).getCustomer();
            dataList[i][2] = ((BookingGym) booking[i]).getDate().toString();
            dataList[i][3] = Integer.toString(((BookingGym) booking[i]).getGymRoom().ID);
            dataList[i][4] = Integer.toString(((BookingGym) booking[i]).getTimeSlot().ID);
        }

        JTable jt = new JTable(dataList, column);
        jt.setEnabled(false);
        JScrollPane sp = new JScrollPane(jt);
        add(sp);
    }

    private void backButtonActionPerformed(ActionEvent e) {
        setVisible(false);
        CustomerMenu menu = new CustomerMenu();
        menu.setVisible(true);
    }
}
