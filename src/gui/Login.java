package gui;

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

    private JPanel contentPane;
    private JTextField userText;
    private JPasswordField passText;
    private final ButtonGroup buttonGroup = new ButtonGroup();

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
        title.setBounds(115, 14, 204, 29);
        contentPane.add(title);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userLabel.setBounds(134, 70, 54, 15);
        contentPane.add(userLabel);

        userText = new JTextField();
        userText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userText.setBounds(198, 67, 106, 21);
        contentPane.add(userText);
        userText.setColumns(10);

        JLabel passLabel = new JLabel("Password");
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passLabel.setBounds(134, 115, 51, 15);
        contentPane.add(passLabel);

        passText = new JPasswordField();
        passText.setFont(new Font("Tahoma", Font.PLAIN, 12));
        passText.setBounds(198, 112, 106, 21);
        contentPane.add(passText);

        JRadioButton adminRadio = new JRadioButton("Admin");
        adminRadio.setActionCommand("admin");
        buttonGroup.add(adminRadio);
        adminRadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        adminRadio.setBounds(134, 157, 59, 23);
        contentPane.add(adminRadio);

        JRadioButton customerRadio = new JRadioButton("Customer");
        customerRadio.setActionCommand("customer");
        customerRadio.setSelected(true);
        buttonGroup.add(customerRadio);
        customerRadio.setFont(new Font("Tahoma", Font.PLAIN, 12));
        customerRadio.setBounds(227, 157, 77, 23);
        contentPane.add(customerRadio);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(e);
            }
        });
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        loginButton.setBounds(227, 206, 77, 23);
        contentPane.add(loginButton);

        JButton regisButton = new JButton("Register");
        regisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerButtonActionPerformed(e);
            }
        });
        regisButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        regisButton.setBounds(134, 206, 85, 23);
        contentPane.add(regisButton);
        centerPanel.setLayout(new GridLayout(5, 1, 0, -5));

    }

    private void loginButtonActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Click Login");
        //check repeat username
        // if () {
        // JOptionPane.showMessageDialog(null, "Username Repeat");
        // }else{
        // }
        String username = userText.getText();
        String password = new String(passText.getPassword());
        String typeUser = buttonGroup.getSelection().getActionCommand();
        JOptionPane.showMessageDialog(null,
                "Username enter: " + username
                + "\nPassword enter: " + password
                + "\n Type user selected: " + typeUser
        );
        //go to customer menu of admin menu
        //if(){
        //}else{
        //}
    }

    private void registerButtonActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Click Register");
        //change frame to Resgiter
        Register frame = new Register();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame
    }

}
