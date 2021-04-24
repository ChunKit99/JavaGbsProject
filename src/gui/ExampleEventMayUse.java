package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * this is a code for show how to use handling event
 *
 * @author Liew Chun Kit
 */
public class ExampleEventMayUse extends JFrame {

    private JPanel contentPane;
    private JButton resetButton;
    private JButton addButton;
    private JButton deleteButton;
    private JButton deleteSeletectButton;
    private JButton showSeletectButton;
    private JComboBox comboBoxList;
    private JLabel title;

    public ExampleEventMayUse() {
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

        String[] listAvailable = {"ID 1", "ID 2", "ID 3", "ID 4", "ID 5"};//maybe is call some method to get value
        comboBoxList = new JComboBox(listAvailable);//create comboBoxList content
        comboBoxList.setFont(new Font("Tahoma", Font.PLAIN, 12));
        comboBoxList.setBounds(30, 70, 120, 30);
        contentPane.add(comboBoxList);

        resetButton = new JButton();
        resetButton.setText("Reset the list");
        resetButton.setBounds(30, 200, 120, 23);
        contentPane.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetButtonActionPerformed(evt);//go to method
            }
        });

        addButton = new JButton();
        addButton.setText("Add item");
        addButton.setBounds(30, 170, 150, 23);
        contentPane.add(addButton);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);//go to method
            }
        });

        deleteButton = new JButton();
        deleteButton.setText("Delete first item list");
        deleteButton.setBounds(30, 240, 150, 23);
        contentPane.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteButtonActionPerformed(evt);//go to method
            }
        });

        deleteSeletectButton = new JButton();
        deleteSeletectButton.setText("Delete selected item list");
        deleteSeletectButton.setBounds(30, 280, 180, 23);
        contentPane.add(deleteSeletectButton);
        deleteSeletectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteSelectedButtonActionPerformed(evt);//go to method
            }
        });

        showSeletectButton = new JButton();
        showSeletectButton.setText("show item select");
        showSeletectButton.setBounds(30, 320, 150, 23);
        contentPane.add(showSeletectButton);
        showSeletectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showSelectedButtonActionPerformed(evt);//go to method
            }
        });

        title = new JLabel("Example list");
        title.setFont(new Font("Tahoma", Font.BOLD, 18));
        title.setBounds(30, 30, 120, 30);
        contentPane.add(title);

    }

    private void resetButtonActionPerformed(ActionEvent evt) {
        comboBoxList.removeAllItems();//clear all item comboBoxList
        String[] listAvailable = {"ID 1", "ID 2", "ID 3", "ID 4", "ID 5"};//maybe is call some method to get value
        for (String list : listAvailable) {
            comboBoxList.addItem(list);//add item into comboBoxList
        }
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        String name = JOptionPane.showInputDialog(null, "Enter Name");
        comboBoxList.addItem(name);

    }

    private void deleteButtonActionPerformed(ActionEvent evt) {
        //use some way to know need delete what
        //ask confime?
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete?");
        if (a == JOptionPane.YES_OPTION) {
            comboBoxList.removeItem(comboBoxList.getItemAt(0));//0 is first index 
        }
    }

    private void deleteSelectedButtonActionPerformed(ActionEvent evt) {
        //use some way to know need delete what
        int indexDelete = comboBoxList.getSelectedIndex();
        //check empty list
        if (comboBoxList.getItemCount() != 0) {
            //ask confime?
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete " + comboBoxList.getItemAt(indexDelete) + " ?");
            if (a == JOptionPane.YES_OPTION) {
                comboBoxList.removeItem(comboBoxList.getItemAt(indexDelete));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empty list, cannot delete!", "Alert", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void showSelectedButtonActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Your item selected is " + comboBoxList.getItemAt(comboBoxList.getSelectedIndex()));
        //so maybe you want to do something to the seleted item? so modify to suitable code
    }
}
