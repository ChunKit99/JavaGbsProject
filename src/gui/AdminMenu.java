package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import main.Controller;

/**
 *
 * @author Liew Chun Kit
 */
public class AdminMenu extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;

    public AdminMenu() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setResizable(false);
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Admin Menu");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setBounds(140, 34, 113, 22);
        contentPane.add(title);

        JButton btnManageGym = new JButton("Manage Gym Room");
        btnManageGym.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnGymPerformed(e);
            }
        });
        btnManageGym.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnManageGym.setBounds(128, 85, 140, 35);
        contentPane.add(btnManageGym);

        JButton btnManageTime = new JButton("Manage Time Slot");
        btnManageTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnTimePerformed(e);
            }
        });
        btnManageTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnManageTime.setBounds(128, 142, 137, 35);
        contentPane.add(btnManageTime);

        JButton btnManageCus = new JButton("Manage Customer");
        btnManageCus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCusPerformed(e);
            }
        });
        btnManageCus.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnManageCus.setBounds(128, 199, 137, 35);
        contentPane.add(btnManageCus);

        JButton btnViewAllBook = new JButton("View All Booking");
        btnViewAllBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAllBookPerformed(e);
            }
        });
        btnViewAllBook.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnViewAllBook.setBounds(128, 256, 137, 35);
        contentPane.add(btnViewAllBook);

        JButton btnNewButton = new JButton("Log Out");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnLogOutPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBounds(42, 313, 82, 23);
        contentPane.add(btnNewButton);

    }

    private void changePage(JFrame frameChange) {
        setVisible(false);//unshow current frame
        frameChange.setVisible(true);//show new frame 
    }

    private void btnGymPerformed(ActionEvent e) {
        changePage(new ManageGymRoom());
    }

    private void btnTimePerformed(ActionEvent e) {
        changePage(new ManageTimeSlot());
    }

    private void btnCusPerformed(ActionEvent e) {
        changePage(new ManageCustomer());
    }

    private void btnAllBookPerformed(ActionEvent e) {
        //changePage(new ViewAllBooking());
    }

    private void btnLogOutPerformed(ActionEvent e) {
        c.logout();//let logged user null and disconnect to database
        changePage(new Login());
    }
}
