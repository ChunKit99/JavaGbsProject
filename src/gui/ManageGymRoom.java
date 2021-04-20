/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Yong Liang
 */
public class ManageGymRoom {
    public static void main(String[] args) {
        JFrame frameManage = new JFrame();
        
        JButton addGymRoom = new JButton("ADD GYM ROOM");
        JButton editGymRoom = new JButton("EDIT GYM ROOM");
        JButton deleteGymRoom = new JButton("DELETE GYM ROOM");
        JButton viewGymRoom = new JButton("VIEW GYM ROOM");
        JButton exitManageGymRoom = new JButton("EXIT MANAGE GYM ROOM");
        
        addGymRoom.setBounds(130, 100, 200, 40);
        frameManage.add(addGymRoom);
        
        frameManage.setSize(800, 500);
        frameManage.setLayout(null);
        frameManage.setVisible(true);
        
    }
}
