/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *to show username, name, email, phone no. and gender
 * @author Angie
 */
public class PersonalDetail extends JFrame{
    
    private JPanel contentPane;
    private JLabel title;
    private JTextField nameText;
    private JTextField emailText;
    private JTextField phoneText;
    private JTextField userText;
    private JTextField genderText;
    
    
    public PersonalDetail(){
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

        JLabel title = new JLabel("Personal Detail");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(115, 14, 204, 29);
        contentPane.add(title);

        JLabel userLabel = new JLabel("Username");
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        userLabel.setBounds(100, 70, 54, 15);
        contentPane.add(userLabel);

        nameText = new JTextField();
        nameText.setBounds(170, 70, 150, 15);
        contentPane.add(nameText);
        nameText.setColumns(10);
        nameText.setEditable(false);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        nameLabel.setBounds(100, 100, 51, 15);
        contentPane.add(nameLabel);
        
        nameText = new JTextField();
        nameText.setBounds(170, 100, 150, 15);
        contentPane.add(nameText);
        nameText.setColumns(10);
        nameText.setEditable(false);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        emailLabel.setBounds(100, 130, 51, 15);
        contentPane.add(emailLabel);
        
        emailText = new JTextField();
        emailText.setBounds(170, 130, 150, 15);
        contentPane.add(emailText);
        emailText.setColumns(10);
        emailText.setEditable(false);
        
        JLabel phoneLabel = new JLabel("Phone No.");
        phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        phoneLabel.setBounds(100, 160, 130, 15);
        contentPane.add(phoneLabel);
        
        phoneText = new JTextField();
        phoneText.setBounds(170, 160, 150, 15);
        contentPane.add(phoneText);
        phoneText.setColumns(10);
        phoneText.setEditable(false);
        
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        genderLabel.setBounds(100, 190, 51, 15);
        contentPane.add(genderLabel);
        
        genderText = new JTextField();
        genderText.setBounds(170, 190, 150, 15);
        contentPane.add(genderText);
        genderText.setColumns(10);
        genderText.setEditable(false);
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(190, 220, 65, 30);
        contentPane.add(backButton);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        

    }
        private void backButtonActionPerformed(ActionEvent evt) {

        JOptionPane.showMessageDialog(null, "Back to Gym Booking Menu");
        //back to Manage Booking
        ManageBooking mBooking = new ManageBooking();
        setVisible(false);//unshow current frame
        mBooking.setVisible(true);//show new frame 
}
        
        public static void main(String[] args) {
        PersonalDetail frame = new PersonalDetail();
        frame.setVisible(true);
}
}
