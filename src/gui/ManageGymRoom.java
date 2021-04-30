package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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

    private JPanel contentPane;

    JTextField idText = new JTextField();
    JTextField nameText = new JTextField();
    JTextField typeText = new JTextField();

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

    public static void main(String[] args) {
        //public static void initialize(){
        ManageGymRoom manage = new ManageGymRoom();
    }

    /**
     * add new gym room record
     *
     * @author Yong Liang
     */
    private void addActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Added Gym Room record !");

        String id = idText.getText();
        String name = nameText.getText();
        String type = typeText.getText();

        JOptionPane.showMessageDialog(null, "Added Gym Room List.\n" + "ID: "
                      + id + "\nNAME: " + name + "\nTYPE: " + type);

        setResizable(false);
        setVisible(false);
        ManageGymRoom manage = new ManageGymRoom();
        manage.setVisible(true);
    }

    /**
     * add button at manage menu
     *
     * @author Yong Liang
     */
    private void addButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Add Gym Room record !");
        setResizable(false);
        setVisible(false);

        JFrame addMenu = new JFrame("Add Gym Room");

        addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel t1 = new JLabel("New ID");
        t1.setBounds(100, 100, 200, 30);
        addMenu.add(t1);

        JTextField tt1 = new JTextField();
        tt1.setBounds(250, 100, 200, 30);
        addMenu.add(tt1);

        JLabel t2 = new JLabel("New Name");
        t2.setBounds(100, 150, 200, 30);
        addMenu.add(t2);

        JTextField tt2 = new JTextField();
        tt2.setBounds(250, 150, 200, 30);
        addMenu.add(tt2);

        JLabel t3 = new JLabel("New Type");
        t3.setBounds(100, 200, 200, 30);
        addMenu.add(t3);

        JTextField tt3 = new JTextField();
        tt3.setBounds(250, 200, 200, 30);
        addMenu.add(tt3);

        JButton b1 = new JButton("Add");
        b1.setBounds(200, 300, 75, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addActionPerformed(e);
                addMenu.setVisible(false);
            }
        });
        addMenu.add(b1);

        JButton backButton = new JButton("Back");
        backButton.setBounds(290, 300, 75, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                addMenu.setVisible(false);
            }
        });
        addMenu.add(backButton);

        addMenu.setLayout(null);
        addMenu.setVisible(true);
        addMenu.setResizable(false);
        addMenu.setSize(600, 400);
    }

    /**
     * edit button at manage menu
     *
     * @author Yong Liang
     */
    private void editButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Edit Gym Room record !");
        setResizable(false);
        setVisible(false);
        showPanel();
    }

    /**
     * delete button at manage menu
     *
     * @author Yong Liang
     */
    private void deleteButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Delete Gym Room record !");
        setResizable(false);
        setVisible(false);
        showPanel();
    }

    /**
     * view button at manage menu
     *
     * @author Yong Liang
     */
    private void viewButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "View Gym Room List !");
        setResizable(false);
        setVisible(false);

        JFrame viewMenu = new JFrame("View Gym Room");

        viewMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton backButton = new JButton("Back");
        backButton.setBounds(250, 300, 95, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                viewMenu.setVisible(false);
            }
        });
        viewMenu.add(backButton);

        String data[][] = {{"1", "Room 1", "Gold"},
        {"2", "Room 2", "Silver"},
        {"3", "Room 3", "Bronze"}};

        String column[] = {"ID", "Name", "Type"};

        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        viewMenu.add(sp);
        viewMenu.setSize(600, 400);

        viewMenu.setVisible(true);
    }

    /**
     * exit button at manage menu
     *
     * @author Yong Liang
     */
    private void exitButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Exit to ADMIN Menu !");
        setResizable(false);
        setVisible(false);
        //exitGymRoom();
    }

    /**
     * back button
     *
     * @author Yong Liang
     */
    private void backButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Back to Manage Gym Room Menu !");
        setResizable(false);
        setVisible(false);
        ManageGymRoom menu = new ManageGymRoom();
        menu.setVisible(true);
    }

    /**
     * save button at edit GUI
     *
     * @author Yong Liang
     */
    private void saveButtonActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Clicked Save");
        String id = idText.getText();
        String name = nameText.getText();
        String type = typeText.getText();

        JOptionPane.showMessageDialog(null, "Added Gym Room List.\n" + "ID: "
                      + id + "\nNAME: " + name + "\nTYPE: " + type);

        ManageGymRoom manage = new ManageGymRoom();
        setVisible(false);
        manage.setVisible(true);
    }

    /**
     * GUI that contain edit & delete panel
     *
     * @author Yong Liang
     */
    private void showPanel() {
        setTitle("Manage Gym Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 300);
        setResizable(false);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel centerPanel = new JPanel();
        contentPane.setBounds(26, 36, 325, 226);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Manage Gym Room");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(210, 14, 204, 29);
        contentPane.add(title);

        JLabel idLabel = new JLabel("ID");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        idLabel.setBounds(200, 70, 70, 15);
        contentPane.add(idLabel);

        String gymRoomListID[] = {"1", "2", "3"};
        JComboBox gymRoomListIDlabel = new JComboBox(gymRoomListID);
        gymRoomListIDlabel.setBounds(300, 60, 100, 21);
        contentPane.add(gymRoomListIDlabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setBounds(200, 115, 60, 15);
        contentPane.add(nameLabel);

        nameText = new JTextField();
        nameText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameText.setBounds(300, 112, 100, 21);
        contentPane.add(nameText);

        JLabel typeLabel = new JLabel("Type");
        typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        typeLabel.setBounds(200, 155, 54, 15);
        contentPane.add(typeLabel);

        typeText = new JTextField();
        typeText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        typeText.setBounds(300, 150, 100, 21);
        contentPane.add(typeText);

        JButton addGymRoom = new JButton("Save");
        addGymRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
            }
        });

        addGymRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
        addGymRoom.setBounds(20, 206, 85, 23);
        contentPane.add(addGymRoom);

        JButton deleteGymRoom = new JButton("Delete");
        deleteGymRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = JOptionPane.showConfirmDialog(deleteGymRoom, "Are You Sure Delete?");
                switch (a) {
                    case JOptionPane.YES_OPTION:
                        System.out.println("You clicked YES");
                        setResizable(false);
                        setVisible(false);
                        ManageGymRoom menu = new ManageGymRoom();
                        menu.setVisible(true);
                    case JOptionPane.NO_OPTION:
                        System.out.println("You clicked NO");
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        System.out.println("You clicked Cancel");
                        break;
                }
            }
        });
        deleteGymRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
        deleteGymRoom.setBounds(200, 206, 85, 23);
        contentPane.add(deleteGymRoom);

        JButton exitGymRoom = new JButton("Back");
        exitGymRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        });
        exitGymRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
        exitGymRoom.setBounds(450, 206, 85, 23);
        contentPane.add(exitGymRoom);

        centerPanel.setLayout(new GridLayout(5, 1, 0, -5));
    }
}