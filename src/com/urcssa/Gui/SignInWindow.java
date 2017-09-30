package com.urcssa.Gui;

/**
 * This class constructs a sign in window for a event.
 *
 * @author (Nicholas Wan)
 * @version (09/26/2017)
 */

import com.urcssa.Event.ManagerImpl.MidAutumnEventManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
//import java.awt.event;
import javax.swing.*;


public class SignInWindow{
//    GUI part
    private JFrame myFrame;
	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel buttonPanel;
	private JPanel wholePanel;
	private JLabel firstNameLabel;
	private JTextField firstNameField;
	private JLabel lastNameLabel;
	private JTextField lastNameField;
	private JLabel classLabel;
	private JCheckBox inspectorBox;
	private JComboBox<Integer> classBox;
	private JLabel  tellUsLabel;
	private JTextArea  tellUsArea;
	private JButton submitButton;
	private JButton clearButton;
    private JTextArea informationArea;
    private MainWindow mainWindow;

//    Variable part
    private final Integer[] classArray = new Integer[] {2021, 2020, 2019, 2018};

	/*
    *Default constructor to create a window.
    */
	public SignInWindow(String title, MainWindow theMainWindow){
	    myFrame = new JFrame(title);
	    mainWindow = theMainWindow;
//	      construct Panels, three sub-panels and a whole panel.
        upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        buttonPanel = new JPanel(new FlowLayout());
        lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        wholePanel = new JPanel();
        wholePanel.setLayout(new BoxLayout(wholePanel, BoxLayout.PAGE_AXIS));

//        construct labels
        firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        classLabel = new JLabel("Class:");
        classLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        tellUsLabel = new JLabel("Anything you wanna tell us?");
        tellUsLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));

//        construct fields
        firstNameField = new JTextField(7);
        firstNameField.setFont(new Font("", Font.ITALIC, 25));
        lastNameField = new JTextField(7);
        lastNameField.setFont(new Font("", Font.ITALIC, 25));
        tellUsArea = new JTextArea(8,50);
        tellUsArea.setFont(new Font("", Font.ITALIC, 20));
        informationArea = new JTextArea(15,50);
        informationArea.setFont(new Font("", Font.ITALIC, 20));

//        construct comboBox and buttons
        classBox = new JComboBox<>(classArray);
        inspectorBox = new JCheckBox("I will participate games.");
        inspectorBox.setFont(new Font("", Font.ITALIC, 20));
        submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.setPreferredSize(new Dimension(120,50));
        submitButton.setFont(new Font("Arial", Font.ITALIC, 20));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewMember();
            }
        });
//        submitButton.setMaximumSize(submitButton.getSize());
        clearButton = new JButton("Clear");
        clearButton.setActionCommand("Clear");
        clearButton.setPreferredSize(new Dimension(120,50));
        clearButton.setFont(new Font("Arial", Font.ITALIC, 20));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
//        clearButton.setMaximumSize(clearButton.getSize());

//        Arranging upperPanel
        upperPanel.add(firstNameLabel);
        upperPanel.add(firstNameField);
        upperPanel.add(lastNameLabel);
        upperPanel.add(lastNameField);
        upperPanel.add(classLabel);
        upperPanel.add(classBox);
        upperPanel.add(inspectorBox);
        upperPanel.setBorder(BorderFactory.createLineBorder(Color.black));

//        Arranging middlePanel
        middlePanel.add(tellUsLabel, BorderLayout.NORTH);
        middlePanel.add(tellUsArea, BorderLayout.CENTER);
//        middlePanel.add(submitButton, BorderLayout.SOUTH);
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        middlePanel.add(buttonPanel, BorderLayout.SOUTH);

//        Arranging lowerPanel
        lowerPanel.add(informationArea);

//        Arranging myFrame
        wholePanel.add(upperPanel);
        wholePanel.add(middlePanel);
        wholePanel.add(lowerPanel);
        myFrame.add(wholePanel);

        myFrame.setSize(1050,600);
//        myFrame.setLayout(new BorderLayout());
        myFrame.setVisible(true);
	}

    public void addNewMember(){
        mainWindow.addParticipant(firstNameField.getText(), lastNameField.getText(),
                (int)classBox.getSelectedItem(), tellUsArea.getText(), !(inspectorBox.isSelected()));
        clear();
    }

    public void clear(){
        firstNameField.setText("");
        lastNameField.setText("");
        tellUsArea.setText("");
    }

    public void printTable(){

    }

}
