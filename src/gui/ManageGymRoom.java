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
 * @author Yong Liang
 */
public class ManageGymRoom extends JFrame implements ActionListener {

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

    public ManageGymRoom() {
        header = new JLabel("Manage Gym Room");
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
    }

    public void addGymRoom() {
        JFrame addMenu = new JFrame("ADD GYM ROOM");

        addMenu.setLayout(null);
        addMenu.setVisible(true);
        addMenu.setResizable(false);
        addMenu.setSize(400, 400);

        addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JLabel header = new JLabel("Add Gym Room");
        mainPanel.add(centerPanel);
        JButton add = new JButton("ADD GYM");

        add.setBounds(50, 100, 95, 30);
        addMenu.add(add);
    }

    public static void main(String[] args) {
        ManageGymRoom manage = new ManageGymRoom();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Add")) {
            JOptionPane.showMessageDialog(this, "Click add");
            mainFrame.setResizable(false);
            mainFrame.setVisible(false);
            addGymRoom();
            /*JFrame addMenu = new JFrame("ADD GYM ROOM");
            addMenu.setSize(400, 400);
            addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel header = new JLabel("Add Gym Room");
            mainPanel.add(this);
            JButton add = new JButton("ADD GYM");

            add.setBounds(50, 100, 95, 30);
            addMenu.add(add);
            addMenu.setLayout(null);
            addMenu.setVisible(true);
            addMenu.setResizable(false);*/
        }
    }
}
