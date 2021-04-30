package gui;

import basic.*;
import main.*;
import java.awt.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Liew Chun Kit
 */
public class ManageCustomer extends JFrame {

    Controller c = Controller.getInstance();
    private JPanel contentPane;
    private JTextField tfUser;
    private JTextField tfPass;
    private JTextField tfEmail;
    private JTextField tfPhone;
    private JComboBox cbList;
    private JTextField tfName;
    private JComboBox cbGender;

    /**
     * Create the frame.
     */
    public ManageCustomer() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        setResizable(false);
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - getWidth()) / 2;
        int iCoordY = (objDimension.height - getHeight()) / 2;
        setLocation(iCoordX, iCoordY);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Manage Customer");
        title.setFont(new Font("Tahoma", Font.BOLD, 14));
        title.setBounds(129, 18, 126, 17);
        contentPane.add(title);

        JLabel lblList = new JLabel("Customer Exist");
        lblList.setLabelFor(this);
        lblList.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblList.setBounds(37, 57, 81, 15);
        contentPane.add(lblList);

        String[] listAvailable = getCustomerList();
        cbList = new JComboBox(listAvailable);
        cbList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectCbListActionPerformed(e);
            }
        });
        cbList.setBounds(155, 53, 190, 22);
        contentPane.add(cbList);

        JLabel lblUser = new JLabel("Username");
        lblUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblUser.setBounds(37, 96, 54, 15);
        contentPane.add(lblUser);

        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPass.setBounds(37, 134, 51, 15);
        contentPane.add(lblPass);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblName.setBounds(37, 172, 46, 14);
        contentPane.add(lblName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEmail.setBounds(37, 210, 27, 15);
        contentPane.add(lblEmail);

        JLabel lblPhone = new JLabel("Phone Number");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblPhone.setBounds(37, 248, 82, 15);
        contentPane.add(lblPhone);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblGender.setBounds(37, 287, 40, 15);
        contentPane.add(lblGender);

        tfUser = new JTextField();
        tfUser.setEditable(false);
        tfUser.setBounds(155, 93, 190, 20);
        contentPane.add(tfUser);
        tfUser.setColumns(10);

        tfPass = new JTextField();
        tfPass.setEditable(false);
        tfPass.setBounds(155, 131, 190, 20);
        contentPane.add(tfPass);
        tfPass.setColumns(10);

        tfName = new JTextField();
        tfName.setBounds(155, 169, 190, 20);
        contentPane.add(tfName);
        tfName.setColumns(10);

        tfEmail = new JTextField();
        tfEmail.setBounds(155, 207, 190, 20);
        contentPane.add(tfEmail);
        tfEmail.setColumns(10);

        tfPhone = new JTextField();
        tfPhone.setBounds(155, 245, 190, 20);
        contentPane.add(tfPhone);
        tfPhone.setColumns(10);

        cbGender = new JComboBox();
        cbGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        cbGender.setModel(new DefaultComboBoxModel(new String[]{"Male", "Female"}));
        cbGender.setBounds(155, 283, 100, 22);
        contentPane.add(cbGender);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnBack.setBounds(18, 323, 60, 23);
        contentPane.add(btnBack);

        JButton btnDel = new JButton("Delete");
        btnDel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delCusButtonActionPerformed(e);
            }
        });
        btnDel.setBounds(129, 323, 70, 23);
        contentPane.add(btnDel);

        JButton btnShow = new JButton("Show");
        btnShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCusButtonActionPerformed(e);
            }
        });
        btnShow.setBounds(200, 323, 76, 23);
        contentPane.add(btnShow);

        JButton btnSave = new JButton("Save");
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveCusButtonActionPerformed(e);
            }
        });
        btnSave.setBounds(277, 323, 97, 23);
        contentPane.add(btnSave);

    }

    private String[] getCustomerList() {
        ArrayList<Customer> list = c.getAllCustomer();
        Object[] cus = list.toArray();
        String[] dataList = new String[list.size()];
        for (int i = 0; i < cus.length; i++) {
            dataList[i] = ((Customer) cus[i]).username;
        }
        return dataList;
    }

    private void selectCbListActionPerformed(ActionEvent evt) {
        tfUser.setText((String) cbList.getItemAt(cbList.getSelectedIndex()));//username
        String usernameSelect = (String) cbList.getItemAt(cbList.getSelectedIndex());//get username from combobox
        Customer cus = c.getCustomer(usernameSelect);//get customer from database base on username given
        tfName.setText(cus.getName());//name
        tfPass.setText(cus.getPassword());//passsword
        tfEmail.setText(cus.getEmail());//email
        tfPhone.setText(cus.getPhoneNumber());//phone
        cbGender.setSelectedItem(cus.getGender());//gender
    }

    private void saveCusButtonActionPerformed(ActionEvent evt) {
        //store index of selected
        int indexSelect = cbList.getSelectedIndex();
        //get the username
        String usernameSelect = (String) cbList.getItemAt(indexSelect);
        //customer object to update
        Customer cus = c.getCustomer(usernameSelect);
        cus.setName(tfName.getText());
        cus.setEmail(tfEmail.getText());
        cus.setPhoneNumber(tfPhone.getText());
        cus.setGender((String) cbGender.getItemAt(cbGender.getSelectedIndex()));
        if (cbList.getItemCount() != 0) {
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to change " + usernameSelect + " ?");
            if (a == JOptionPane.YES_OPTION) {
                //send to update control
                if (c.updateCustomer(cus)) {//update success will true
                    //not need reflsesh comboBox, when select username at combobox will search in database
                    JOptionPane.showMessageDialog(null, "Done Save");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot edit!", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void clearTextField() {
        tfPass.setText("");
        tfName.setText("");
        tfEmail.setText("");
        tfPhone.setText("");
        tfUser.setText("");
    }

    private void loadList() {
        String[] listAvailable = getCustomerList();
        cbList.removeAllItems();//clear all item comboBoxList
        for (String list : listAvailable) {
            cbList.addItem(list);//add item into comboBoxList
        }
    }

    private void delCusButtonActionPerformed(ActionEvent evt) {
        //store index of selected
        int indexSelect = cbList.getSelectedIndex();
        //get the username
        String usernameSelect = (String) cbList.getItemAt(indexSelect);
        if (cbList.getItemCount() > 0) {
            //ask confime?
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + usernameSelect + " ?");
            if (a == JOptionPane.YES_OPTION) {
                //customer object pass to controller to update
                Customer cus = c.getCustomer(usernameSelect);
                if (cus != null) {//valid to delete
                    if (c.deleteCustomer(cus)) {//delete Success from database
                        if (cbList.getItemCount() == 1) {
                            clearTextField();
                            cbList.removeAllItems();//clear all item comboBoxList
                        }else{
                            cbList.removeItem(cbList.getItemAt(indexSelect));//update combobox
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Fail to delete!", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot delete!", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void showCusButtonActionPerformed(ActionEvent evt) {
        ViewAllCustomer frame = new ViewAllCustomer();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame 
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        Login frame = new Login();
        //if lpggout should do
        //c.logout();
        setVisible(false);//unshow current frame
        frame.setVisible(true);//show new frame 
    }

}
