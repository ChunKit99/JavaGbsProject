/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import basic.GymRoom;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * GUI that contain edit & delete panel
 *
 * @author Yong Liang
 */
public class ChangeGymRoom extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;

    private JComboBox gymRoomIdList;
    //private JTextField gymRoomIdText;
    private JTextField nameText;
    private JTextField levelText;

    public ChangeGymRoom() {
        setTitle("Manage Gym Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 300);
        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);
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


//        gymRoomIdText = new JTextField();
//        gymRoomIdText.setFont(new Font("Tahoma", Font.PLAIN, 12));
//        gymRoomIdText.setBounds(300, 112, 100, 21);
//        gymRoomIdText.setEditable(false);
//        contentPane.add(gymRoomIdText);
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

        JButton saveGymRoom = new JButton("Save");
        saveGymRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editButtonActionPerformed(e);
            }
        });

        saveGymRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
        saveGymRoom.setBounds(20, 206, 85, 23);
        contentPane.add(saveGymRoom);

        JButton deleteGymRoom = new JButton("Delete");
        deleteGymRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });
        deleteGymRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
        deleteGymRoom.setBounds(110, 206, 85, 23);
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
        //gymRoomIdText.setText((String) gymRoomIdList.getItemAt(gymRoomIdList.getSelectedIndex()));//id
        String GymID = (String) gymRoomIdList.getItemAt(gymRoomIdList.getSelectedIndex());//get name from combobox
        int gymRoomSelect = Integer.valueOf(GymID);
        GymRoom gym = c.getGymRoom(gymRoomSelect);//get gymRoom from database base on id given
        nameText.setText(gym.getName());//name
        levelText.setText(gym.getLevel());//level

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

    private void clearTextField() {
        //gymRoomIdText.setText("");
        nameText.setText("");
        levelText.setText("");

    }

    /**
     * back button
     *
     * @author Yong Liang
     */
    private void backButtonActionPerformed(ActionEvent e) {

        //JOptionPane.showMessageDialog(this, "Back to Manage Gym Room Menu !");
        setResizable(false);
        setVisible(false);
        ManageGymRoom menu = new ManageGymRoom();
        menu.setVisible(true);
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
}
