package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Liew Chun Kit
 */
public class Login extends JFrame implements ActionListener {

    JPanel mainPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel usernamePanel = new JPanel();
    JLabel prompText = new JLabel("Welcome to GBS");
    JLabel userLabel = new JLabel("Username");
    JPanel passwdPanel = new JPanel();
    JTextField textUsername = new JTextField();
    JLabel passedLabel = new JLabel("Password");
    JPanel typeUserPanel = new JPanel();
    JRadioButton ratioAdmin = new JRadioButton("Admin");
    JPasswordField loginPasswordField = new JPasswordField();
    JRadioButton ratioCustomer = new JRadioButton("Customer");
    ButtonGroup bg = new ButtonGroup();// group the button, select one only
    JPanel buttonPanel = new JPanel();
    JButton btnRegister = new JButton("Register");
    JButton btnLogin = new JButton("Login");

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(null);
        centerPanel.setBounds(25, 35, 325, 225);
        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(5, 1, 0, -5));
        prompText.setHorizontalAlignment(SwingConstants.CENTER);
        prompText.setFont(new Font("Tahoma", Font.PLAIN, 24));
        centerPanel.add(prompText);
        centerPanel.add(usernamePanel);
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        usernamePanel.add(userLabel);
        textUsername.setColumns(15);
        usernamePanel.add(textUsername);
        centerPanel.add(passwdPanel);
        passwdPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        passwdPanel.add(passedLabel);
        loginPasswordField.setColumns(15);
        passwdPanel.add(loginPasswordField);
        centerPanel.add(typeUserPanel);
        typeUserPanel.add(ratioAdmin);
        typeUserPanel.add(ratioCustomer);
        bg.add(ratioAdmin);
        bg.add(ratioCustomer);
        centerPanel.add(buttonPanel);
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnLogin);
        ratioCustomer.setActionCommand("cus");
        ratioAdmin.setActionCommand("admin");
        btnRegister.setActionCommand("Register");
        btnLogin.setActionCommand("Login");
        btnRegister.addActionListener(this);
        btnLogin.addActionListener(this);
        setSize(400, 350);
        setTitle("Welcome to GBS");
        setResizable(false);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String check = "Admin";
        if (command.equals("Register")) {
            JOptionPane.showMessageDialog(this, "Click Register");
        } else {
            if (ratioCustomer.isSelected() || ratioAdmin.isSelected()) {
                JOptionPane.showMessageDialog(this, "Click Login");
                JOptionPane.showMessageDialog(this, "Type of CustomerSelect is " + bg.getSelection().getActionCommand());
                String username = textUsername.getText();
                if (username.equals(check)) {
                    JOptionPane.showMessageDialog(this, "Username Repeat");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Type");
            }

        }
    }

}
