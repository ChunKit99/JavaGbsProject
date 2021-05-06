package gui;

import basic.Customer;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import main.Controller;

/**
 * to show username, name, email, phone no. and gender
 *
 * @author Angie
 */
public class PersonalDetail extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;
    private JTextField nameText;
    private JTextField emailText;
    private JTextField phoneText;
    private JTextField userText;
    private JTextField genderText;
    Customer customer = (Customer) c.getLoggedUser();//customer login

    public PersonalDetail() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setResizable(false);

        // let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setBounds(26, 36, 325, 226);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Personal Detail");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(115, 26, 204, 29);
        contentPane.add(title);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userLabel.setBounds(100, 84, 54, 15);
        contentPane.add(userLabel);

        userText = new JTextField(customer.username);
        userText.setBounds(170, 81, 150, 20);
        contentPane.add(userText);
        userText.setColumns(10);
        userText.setEditable(false);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setBounds(100, 130, 51, 15);
        contentPane.add(nameLabel);

        nameText = new JTextField(customer.getName());
        nameText.setBounds(170, 127, 150, 20);
        contentPane.add(nameText);
        nameText.setColumns(10);
        nameText.setEditable(false);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        emailLabel.setBounds(100, 176, 51, 15);
        contentPane.add(emailLabel);

        emailText = new JTextField(customer.getEmail());
        emailText.setBounds(170, 173, 150, 20);
        contentPane.add(emailText);
        emailText.setColumns(10);
        emailText.setEditable(false);

        JLabel phoneLabel = new JLabel("Phone No.");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        phoneLabel.setBounds(100, 222, 58, 15);
        contentPane.add(phoneLabel);

        phoneText = new JTextField(customer.getPhoneNumber());
        phoneText.setBounds(170, 219, 150, 20);
        contentPane.add(phoneText);
        phoneText.setColumns(10);
        phoneText.setEditable(false);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        genderLabel.setBounds(100, 268, 51, 15);
        contentPane.add(genderLabel);

        genderText = new JTextField(customer.getGender());
        genderText.setBounds(170, 265, 150, 20);
        contentPane.add(genderText);
        genderText.setColumns(10);
        genderText.setEditable(false);

        JButton backButton = new JButton("Back");
        backButton.setBounds(42, 315, 65, 30);
        contentPane.add(backButton);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        //back to Manage Booking
        CustomerMenu menu = new CustomerMenu();
        setVisible(false);//unshow current frame
        menu.setVisible(true);//show new frame 
    }
}
