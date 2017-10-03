package com.urcssa.Gui;

//import com.urcssa.Event.ManagerImpl.MidAutumnEventManager;

import com.urcssa.Event.ManagerImpl.MidAutumnEventManager;
import com.urcssa.People.Participant;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
//import java.awt.event;
import javax.swing.*;


public class SignInWindow{
    private final JTextField firstNameField;
    private final JTextField lastNameField;
    private final JCheckBox inspectorBox;
	private final JComboBox<Integer> classBox;
    private final JTextArea  tellUsArea;
    private final JTextArea informationArea;
    private final MidAutumnEventManager manager;
    private final MainWindow mainWindow;

    /*
        *Default constructor to create a window.
        */
	public SignInWindow(String title, MidAutumnEventManager manager, MainWindow mainWindow){
        JFrame myFrame = new JFrame(title);
	    this.manager = manager;
        this.mainWindow = mainWindow;

//	      construct Panels, three sub-panels and a whole panel.
        JPanel upperPanel = new JPanel(new FlowLayout());
        upperPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        JPanel middlePanel = new JPanel(new BorderLayout());
        middlePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel lowerPanel = new JPanel(new BorderLayout());
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        JPanel wholePanel = new JPanel();
        wholePanel.setLayout(new BoxLayout(wholePanel, BoxLayout.PAGE_AXIS));

//        construct labels
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        JLabel classLabel = new JLabel("Class:");
        classLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        JLabel tellUsLabel = new JLabel("Anything you wanna tell us?");
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
        Integer[] classArray = new Integer[]{2021, 2020, 2019, 2018};
        classBox = new JComboBox<>(classArray);
        inspectorBox = new JCheckBox("I will participate games.");
        inspectorBox.setFont(new Font("", Font.ITALIC, 20));
        JButton submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.setPreferredSize(new Dimension(120,50));
        submitButton.setFont(new Font("Arial", Font.ITALIC, 20));
        submitButton.addActionListener(e -> addNewMember());
//        submitButton.setMaximumSize(submitButton.getSize());
        JButton clearButton = new JButton("Clear");
        clearButton.setActionCommand("Clear");
        clearButton.setPreferredSize(new Dimension(120,50));
        clearButton.setFont(new Font("Arial", Font.ITALIC, 20));
        clearButton.addActionListener(e -> {
            clear();
            informationArea.setText("");
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

    private void addNewMember(){
	    informationArea.setText("");
        Participant participant = manager.populateParticipant(firstNameField.getText(), lastNameField.getText(),
                (int)classBox.getSelectedItem(), tellUsArea.getText(), !(inspectorBox.isSelected()));

        manager.seatParticipant(participant);

        mainWindow.update();
        clear();
    }

    private void clear(){
        firstNameField.setText("");
        lastNameField.setText("");
        tellUsArea.setText("");
//        informationArea.setText("");
    }

    public void setInformationArea(String groupNum){
        informationArea.setText("Please have a seat a table " + groupNum);
    }

    public void allTableFull(){
        informationArea.setText("All seats are currently occupied, please have a seat in the back.");
    }

}
