/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 *
 * @author WoeiChi Liong
 */
public class DisplayAll extends JFrame {

    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JLabel header;
    JPanel roomPanel = new JPanel();
    JPanel timePanel = new JPanel();
    JPanel viewPanel = new JPanel();
    JPanel logoutPanel = new JPanel();

    JButton roomButton;
    JButton timeButton;
    JButton viewButton;
    JButton logoutButton;
    JButton backButton;

    /**
     * Menu
     *
     * @author WoeiChi Liong
     */
    public DisplayAll() {

        header = new JLabel("Admin Menu");
        roomButton = new JButton("    Manage Gym Room     ");
        timeButton = new JButton("     Manage Time Slot     ");
        viewButton = new JButton("      View All Booking      ");
        logoutButton = new JButton("LOGOUT");
        backButton = new JButton("BACK");

        setSize(850, 850);
        setTitle("Admin Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set colour
        centerPanel.setBackground(Color.white);
        roomPanel.setBackground(Color.white);
        timePanel.setBackground(Color.white);
        viewPanel.setBackground(Color.white);
        logoutPanel.setBackground(Color.white);

        //set category button 
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(null);
        centerPanel.setBounds(60, 60, 700, 700);

        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(0, 1, 0, 0));

        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

        centerPanel.add(header);

        centerPanel.add(roomPanel);
        roomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        roomButton.setFont(new Font("Comic Sans MS", 0, 20));
        roomPanel.add(roomButton);

        centerPanel.add(timePanel);
        timePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        timeButton.setFont(new Font("Comic Sans MS", 0, 20));
        timePanel.add(timeButton);

        centerPanel.add(viewPanel);
        viewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        viewButton.setFont(new Font("Comic Sans MS", 0, 20));
        viewPanel.add(viewButton);
        //link to view booking
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewButtonActionPerformed(e);
            }
        });

        //access button
        centerPanel.add(logoutPanel);
        logoutPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 40));
        logoutPanel.add(logoutButton);
        logoutButton.setFont(new Font("Comic Sans MS", 0, 16));

        setResizable(false);
        setVisible(true);
    }

    public void viewAllBooking() {

        JFrame viewAllBooking = new JFrame("View Al Booking In System");
        viewAllBooking.setSize(850, 650);
        viewAllBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewAllBooking.setVisible(true);
        viewAllBooking.setResizable(false);

        JPanel outerPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        outerPanel.setSize(850, 850);
        topPanel.setSize(850, 850);

        JLabel currentRecord = new JLabel("All Booking Record:");
        currentRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        currentRecord.setHorizontalAlignment(SwingConstants.LEFT);
        currentRecord.setBounds(0, 40, 850, 30);
        viewAllBooking.add(currentRecord);
        topPanel.add(currentRecord, BorderLayout.PAGE_START);

        String data[][] = new String[35][5];
        String column[] = {"Booking ID", "CUSTOMER NAME", "BOOKING DATE", "GYM ROOM ID", "TIME SLOT ID"};
        JTable bookRecord = new JTable(data, column);
        bookRecord.setBounds(0, 700, 750, 750);
        bookRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        JScrollPane sp = new JScrollPane(bookRecord);
        topPanel.add(sp, BorderLayout.CENTER);

        backButton.setBounds(35, 600, 750, 30);
        viewAllBooking.add(backButton);
        backButton.setFont(new Font("Comic Sans MS", 0, 20));
        topPanel.add(backButton, BorderLayout.PAGE_END);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                viewAllBooking.setVisible(false);
            }
        });

        outerPanel.add(topPanel);
        viewAllBooking.add(outerPanel);
        //viewBooking.pack();
    }

    private void viewButtonActionPerformed(ActionEvent e) {
        setResizable(false);
        setVisible(false);
        viewAllBooking();
    }

    private void backButtonActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Back to Admin Menu !");
        setResizable(false);
        setVisible(false);
        DisplayAll menu = new DisplayAll();
    }

    public static void main(String[] args) {
        /*
        Frame frame = new JFrame();//create tab
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//direct close
        frame.setSize(420, 420);//length * width
        frame.setVisible(true);//display-appear tab
        frame.getContentPane().setBackground(Color.WHITE);
         */
        DisplayAll myAdmin = new DisplayAll();
    }

}
