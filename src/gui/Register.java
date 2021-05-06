package gui;

import main.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * the register page, both button also return to login page
 *
 * @author Liew Chun Kit
 */
public class Register extends JFrame {

    private Controller c = Controller.getInstance();
    private JPanel contentPane;
    private JTextField nameText;
    private JTextField emailText;
    private JTextField phoneText;
    private JTextField userText;
    private JPasswordField passText;
    private JPasswordField passConfText;
    private JComboBox comboBoxGender;
    private JLabel labelError1;
    private JLabel labelError2;

    /**
     * Create the Register frame.
     */
    public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setResizable(false);

        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Register");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setBounds(30, 30, 80, 30);
        contentPane.add(title);

        JLabel perLabel = new JLabel("Personal Detail");
        perLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        perLabel.setBounds(30, 67, 99, 20);
        contentPane.add(perLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setBounds(30, 91, 46, 20);
        contentPane.add(nameLabel);

        nameText = new JTextField();
        nameText.setBounds(30, 115, 120, 20);
        contentPane.add(nameText);
        nameText.setColumns(10);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        emailLabel.setBounds(30, 139, 46, 20);
        contentPane.add(emailLabel);

        emailText = new JTextField();
        emailText.setBounds(30, 163, 120, 20);
        contentPane.add(emailText);
        emailText.setColumns(10);

        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        phoneLabel.setBounds(30, 187, 82, 20);
        contentPane.add(phoneLabel);

        phoneText = new JTextField();
        phoneText.setBounds(30, 211, 120, 20);
        contentPane.add(phoneText);
        phoneText.setColumns(10);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        genderLabel.setBounds(30, 235, 40, 15);
        contentPane.add(genderLabel);

        String[] genderAvailable = {"Male", "Female"};
        comboBoxGender = new JComboBox(genderAvailable);
        comboBoxGender.setFont(new Font("Tahoma", Font.PLAIN, 12));

        comboBoxGender.setBounds(30, 254, 71, 22);
        contentPane.add(comboBoxGender);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        });
        backButton.setBounds(30, 313, 80, 23);
        contentPane.add(backButton);

        JLabel accLabel = new JLabel("Account");
        accLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        accLabel.setBounds(229, 67, 51, 20);
        contentPane.add(accLabel);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userLabel.setBounds(229, 91, 80, 20);
        contentPane.add(userLabel);

        labelError2 = new JLabel("");
        labelError2.setBounds(310, 91, 120, 15);
        labelError2.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelError2.setForeground(Color.red);
        contentPane.add(labelError2);

        userText = new JTextField();
        userText.setBounds(229, 114, 120, 20);
        contentPane.add(userText);
        userText.setColumns(10);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passLabel.setBounds(229, 140, 80, 20);
        contentPane.add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(229, 163, 120, 20);
        contentPane.add(passText);

        JLabel passConfLabel = new JLabel("Confirm Password");
        passConfLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passConfLabel.setBounds(229, 187, 120, 20);
        contentPane.add(passConfLabel);

        passConfText = new JPasswordField();
        passConfText.setBounds(229, 211, 120, 20);
        contentPane.add(passConfText);

        labelError1 = new JLabel("");
        labelError1.setBounds(229, 240, 160, 15);
        labelError1.setFont(new Font("Tahoma", Font.BOLD, 12));
        labelError1.setForeground(Color.red);
        contentPane.add(labelError1);

        JButton regisButton = new JButton("Register");
        regisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerButtonActionPerformed(e);
            }
        });
        regisButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        regisButton.setBounds(250, 313, 99, 23);
        contentPane.add(regisButton);
    }

    /**
     * Show the error message when error happen
     */
    private void setError(JLabel label, String text) {
        label.setText(text);
        label.setVisible(true);
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
        //JOptionPane.showMessageDialog(null, "Click Register");
        String name = nameText.getText();
        String email = emailText.getText();
        String phone = phoneText.getText();
        String genderSelect = (String) comboBoxGender.getItemAt(comboBoxGender.getSelectedIndex());
        String username = userText.getText();
        String password = new String(passText.getPassword());
        String passwordConf = new String(passConfText.getPassword());
        c.loadDatabase("gbsdb");
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || genderSelect.isEmpty() || username.isEmpty() || password.isEmpty()) {//any data not fill
            JOptionPane.showMessageDialog(null, "Please fill all the column!!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {//all filled
            if (password.equals(passwordConf)) {//check same confirm password
                labelError1.setVisible(false);//unshow the error
                //add new data to database
                // try to register
                if (c.addCustomer(username, password, name, email, phone, genderSelect)) {//if success register, true
                    //go back the login page to login 
                    JOptionPane.showMessageDialog(null, "You have done to Register. Now You will return to Login page.", "Register Success", JOptionPane.PLAIN_MESSAGE);
                    c.disconnectDB();
                    Login frame = new Login();
                    setVisible(false);//unshow current frame
                    frame.setVisible(true);//show new frame
                } else {//fail register, false
                    setError(labelError1, "Repeated username!!");
                    userText.setText("");//clear username textfield
                }

            } else {//not match password
                setError(labelError1, "Invalid Password!!");
                passConfText.setText("");//clear password textfield
            }

        }

    }

    private void backButtonActionPerformed(ActionEvent evt) {
        //JOptionPane.showMessageDialog(null, "Click Back");
        //back to Login
        boolean isConfirmExit = true;
        if (!nameText.getText().isEmpty() || !emailText.getText().isEmpty() || !phoneText.getText().isEmpty() || !userText.getText().isEmpty() || !new String(passText.getPassword()).isEmpty() || !new String(passText.getPassword()).isEmpty()) {
            //any input value
            int a = JOptionPane.showConfirmDialog(null, "You have filled the form, do you really want to exit?");
            if (a == JOptionPane.YES_OPTION) {//select yes
            } else {
                isConfirmExit = false;
            }
        }

        if (isConfirmExit) {
            c.disconnectDB();
            Login frame = new Login();
            setVisible(false);//unshow current frame
            frame.setVisible(true);//show new frame 
        }

    }
}
