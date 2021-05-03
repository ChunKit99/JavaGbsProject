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

    private JPanel contentPane;
    
    private JComboBox gymRoomIdList;
    private JTextField gymRoomIdText;
    private JTextField nameText;
    private JTextField levelText;

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
    
    private String[] getGymRoom() {
        ArrayList<GymRoom> list = c.getAllGymRoom();
        Object[] gym = list.toArray();
        String[] dataList = new String[list.size()];
        for (int i = 0; i < gym.length; i++) {
            dataList[i] = Integer.toString(((GymRoom) gym[i]).ID);
        }
        return dataList;
    }
    
    private void selectListActionPerformed(ActionEvent evt) {
        gymRoomIdText.setText((String) gymRoomIdList.getItemAt(gymRoomIdList.getSelectedIndex()));//id
        String GymID = (String) gymRoomIdList.getItemAt(gymRoomIdList.getSelectedIndex());//get name from combobox
        int gymRoomSelect = Integer.valueOf(GymID);
        GymRoom gym = c.getGymRoom(gymRoomSelect);//get gymRoom from database base on id given
        nameText.setText(gym.getName());//name
        levelText.setText(gym.getLevel());//level

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

    /**
     * edit button at manage menu
     *
     * @author Yong Liang
     */
    private void editButtonActionPerformed(ActionEvent e) {

        //store index of selected
        int indexSelect = gymRoomIdList.getSelectedIndex();
        //get the username
        String IDSelect = (String) gymRoomIdList.getItemAt(indexSelect);
        //customer object to update
        int idselect = Integer.parseInt(IDSelect);
        GymRoom gym = c.getGymRoom(idselect);
        String t1 = nameText.getText();
        String t2 = levelText.getText();
        if (!t1.isEmpty() && !t2.isEmpty()) {//check notempty textfield
            gym.setName(nameText.getText());
            gym.setLevel(levelText.getText());
            if (gymRoomIdList.getItemCount() != 0) {
                int a = JOptionPane.showConfirmDialog(null, "Are you sure Edit Gym Room " + IDSelect + " ?");
                if (a == JOptionPane.YES_OPTION) {
                    //send to update control
                    if (c.updateGymRoom(gym)) {
                        JOptionPane.showMessageDialog(null, "Done Save");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Empty list, cannot edit!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * delete button at manage menu
     *
     * @author Yong Liang
     */
    private void deleteButtonActionPerformed(ActionEvent e) {
        //store index of selected
        int indexSelect = gymRoomIdList.getSelectedIndex();
        //get the username
        String gymIdSelect = (String) gymRoomIdList.getItemAt(indexSelect);
        int idselect = Integer.parseInt(gymIdSelect);
        String t1 = nameText.getText();
        String t2 = levelText.getText();
        if (!t1.isEmpty() && !t2.isEmpty()) {//check notempty textfield
            if (gymRoomIdList.getItemCount() > 0) {
                //ask confime?
                int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + gymIdSelect + " ?");
                if (a == JOptionPane.YES_OPTION) {
                    //customer object pass to controller to update
                    GymRoom gr = c.getGymRoom(idselect);
                    if (gr != null) {//valid to delete
                        if (c.deleteGymRoom(gr)) {//delete Success from database
                            if (gymRoomIdList.getItemCount() == 1) {
                                clearTextField();
                                gymRoomIdList.removeAllItems();//clear all item comboBoxList
                            } else {
                                gymRoomIdList.removeItem(gymRoomIdList.getItemAt(indexSelect));//update combobox
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Fail to delete!!", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Empty list, cannot delete!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
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
        //store index of selected
        int indexSelect =  gymRoomIdList.getSelectedIndex();
        //get the id
        String IDSelect = (String) gymRoomIdList.getItemAt(indexSelect);
        //customer object to update
        int idselect = Integer.parseInt(IDSelect);
        GymRoom gym = c.getGymRoom(idselect);
        
        JOptionPane.showMessageDialog(null, "Clicked Save");
        
        gym.setName(nameText.getText());
        gym.setLevel(levelText.getText());
        if (gymRoomIdList.getItemCount() !=0){
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to change " + IDSelect  + " ?");
            if (a == JOptionPane.YES_OPTION) {
                //send to update control
                if (c.updateGymRoom(gym)) {//update success will true
                    //not need reflsesh comboBox, when select username at combobox will search in database
                    JOptionPane.showMessageDialog(null, "Done Save");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot edit!", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
        /*JOptionPane.showMessageDialog(null, "Added Gym Room List.\n" + "ID: "
                      + id + "\nNAME: " + name + "\nTYPE: " + type);

        ManageGymRoom manage = new ManageGymRoom();
        setVisible(false);
        manage.setVisible(true);*/
    }
    
    private void clearTextField() {
        gymRoomIdText.setText("");
        nameText.setText("");
        levelText.setText("");
 
    }
    
    private void loadList() {
        String[] listAvailable = getGymRoom();
        gymRoomIdList.removeAllItems();//clear all item comboBoxList
        for (String list : listAvailable) {
            gymRoomIdList.addItem(list);//add item into comboBoxList
        }
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
        idLabel.setLabelFor(this);
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        idLabel.setBounds(200, 70, 70, 15);
        contentPane.add(idLabel);
        
        String[] listAvailable = getGymRoom();
        gymRoomIdList = new JComboBox(listAvailable);
        gymRoomIdList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectListActionPerformed(e);
            }
        });
        gymRoomIdList.setBounds(300, 70, 100, 21);
        contentPane.add(gymRoomIdList);
        
        /*gymRoomIdText = new JTextField();
        gymRoomIdText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gymRoomIdText.setBounds(300, 60, 100, 21);
        contentPane.add(gymRoomIdText);*/
        
        JLabel showIDLabel = new JLabel("Time Slot ID");
        showIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        showIDLabel.setBounds(200, 115, 100, 15);
        contentPane.add(showIDLabel);

        gymRoomIdText = new JTextField();
        gymRoomIdText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gymRoomIdText.setBounds(300, 112, 100, 21);
        gymRoomIdText.setEditable(false);
        contentPane.add(gymRoomIdText);
        //gymRoomIdText.setColumns(10);
        
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

        levelText = new JTextField();
        levelText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        levelText.setBounds(300, 150, 100, 21);
        contentPane.add(levelText);

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