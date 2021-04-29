/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import basic.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Yong Liang
 */
public class ManageGymRoom extends JFrame/* implements ListSelectionListener/* implements ActionListener*/ {

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

    JTextField idText = new JTextField();
    JTextField nameText = new JTextField();
    JTextField typeText = new JTextField();
    
    JComboBox idCombo = new JComboBox();
    
    DefaultListModel<String> dataList = new DefaultListModel<>();

    JList<String> list = new JList<>(dataList);

    /*String[] headings = {"ID", "Name", "Type"};

    Object[][] data = {{1, "Room 1", "Gold"},
    {2, "Room 2", "Silver"}, {3, "Room 3", "Bronze"}};

    JTable gymRoomList = new JTable(data, headings);
    TableModel table;*/

    public ManageGymRoom() {
        header = new JLabel("Manage Gym Room");
        addButton = new JButton("ADD");
        editButton = new JButton("EDIT");
        deleteButton = new JButton("DELETE");
        viewButton = new JButton("VIEW");
        exitButton = new JButton("EXIT");
        backButton = new JButton("BACK");

        setSize(400, 400);
        setTitle("Manage Gym Room");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        centerPanel.setBackground(Color.white);
        addPanel.setBackground(Color.white);
        editPanel.setBackground(Color.white);
        deletePanel.setBackground(Color.white);
        viewPanel.setBackground(Color.white);
        exitPanel.setBackground(Color.white);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        //mainFrame.setLayout(null);
        mainPanel.setLayout(null);
        centerPanel.setBounds(25, 35, 325, 300);
        //mainFrame.add(mainPanel);
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
        //viewButton.add(gymRoomList);

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

    public void addGymRoom() {
        JFrame addMenu = new JFrame("ADD GYM ROOM");

        addMenu.setLayout(null);
        addMenu.setResizable(false);
        addMenu.setVisible(true);

        addMenu.setSize(400, 400);

        addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel id = new JLabel("ID:");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        addMenu.add(id);
        id.setBounds(20, 20, 80, 30);
        
        addMenu.add(idText);
        idText.setBounds(100, 20, 200, 30);
        idCombo.addItem(idText);
        
        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        addMenu.add(name);
        name.setBounds(20, 75, 80, 30);
        
        addMenu.add(nameText);
        nameText.setBounds(100, 75, 200, 30);
        
        JLabel type = new JLabel("TYPE:");
        type.setFont(new Font("Times New Roman", Font.BOLD, 20));
        addMenu.add(type);
        type.setBounds(20, 130, 80, 30);
        
        addMenu.add(typeText);
        typeText.setBounds(100, 130, 200, 30);
        
        JButton save = new JButton("ADD");
        addMenu.add(save);
        save.setBounds(50, 200, 95, 30);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
                addMenu.setVisible(false);
            }
        });

        backButton.setBounds(170, 200, 95, 30);
        addMenu.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                addMenu.setVisible(false);
            }
        });
    }

    public void editGymRoom() {
        JFrame editMenu = new JFrame("EDIT GYM ROOM");

        editMenu.setLayout(null);
        editMenu.setResizable(false);
        editMenu.setVisible(true);

        editMenu.setSize(400, 400);

        editMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel id = new JLabel("ID:");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        editMenu.add(id);
        id.setBounds(20, 20, 80, 30);
        
        editMenu.add(idText);
        idText.setBounds(100, 20, 200, 30);
        
        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        editMenu.add(name);
        name.setBounds(20, 75, 80, 30);
        
        editMenu.add(nameText);
        nameText.setBounds(100, 75, 200, 30);
        
        JLabel type = new JLabel("TYPE:");
        type.setFont(new Font("Times New Roman", Font.BOLD, 20));
        editMenu.add(type);
        type.setBounds(20, 130, 80, 30);
        
        editMenu.add(typeText);
        typeText.setBounds(100, 130, 200, 30);
        
        JButton save = new JButton("SAVE");
        editMenu.add(save);
        save.setBounds(50, 200, 95, 30);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
                editMenu.setVisible(false);
            }
        });

        backButton.setBounds(170, 200, 95, 30);
        editMenu.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                editMenu.setVisible(false);
            }
        });
    }

    public void deleteGymRoom() {
        JFrame deleteMenu = new JFrame("DELETE GYM ROOM");

        deleteMenu.setLayout(null);
        deleteMenu.setResizable(false);
        deleteMenu.setVisible(true);

        deleteMenu.setSize(400, 400);

        deleteMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel id = new JLabel("ID:");
        id.setFont(new Font("Times New Roman", Font.BOLD, 20));
        deleteMenu.add(id);
        id.setBounds(20, 20, 80, 30);
        
        deleteMenu.add(idText);
        idText.setBounds(100, 20, 200, 30);
        
        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        deleteMenu.add(name);
        name.setBounds(20, 75, 80, 30);
        
        deleteMenu.add(nameText);
        nameText.setBounds(100, 75, 200, 30);
        
        JLabel type = new JLabel("TYPE:");
        type.setFont(new Font("Times New Roman", Font.BOLD, 20));
        deleteMenu.add(type);
        type.setBounds(20, 130, 80, 30);
        
        deleteMenu.add(typeText);
        typeText.setBounds(100, 130, 200, 30);
        
        JButton save = new JButton("DELETE");
        deleteMenu.add(save);
        save.setBounds(50, 200, 95, 30);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
                deleteMenu.setVisible(false);
            }
        });

        backButton.setBounds(170, 200, 95, 30);
        deleteMenu.add(backButton);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                deleteMenu.setVisible(false);
            }
        });
    }

    public void viewGymRoom() {
        JFrame viewMenu = new JFrame("VIEW GYM ROOM");

        viewMenu.setLayout(null);
        viewMenu.setResizable(false);
        viewMenu.setVisible(true);

        viewMenu.setSize(400, 400);

        viewMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //idCombo.setBounds(50, 100, 75, 20);
        String id[] = {"1", "2", "3"};
        JComboBox idCombox = new JComboBox(id);
        idCombox.setBounds(50, 100, 75, 20);
        viewMenu.add(idCombox);

        backButton.setBounds(50, 200, 95, 30);
        viewMenu.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                viewMenu.setVisible(false);
            }
        });
    }

    public void exitGymRoom() {
        JFrame addMenu = new JFrame("EXIT GYM ROOM");

        addMenu.setLayout(null);
        addMenu.setResizable(false);
        addMenu.setVisible(true);

        addMenu.setSize(400, 400);

        addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //JLabel header = new JLabel("Add Gym Room");
        mainPanel.add(centerPanel);
        JButton add = new JButton("EXIT GYM");
        add.setBounds(50, 100, 95, 30);
        addMenu.add(add);
    }

    public static void main(String[] args) {
        //public static void initialize(){
        /*int maxArrNum = 20;
        GymRoom[] gymRoomList = new GymRoom[maxArrNum];

        //public static void initial(){
        gymRoomList[0] = new GymRoom(1, "Room 1", "Gold");
        gymRoomList[1] = new GymRoom(2, "Room 2", "Sliver");
        gymRoomList[2] = new GymRoom(3, "Room 3", "Bronze");*/

        ManageGymRoom manage = new ManageGymRoom();

    }

//@Override
    private void addButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Add Gym Room record !");
        setResizable(false);
        setVisible(false);
        addGymRoom();
    }

    private void editButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Edit Gym Room record !");
        setResizable(false);
        setVisible(false);
        editGymRoom();
    }

    private void deleteButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Delete Gym Room record !");
        setResizable(false);
        setVisible(false);
        deleteGymRoom();
    }

    private void viewButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "View Gym Room List !");
        setResizable(false);
        setVisible(false);
        viewGymRoom();
    }

    private void exitButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Exit to ADMIN Menu !");
        setResizable(false);
        setVisible(false);
        exitGymRoom();
    }

    private void backButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Back to Manage Gym Room Menu !");
        setResizable(false);
        setVisible(false);
        ManageGymRoom menu = new ManageGymRoom();
    }
    
    private void saveButtonActionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Clicked Add");
            String id = idText.getText();
            String name = nameText.getText();
            String type = typeText.getText();
            
            JOptionPane.showMessageDialog(null, "Added Gym Room List.\n" + "ID: "
             + id + "\nNAME: " + name + "\nTYPE: " + type);
            
            ManageGymRoom manage = new ManageGymRoom();
            setVisible(false);
            manage.setVisible(true);
        };
}