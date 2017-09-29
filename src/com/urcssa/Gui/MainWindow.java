package com.urcssa.Gui;

import com.urcssa.GUIManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
//    GUI part
    private JFrame myFrame;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JLabel titleLabel;
    private JButton signInButton;
    private JButton lotteryButton;
    private JButton exitButton;

//    Dara part
    GUIManager manager;
    String eventTitle;
    int numOfGroups;
    int groupCapacity;

    public MainWindow(GUIManager theManager, String theEventTitle){
        manager = theManager;
        eventTitle = theEventTitle;
        numOfGroups = manager.numOfGroups;
        groupCapacity = manager.groupsCapacity;

//        construct the window
        titleLabel = new JLabel("Happy Mid-Autumn Festival!");
        titleLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 55));
        titlePanel.add(titleLabel);


        myFrame = new JFrame("CSSA Event");
        myFrame.setSize(1000,1000);
        myFrame.setLayout(new BoxLayout(myFrame, BoxLayout.PAGE_AXIS));
        myFrame.add(titlePanel);
        myFrame.add(tablePanel);
        myFrame.add(buttonPanel);

        myFrame.setVisible(true);
    }

//    public static void main(String[] args){
//        new MainWindow(new GUIManager(), "testing");
//    }
}
