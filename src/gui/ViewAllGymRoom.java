package gui;

import basic.*;
import main.*;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Yong Liang
 */
public class ViewAllGymRoom extends JFrame {

    Controller c = Controller.getInstance();

    public ViewAllGymRoom() {

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

        ArrayList<GymRoom> list = c.getAllGymRoom();
        String column[] = {"Gym ID", "Name", "Level"};
        Object[] gym = list.toArray();
        String[][] dataList = new String[list.size()][column.length];
        for (int i = 0; i < gym.length; i++) {
            dataList[i][0] = Integer.toString(((GymRoom) gym[i]).ID）;
            dataList[i][1] = ((GymRoom) gym[i]).getName();
            dataList[i][2] = ((GymRoom) gym[i]).getLevel();
        }

        JTable jt = new JTable(dataList, column);
        jt.setEnabled(false);
        JScrollPane sp = new JScrollPane(jt);

        add(sp);

    }

    private void backButtonActionPerformed(ActionEvent evt) {
        ManageGymRoom manage = new ManageGymRoom();
        setVisible(false);//unshow current frame
        manage.setVisible(true);//show new frame 
    }
}
