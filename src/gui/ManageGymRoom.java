package gui;

import basic.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import main.Controller;

/**
 * the first start page of manage gym room gui
 *
 * @author Yong Liang
 */
public class ManageGymRoom extends JFrame {

    Controller c = Controller.getInstance();

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
    JButton backButton;

    public ManageGymRoom() {
        c.loadDatabase("gbsdb");//connect db

        header = new JLabel("Manage Gym Room");
        addButton = new JButton("ADD");
        editButton = new JButton("EDIT");
        deleteButton = new JButton("DELETE");
        viewButton = new JButton("VIEW");
        exitButton = new JButton("EXIT");
        backButton = new JButton("BACK");

        setSize(400, 400);
        setTitle("Manage Gym Room");

        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        centerPanel.setBackground(Color.white);
        addPanel.setBackground(Color.white);
        editPanel.setBackground(Color.white);
        deletePanel.setBackground(Color.white);
        viewPanel.setBackground(Color.white);
        exitPanel.setBackground(Color.white);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(null);
        centerPanel.setBounds(25, 35, 325, 300);
        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(6, 1, 0, -5));

        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Times New Roman", Font.BOLD, 24));

        centerPanel.add(header);

        centerPanel.add(addPanel);
        addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        addPanel.add(addButton);
        addButton.setFont(new Font("Times New Roman", 0, 18));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addButtonActionPerformed(e);
            }
        });

        centerPanel.add(editPanel);
        editPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        editPanel.add(editButton);
        editButton.setFont(new Font("Times New Roman", 0, 18));
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editButtonActionPerformed(e);
            }
        });

        centerPanel.add(deletePanel);
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        deletePanel.add(deleteButton);
        deleteButton.setFont(new Font("Times New Roman", 0, 18));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });

        centerPanel.add(viewPanel);
        viewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        viewPanel.add(viewButton);
        viewButton.setFont(new Font("Times New Roman", 0, 18));
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewButtonActionPerformed(e);
            }
        });

        centerPanel.add(exitPanel);
        exitPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        exitPanel.add(exitButton);
        exitButton.setFont(new Font("Times New Roman", 0, 18));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButtonActionPerformed(e);
            }
        });

        /*setVisible(false);
        setResizable(false);*/
        setResizable(false);
        setVisible(true);
    }

    /**
     * add button at manage menu
     *
     * @author Yong Liang
     */
    private void addButtonActionPerformed(ActionEvent e) {

        AddGymRoom addGymRoom = new AddGymRoom();
        setVisible(false);//unshow current frame
        addGymRoom.setVisible(true);//show new frame
    }

    private void editButtonActionPerformed(ActionEvent e) {
        ChangeGymRoom addGymRoom = new ChangeGymRoom();
        setVisible(false);//unshow current frame
        addGymRoom.setVisible(true);//show new frame
    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        ChangeGymRoom addGymRoom = new ChangeGymRoom();
        setVisible(false);//unshow current frame
        addGymRoom.setVisible(true);//show new frame
    }

    /**
     * view button at manage menu
     *
     * @author Yong Liang
     */
    private void viewButtonActionPerformed(ActionEvent e) {

        ViewAllGymRoom view = new ViewAllGymRoom();
        setResizable(false);
        setVisible(false);
        view.setVisible(true);
    }

    /**
     * exit button at manage menu
     *
     * @author Yong Liang
     */
    private void exitButtonActionPerformed(ActionEvent e) {

        //JOptionPane.showMessageDialog(this, "Exit to ADMIN Menu !");
        AdminMenu frame = new AdminMenu();
        setVisible(false);
        frame.setVisible(true);
        //exitGymRoom();
    }

}
