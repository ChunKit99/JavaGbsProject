package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.GregorianCalendar;
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
     *
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
        addButton.addActionListener(new ActionListener() {
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
                editButtonActionPerformed(e);
            }
        });

        centerPanel.add(deletePanel);
        deletePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        deletePanel.add(deleteButton);
        deleteButton.setFont(new Font("Comic Sans MS", 0, 20));
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });

        centerPanel.add(viewPanel);
        viewPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        viewPanel.add(viewButton);
        viewButton.setFont(new Font("Comic Sans MS", 0, 20));
        //link to view booking
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewButtonActionPerformed(e);
            }
        });

        centerPanel.add(personalPanel);
        personalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 30));
        personalPanel.add(personalButton);
        personalButton.setFont(new Font("Comic Sans MS", 0, 20));
        //direct to personal detail
        personalButton.addActionListener(new ActionListener() {
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

    private void personalButtonActionPerformed(ActionEvent e) {
        PersonalDetail pd = new PersonalDetail();
//close current frame
        setVisible(false);
//open personal detail frame
        pd.setVisible(true);

    }

    private void addButtonActionPerformed(ActionEvent e) {

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
        viewTime.setBounds(400, 125, 170, 30);
        viewTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        tf.setBounds(270, 175, 100, 20);
        tf.setText(" " + date);
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
    private void viewTimeButtonActionPerformed(ActionEvent e) {
        JFrame addMenu = new JFrame("View Time Slot");

        addMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b1 = new JButton("Exit");
        b1.setBounds(250, 300, 95, 30);
        addMenu.add(b1);

        String data[][] = {{"1", "0800", "1000"},
        {"2", "1000", "1200"},
        {"3", "1400", "1600"}};

        String column[] = {"ID", "Time Start", "Time End"};

        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(jt);
        addMenu.add(sp);
        addMenu.setSize(600, 400);

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
    
   /**
     * Edit Exiting Booking
     *
     * @author WoeiChi Liong
     */
    public void editBooking() {
        JFrame editBooking = new JFrame("Edit Booking");
        editBooking.setSize(850, 650);
        editBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editBooking.setVisible(true);
        editBooking.setResizable(false);

        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        JPanel outerPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        outerPanel.setSize(850, 850);
        topPanel.setSize(850, 850);

        JLabel currentRecord = new JLabel("Current Booking Record:");
        currentRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        currentRecord.setHorizontalAlignment(SwingConstants.LEFT);
        currentRecord.setBounds(10, 40, 850, 30);
        editBooking.add(currentRecord);
        topPanel.add(currentRecord, BorderLayout.PAGE_START);

        /* = Stores.getTeach();
         i = sTeach1.size();
        Object[][] data = new Object[i+1][5];
        for (int j = 0; j<sTeach1.size(); j++)
            {
                {
                    SubjectTeacher myTeach = sTeach1.get(j);
                     data[j][0] = myTeach.getName();
                     data[j][1] = myTeach.getSurname();
                     data[j][2] = myTeach.getID();
                     data[j][3] = myTeach.getPay();
                     data[j][4] = myTeach.getSubjectID();
                };
            }*/
        String data[][] = new String[10][5];
        String column[] = {"BOOKING ID", "CUSTOMER NAME", "BOOKING DATE", "GYM ROOM ID", "TIME SLOT ID"};
        JTable bookRecord = new JTable(data, column);
        bookRecord.setBounds(10, 500, 100, 0);
        bookRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        JScrollPane sp = new JScrollPane(bookRecord);
        topPanel.add(sp, BorderLayout.CENTER);

        JLabel instruc1 = new JLabel("Please select which booking record to edit:");
        instruc1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        instruc1.setBounds(3, 220, 700, 30);
        editBooking.add(instruc1);

        JLabel BookID = new JLabel("Booking ID       :");
        BookID.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        BookID.setBounds(250, 270, 700, 30);
        editBooking.add(BookID);

        String bookData[] = {"1", "2", "3"};
        JComboBox bookCombox = new JComboBox(bookData);
        bookCombox.setBounds(450, 270, 200, 35);
        bookCombox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        editBooking.add(bookCombox);

        JLabel instruc2 = new JLabel("Please select following to edit:");
        instruc2.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        instruc2.setBounds(3, 310, 700, 30);
        editBooking.add(instruc2);

        JLabel RoomID = new JLabel("Gym Room ID   :");
        RoomID.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        RoomID.setBounds(250, 350, 700, 30);
        editBooking.add(RoomID);

        String roomData[] = {"1-Room 1-Gold", "2-Room 2-Silver", "3-Room 3-Bronze"};
        JComboBox roomCombox = new JComboBox(roomData);
        roomCombox.setBounds(450, 350, 200, 35);
        roomCombox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        editBooking.add(roomCombox);

        JLabel TimeID = new JLabel("Time Slot ID    :");
        TimeID.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        TimeID.setBounds(250, 400, 700, 30);
        editBooking.add(TimeID);

        String timeData[] = {"1-0800 to 1000", "2-1000 to 1200", "3-1400 to 1600"};
        JComboBox timeCombox = new JComboBox(timeData);
        timeCombox.setBounds(450, 400, 200, 35);
        timeCombox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        editBooking.add(timeCombox);

        JLabel date = new JLabel("Booking Date    :");
        date.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        date.setBounds(250, 450, 700, 30);
        editBooking.add(date);

        JComboBox dateCombox = new JComboBox();
        GregorianCalendar calendar = new GregorianCalendar();
        dateCombox.addItem(calendar.getTime());
        dateCombox.setRenderer(new DateComboBoxRenderer());
        dateCombox.setBounds(450, 450, 200, 35);
        dateCombox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        editBooking.add(dateCombox);

        JButton saveButton = new JButton("SAVE");
        saveButton.setFont(new Font("Comic Sans MS", 0, 20));
        editBooking.add(saveButton);
        saveButton.setBounds(700, 550, 100, 30);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
                editBooking.setVisible(false);
            }
        });

        backButton.setBounds(35, 550, 100, 30);
        backButton.setFont(new Font("Comic Sans MS", 0, 20));
        editBooking.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                editBooking.setVisible(false);
            }
        });

        outerPanel.add(topPanel);
        editBooking.add(outerPanel);

    }

    //handle edit event
    private void editButtonActionPerformed(ActionEvent e) {
        setResizable(false);
        setVisible(false);
        editBooking();
    }

    public void deleteBooking() {
        JFrame deleteBooking = new JFrame("Delete Booking");
        deleteBooking.setSize(850, 650);
        deleteBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteBooking.setVisible(true);
        deleteBooking.setResizable(false);

        //let the frame open at center
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        JPanel outerPanel1 = new JPanel(new BorderLayout());
        JPanel topPanel1 = new JPanel(new BorderLayout());
        outerPanel1.setSize(850, 850);
        topPanel1.setSize(850, 850);

        JLabel currentRecord = new JLabel("Current Booking Record:");
        currentRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        currentRecord.setHorizontalAlignment(SwingConstants.LEFT);
        currentRecord.setBounds(10, 40, 850, 30);
        deleteBooking.add(currentRecord);
        topPanel1.add(currentRecord, BorderLayout.PAGE_START);

        /* = Stores.getTeach();
         i = sTeach1.size();
        Object[][] data = new Object[i+1][5];
        for (int j = 0; j<sTeach1.size(); j++)
            {
                {
                    SubjectTeacher myTeach = sTeach1.get(j);
                     data[j][0] = myTeach.getName();
                     data[j][1] = myTeach.getSurname();
                     data[j][2] = myTeach.getID();
                     data[j][3] = myTeach.getPay();
                     data[j][4] = myTeach.getSubjectID();
                };
            }*/
        String data[][] = new String[10][5];
        String column[] = {"BOOKING ID", "CUSTOMER NAME", "BOOKING DATE", "GYM ROOM ID", "TIME SLOT ID"};
        JTable bookRecord = new JTable(data, column);
        bookRecord.setBounds(10, 500, 100, 0);
        bookRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        JScrollPane sp = new JScrollPane(bookRecord);
        topPanel1.add(sp, BorderLayout.CENTER);

        JLabel instruc1 = new JLabel("Please select which booking record to delete:");
        instruc1.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        instruc1.setBounds(3, 220, 700, 30);
        deleteBooking.add(instruc1);

        JLabel BookID = new JLabel("Booking ID       :");
        BookID.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        BookID.setBounds(250, 270, 700, 30);
        deleteBooking.add(BookID);

        String bookData[] = {"1", "2", "3"};
        JComboBox bookCombox = new JComboBox(bookData);
        bookCombox.setBounds(450, 270, 200, 35);
        bookCombox.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        deleteBooking.add(bookCombox);

        JButton delete = new JButton("DELETE");
        deleteBooking.add(delete);
        delete.setFont(new Font("Comic Sans MS", 0, 20));
        delete.setBounds(600, 550, 150, 30);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeButtonActionPerformed(e);
                deleteBooking.setVisible(false);
            }
        });

        backButton.setBounds(35, 550, 100, 30);
        backButton.setFont(new Font("Comic Sans MS", 0, 20));
        deleteBooking.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                deleteBooking.setVisible(false);
            }
        });

        outerPanel1.add(topPanel1);
        deleteBooking.add(outerPanel1);
    }

    private void deleteButtonActionPerformed(ActionEvent e) {
        setResizable(false);
        setVisible(false);
        deleteBooking();
    }

    public void viewBooking() {
        JFrame viewBooking = new JFrame("View Booking");
        viewBooking.setSize(850, 650);
        viewBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewBooking.setVisible(true);
        viewBooking.setResizable(false);

        JPanel outerPanel2 = new JPanel(new BorderLayout());
        JPanel topPanel2 = new JPanel(new BorderLayout());
        outerPanel2.setSize(850, 850);
        topPanel2.setSize(850, 850);

        JLabel currentRecord = new JLabel("Booking Record:");
        currentRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        currentRecord.setHorizontalAlignment(SwingConstants.LEFT);
        currentRecord.setBounds(0, 40, 850, 30);
        viewBooking.add(currentRecord);
        topPanel2.add(currentRecord, BorderLayout.PAGE_START);

        String data[][] = new String[35][4];
        String column[] = {"CUSTOMER NAME", "BOOKING DATE", "GYM ROOM ID", "TIME SLOT ID"};
        JTable bookRecord = new JTable(data, column);
        bookRecord.setBounds(0, 700, 750, 750);
        bookRecord.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        JScrollPane sp = new JScrollPane(bookRecord);
        topPanel2.add(sp, BorderLayout.CENTER);

        backButton.setBounds(35, 600, 750, 30);
        viewBooking.add(backButton);
        backButton.setFont(new Font("Comic Sans MS", 0, 20));
        topPanel2.add(backButton, BorderLayout.PAGE_END);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
                viewBooking.setVisible(false);
            }
        });

        outerPanel2.add(topPanel2);
        viewBooking.add(outerPanel2);
        //viewBooking.pack();
    }

    private void viewButtonActionPerformed(ActionEvent e) {
        setResizable(false);
        setVisible(false);
        viewBooking();
    }

    /*private void backButtonActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Back to Gym Booking Menu !");
        setResizable(false);
        setVisible(false);
        ManageBooking manu = new ManageBooking();
    }*/

    private void saveButtonActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Succsful Saved!");
        ManageBooking manage = new ManageBooking();
        setVisible(false);
        manage.setVisible(true);
    }

    private void changeButtonActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Succsful Deleted!");
        ManageBooking manage = new ManageBooking();
        setVisible(false);
        manage.setVisible(true);
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
