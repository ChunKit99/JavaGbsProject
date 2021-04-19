package gui;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
	JTextField textUsername = new JTextField();
	JPasswordField loginPasswordField = new JPasswordField();
	JButton btnRegister = new JButton("Register");
	JButton btnLogin = new JButton("Login");
	JRadioButton ratioAdmin = new JRadioButton("Admin");
	JRadioButton ratioCustomer = new JRadioButton("Customer");
	
	public Login() {
		setSize(400, 350);
		setTitle("Welcome");
		//setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
		Container container=getContentPane();
		container.setBackground(Color.WHITE);
                //container.setLayout(null);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		//BoxLayout
		//container.add();
		JLabel title = new JLabel("Welcome to GBS");
		//title.setFont(new Font("Tahoma", Font.PLAIN, 24));
                container.add(title);
		//title.setBounds(80, 20, 200, 30);
                JLabel username = new JLabel("Username");
		container.add(username);
                //JButton button1 = new JButton("btn1");
                //container.add(button1);
	}
        
	 
}
