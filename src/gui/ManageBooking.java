package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author WoeiChi Liong
 */
public class ManageBooking extends JFrame {

    JFrame mainFrame = new JFrame();

    JPanel mainPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JLabel header;
    JPanel addPanel = new JPanel();
    JPanel editPanel = new JPanel();
    JPanel deletePanel = new JPanel();
    JPanel viewPanel = new JPanel();
    JPanel personalPanel = new JPanel();
    JPanel logoutPanel = new JPanel();

    JButton addButton;
    JButton editButton;
    JButton deleteButton;
    JButton viewButton;
    JButton personalButton;
    JButton logoutButton;
    JButton backButton;
     private JPanel contentPane;
     
     LocalDate date = LocalDate.now();
     
    JTextField bookingDate = new JTextField();
    
    /**
     * Menu 
     * @author WoeiChi Liong
    */

    public ManageBooking() {
        header = new JLabel("Gym Booking Menu");
        addButton = new JButton("      Add Booking      ");
        editButton = new JButton("      Edit Booking      ");
        deleteButton = new JButton("     Delete Booking     ");
        viewButton = new JButton("      View Booking      ");
        personalButton = new JButton(" View Personal Detail ");
        logoutButton = new JButton("LOGOUT");
        backButton = new JButton("BACK");

        setSize(850, 850);
        setTitle("Customer Booking Menu");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set colour
        centerPanel.setBackground(Color.white);
        addPanel.setBackground(Color.white);
        editPanel.setBackground(Color.white);
        deletePanel.setBackground(Color.white);
        viewPanel.setBackground(Color.white);
        personalPanel.setBackground(Color.white);
        logoutPanel.setBackground(Color.white);

        //set category button 
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        mainPanel.setLayout(null);
        centerPanel.setBounds(60, 60, 700, 700);

        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(0, 1, 0, 0));

        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Comic Sans MS", Font.BOLD, 40));

        centerPanel.add(header);

        centerPanel.add(addPanel);
        addPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        addPanel.add(addButton);
        addButton.setFont(new Font("Comic Sans MS", 0, 20));
  //      direct to add booking
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                addButtonActionPerformed(e);
            }
        });

        centerPanel.add(editPanel);
        editPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        editPanel.add(editButton);
        editButton.setFont(new Font("Comic Sans MS", 0, 20));
        //link to edit booking 
        editButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
     //           editButtonActionPerformed(e);
            }
        });

        centerPanel.add(deletePanel);
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        deletePanel.add(deleteButton);
        deleteButton.setFont(new Font("Comic Sans MS", 0, 20));

        centerPanel.add(viewPanel);
        viewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        viewPanel.add(viewButton);
        viewButton.setFont(new Font("Comic Sans MS", 0, 20));

        centerPanel.add(personalPanel);
        personalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        personalPanel.add(personalButton);
        personalButton.setFont(new Font("Comic Sans MS", 0, 20));
        //direct to personal detail
        personalButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                personalButtonActionPerformed(e);
            }
        });
        
        

        //access button
        centerPanel.add(logoutPanel);
        logoutPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 40));
        logoutPanel.add(logoutButton);
        logoutButton.setFont(new Font("Comic Sans MS", 0, 16));

        setResizable(false);
        setVisible(true);
    }
        private void personalButtonActionPerformed(ActionEvent e){
        PersonalDetail pd = new PersonalDetail();
//close current frame
        setVisible(false);
//open personal detail frame
        pd.setVisible(true);
            
        }
     private void addButtonActionPerformed(ActionEvent e){
         
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JPanel centerPanel = new JPanel();
        contentPane.setBounds(160, 100, 200, 30);
        contentPane.setLayout(null);
         
        JOptionPane.showMessageDialog(this, "Direct to Add Booking");
        setResizable(false);
        setVisible(false);

        JFrame addBook = new JFrame("Add Booking");

        addBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(200, 200, 600, 300);
        setResizable(false);
        setVisible(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setBounds(26, 36, 325, 226);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Add Booking");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        title.setBounds(210, 14, 204, 29);
        contentPane.add(title);

        JLabel roomIdLabel = new JLabel("Gym Room ID");
        roomIdLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        roomIdLabel.setBounds(150, 70, 200, 30);
        contentPane.add(roomIdLabel);

        String gymRoomId[] = {"1", "2", "3"};
        JComboBox gymRoomIdLabel = new JComboBox(gymRoomId);
        gymRoomIdLabel.setBounds(270, 75, 100, 20);
        contentPane.add(gymRoomIdLabel);

        JLabel timeSlotLable = new JLabel("Time Slot ID");
        timeSlotLable.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        timeSlotLable.setBounds(150, 120, 200, 30);
        contentPane.add(timeSlotLable);
        
        JButton viewTime = new JButton("View Time Slot");
        viewTime.setBounds(400,125,170,30);
        viewTime.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
             viewTimeButtonActionPerformed(e);
             
         }
     });
        contentPane.add(viewTime);
        
        String timeSlotList[] = {"1", "2", "3"};
        JComboBox timeSlotListLabel = new JComboBox(timeSlotList);
        timeSlotListLabel.setBounds(270, 125, 100, 20);
        contentPane.add(timeSlotListLabel);
        
        JLabel bookingDate = new JLabel("Booking Date");
        bookingDate.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        bookingDate.setBounds(150, 170, 200, 30);
        contentPane.add(bookingDate);
        
        JTextField tf = new JTextField();
        tf.setBounds(270,175,100,20);
        tf.setText(" "+date);
        contentPane.add(tf);
        contentPane.setVisible(true);
        tf.setEditable(false);
        
        JButton b1 = new JButton("Add");
        b1.setBounds(190, 220, 75, 30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addActionPerformed(e);
                contentPane.setVisible(false);
            }
        });
        contentPane.add(b1);

        JButton backButton = new JButton("Cancel");
        backButton.setBounds(350, 220, 75, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                contentPane.setVisible(false);
            }
        });
        contentPane.add(backButton);

    }

//SHOULD CONNECT TO MANAGETIMESLOT.VIEW   
    private void viewTimeButtonActionPerformed(ActionEvent e){
           JFrame addMenu = new JFrame("View Time Slot");

            addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JButton b1 = new JButton("Exit");  
                b1.setBounds(250,300,95,30); 
                addMenu.add(b1);
                
                String data[][]={ {"1","0800","1000"},    
                                    {"2","1000","1200"},    
                                    {"3","1400","1600"}};   
                
                String column[] = {"ID","Time Start","Time End"};   
                
                JTable jt = new JTable(data,column);    
                jt.setBounds(30,40,200,300);          
                JScrollPane sp = new JScrollPane(jt);    
                addMenu.add(sp);          
                addMenu.setSize(600,400);

                
                addMenu.setVisible(true);     
    }
    
//Data promp out when press ADD button
    private void addActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Booking have been added!");

        setResizable(false);
        setVisible(false);
        ManageBooking mb = new ManageBooking();
        mb.setVisible(true);
    }
     
         
//Message prompt out when press BACK button
    private void backButtonActionPerformed(ActionEvent e) {

        JOptionPane.showMessageDialog(this, "Back to Booking Menu");
        setResizable(false);
        setVisible(false);
        ManageBooking mb = new ManageBooking();
        mb.setVisible(true);
    
    }
    
    public static void main(String[] args) {
        /*
        Frame frame = new JFrame();//create tab
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//direct close
        frame.setSize(420, 420);//length * width
        frame.setVisible(true);//display-appear tab
        frame.getContentPane().setBackground(Color.WHITE);
         */
        ManageBooking myBooking = new ManageBooking();
    }
}

