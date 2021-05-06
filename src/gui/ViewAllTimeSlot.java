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
 * @author
 */
public class ViewAllTimeSlot extends JFrame {

    Controller c = Controller.getInstance();

    public ViewAllTimeSlot() {

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

        ArrayList<TimeSlot> list = c.getAllTimeSlot();
        String column[] = {"Time Slot ID", "Time Start", "Time End"};
        Object[] timeslot = list.toArray();
        String[][] dataList = new String[list.size()][column.length];
        for (int i = 0; i < timeslot.length; i++) {
            dataList[i][0] = Integer.toString(((TimeSlot) timeslot[i]).ID);
            dataList[i][1] = ((TimeSlot) timeslot[i]).getTimeStart();
            dataList[i][2] = ((TimeSlot) timeslot[i]).getTimeEnd();
        }

        JTable jt = new JTable(dataList, column);
        jt.setEnabled(false);
        JScrollPane sp = new JScrollPane(jt);

        add(sp);

    }

    private void backButtonActionPerformed(ActionEvent evt) {
        ManageTimeSlot frame = new ManageTimeSlot();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame 

    }
}
