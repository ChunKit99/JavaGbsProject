package gui;

import main.*;
import basic.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * the first start page of gui, can go to register page or login into system
 *
 * @author Liew Chun Kit
 */
public class Login extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;
    private JTextField userText;
    private JPasswordField passText;
//    private final ButtonGroup buttonGroup = new ButtonGroup();

    /**
     * Create the Login frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);
        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel centerPanel = new JPanel();
        contentPane.setBounds(26, 36, 325, 226);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Welcome To GBS");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(115, 25, 204, 29);
        contentPane.add(title);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userLabel.setBounds(134, 95, 54, 15);
        contentPane.add(userLabel);

        userText = new JTextField();
        userText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userText.setBounds(198, 92, 106, 21);
        contentPane.add(userText);
        userText.setColumns(10);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passLabel.setBounds(134, 140, 51, 15);
        contentPane.add(passLabel);

        passText = new JPasswordField();
        passText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passText.setBounds(198, 137, 106, 21);
        contentPane.add(passText);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        loginButton.setBounds(227, 196, 77, 23);
        contentPane.add(loginButton);

        JButton regisButton = new JButton("Register");
        regisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerButtonActionPerformed(e);
            }
        });
        regisButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        regisButton.setBounds(134, 196, 85, 23);
        contentPane.add(regisButton);
        centerPanel.setLayout(new GridLayout(5, 1, 0, -5));
    }

    private void loginButtonActionPerformed(ActionEvent evt) {
        c.loadDatabase("gbsdb");//connect db
        String username = userText.getText();
        String password = new String(passText.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your username and password!!", "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            Account account = c.login(username, password);

            if (account instanceof Customer) {
                changePage(new CustomerMenu());
                //open customer menu frame
            } else if (account instanceof Admin) {
                changePage(new AdminMenu());
                //open admin menu frame
            } else {
                //not match any type
                JOptionPane.showMessageDialog(null, "Fail to login, Please try again!");
                passText.setText("");
            }
        }

    }

    private void changePage(JFrame frameChange) {
        setVisible(false);//unshow current frame
        frameChange.setVisible(true);//show new frame 
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
        //change frame to Resgiter
        Register frame = new Register();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame
    }

}
