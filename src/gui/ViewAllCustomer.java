package gui;

import basic.*;
import main.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Liew Chun Kit
 */
public class ViewAllCustomer extends JFrame {

    Controller c = Controller.getInstance();

    public ViewAllCustomer() {

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

        ArrayList<Customer> list = c.getAllCustomer();
        String column[] = {"Username", "Password", "Name", "Email", "PhoneNumber", "Gender"};
        Object[] cus = list.toArray();
        String[][] dataList = new String[list.size()][column.length];
        for (int i = 0; i < cus.length; i++) {
            dataList[i][0] = ((Customer) cus[i]).username;
            dataList[i][1] = ((Customer) cus[i]).getPassword();
            dataList[i][2] = ((Customer) cus[i]).getName();
            dataList[i][3] = ((Customer) cus[i]).getEmail();
            dataList[i][4] = ((Customer) cus[i]).getPhoneNumber();
            dataList[i][5] = ((Customer) cus[i]).getGender();
        }

        JTable jt = new JTable(dataList, column);
        jt.setEnabled(false);
        JScrollPane sp = new JScrollPane(jt);

        add(sp);

    }

    private void backButtonActionPerformed(ActionEvent evt) {
        ManageCustomer frame = new ManageCustomer();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame 
    }
}
