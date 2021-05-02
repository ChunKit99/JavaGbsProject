/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author
 */
public class AddTimeSLot extends JFrame {

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

        JLabel t1 = new JLabel("Enter Customer ID");
        t1.setBounds(100, 100, 200, 30);
        add(t1);

        JTextField tt1 = new JTextField();
        tt1.setBounds(250, 100, 200, 30);
        add(tt1);

        JLabel t2 = new JLabel("Enter Time Start");
        t2.setBounds(100, 150, 200, 30);
        add(t2);

        JTextField tt2 = new JTextField();
        tt2.setBounds(250, 150, 200, 30);
        add(tt2);

        JLabel t3 = new JLabel("Enter Time End");
        t3.setBounds(100, 200, 200, 30);
        add(t3);

        JTextField tt3 = new JTextField();
        tt3.setBounds(250, 200, 200, 30);
        add(tt3);

        JButton b1 = new JButton("Save");
        b1.setBounds(200, 300, 75, 30);
        add(b1);

        setLayout(null);
        setVisible(true);
        setResizable(false);
        setSize(600, 400);
    }
}
