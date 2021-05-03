/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import main.Controller;

/**
 *
 * @author
 */
public class AddTimeSLot extends JFrame {

    private Controller c = Controller.getInstance();
    private JPanel contentPane;
    private JTextField timestartText;
    private JTextField timeendText;

    public AddTimeSLot() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 600, 330);
        setResizable(false);
        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        setTitle("Add Time Slot");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Add Time Slot");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(210, 14, 204, 29);
        contentPane.add(title);

        JLabel t2 = new JLabel("Enter Time Start");
        t2.setBounds(100, 70, 200, 30);
        add(t2);

//        JTextField tt2 = new JTextField();
//        tt2.setBounds(250, 150, 200, 30);
//        add(tt2);
        timestartText = new JTextField();
        timestartText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timestartText.setBounds(250, 70, 200, 30);
        contentPane.add(timestartText);
        //timestartText.setColumns(10);

        JLabel t3 = new JLabel("Enter Time End");
        t3.setBounds(100, 115, 200, 30);
        add(t3);

//        JTextField tt3 = new JTextField();
//        tt3.setBounds(250, 200, 200, 30);
//        add(tt3);
        timeendText = new JTextField();
        timestartText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeendText.setBounds(250, 115, 200, 30);
        contentPane.add(timeendText);
//        timeendText.setColumns(10);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(180, 190, 75, 30);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
            }
        });
        add(saveButton);
        JButton backButton = new JButton("Back");
         backButton.setBounds(100, 190, 75, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        });
        add(backButton);
//        JButton b1 = new JButton("Save");
//        b1.setBounds(200, 300, 75, 30);
//        add(b1);
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        ManageTimeSlot frame = new ManageTimeSlot();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        String timestart = timestartText.getText();
        String timeend = timeendText.getText();

        if (timestart.isEmpty() || timeend.isEmpty()) {//empty at textfield
            JOptionPane.showMessageDialog(null, "Please Enter the Time Start and Time End", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {//not empty
            if (c.addTimeSlot(timestart, timeend)) {//true is sucess add
                JOptionPane.showMessageDialog(null, "You have done to Add new Time Slot ID. Now You will return to Manage Time Slot page.", "Add Success", JOptionPane.PLAIN_MESSAGE);
                ManageTimeSlot frame = new ManageTimeSlot();
                setVisible(false);
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Fail to add!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }

    }
}
