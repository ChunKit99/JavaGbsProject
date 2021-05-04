package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import main.Controller;

/**
 *
 * @author Liew Chun Kit
 */
public class CustomerMenu extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;

    public CustomerMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 450);
        setResizable(false);
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel header = new JLabel("Gym Booking Menu");
        header.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        header.setBounds(120, 34, 200, 22);
        contentPane.add(header);

        JButton addButton = new JButton("Add Booking");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addButtonActionPerformed(e);
            }
        });
        addButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        addButton.setBounds(128, 85, 140, 35);
        contentPane.add(addButton);

        JButton editButton = new JButton("Edit Booking");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editButtonActionPerformed(e);
            }
        });
        editButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        editButton.setBounds(128, 142, 137, 35);
        contentPane.add(editButton);

        JButton deleteButton = new JButton("Delete Booking");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });
        deleteButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        deleteButton.setBounds(128, 199, 137, 35);
        contentPane.add(deleteButton);

        JButton viewButton = new JButton("View Booking");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewButtonActionPerformed(e);
            }
        });
        viewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        viewButton.setBounds(128, 256, 137, 35);
        contentPane.add(viewButton);

        JButton personalButton = new JButton("Personal Detail");
        personalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                personalButtonActionPerformed(e);
            }
        });
        personalButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        personalButton.setBounds(128, 313, 137, 35);
        contentPane.add(personalButton);

        JButton btnNewButton = new JButton("Log Out");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnLogOutPerformed(e);
            }
        });
        btnNewButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        btnNewButton.setBounds(42, 370, 82, 23);
        contentPane.add(btnNewButton);

    }

    private void changePage(JFrame frameChange) {
        setVisible(false);//unshow current frame
        frameChange.setVisible(true);//show new frame 
    }
    private void addButtonActionPerformed(ActionEvent e) {
        changePage(new AddBooking());//goto AddBooking.java
    }
    private void editButtonActionPerformed(ActionEvent e) {
        changePage(new ChangeBooking());//goto EditBooking.java
    }
    private void deleteButtonActionPerformed(ActionEvent e) {
        changePage(new ChangeBooking());//goto DeleteBooking.java
    }
    private void personalButtonActionPerformed(ActionEvent e) {
        changePage(new PersonalDetail());
    }

    private void viewButtonActionPerformed(ActionEvent e) {
        changePage(new ViewBooking()); //goto ViewBooking.java
    }

    private void btnLogOutPerformed(ActionEvent e) {
        c.logout();//let logged user null and disconnect to database
        changePage(new Login());
    }
}
