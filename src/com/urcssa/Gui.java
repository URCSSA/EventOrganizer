
/**
 * This class constructs a window for a event.
 *
 * @author (Nicholas Wan)
 * @version (09/26/2017)
 */

//package com.urcssa;
import java.awt.*;
import java.lang.*;
//import java.awt.event;
import javax.swing.*;


public class Gui{
//    GUI part
    private JFrame myFrame;
	private JPanel upperPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel buttonPanel;
	private JPanel wholePanel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JLabel classLabel;
	private JComboBox<Integer> classBox;
	private JLabel  tellUsLabel;
	private JTextArea  tellUsArea;
	private JButton submitButton;
	private JButton clearButton;
    private JTextArea informationArea;

//    Variable part
    private final Integer[] classArray = new Integer[] {2021, 2020, 2019, 2018};

	/*
    *Default constructor to create a window.
    */
	public Gui(){
	    myFrame = new JFrame("Welcome to Mid-Autumn Festival.");
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
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        classLabel = new JLabel("Class:");
        classLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));
        tellUsLabel = new JLabel("Anything you wanna tell us?");
        tellUsLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 25));

//        construct fields
        nameField = new JTextField(15);
        nameField.setFont(new Font("", Font.ITALIC, 25));
        tellUsArea = new JTextArea(8,50);
        tellUsArea.setFont(new Font("", Font.ITALIC, 20));
        informationArea = new JTextArea(15,50);
        informationArea.setFont(new Font("", Font.ITALIC, 20));

//        construct comboBox and buttons
        classBox = new JComboBox<>(classArray);
        submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.setPreferredSize(new Dimension(120,50));
        submitButton.setFont(new Font("Arial", Font.ITALIC, 20));
//        submitButton.setMaximumSize(submitButton.getSize());
        clearButton = new JButton("Clear");
        clearButton.setActionCommand("Clear");
        clearButton.setPreferredSize(new Dimension(120,50));
        clearButton.setFont(new Font("Arial", Font.ITALIC, 20));
//        clearButton.setMaximumSize(clearButton.getSize());

//        Arranging upperPanel
        upperPanel.add(nameLabel);
        upperPanel.add(nameField);
        upperPanel.add(classLabel);
        upperPanel.add(classBox);
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

        myFrame.setSize(800,600);
//        myFrame.setLayout(new BorderLayout());
        myFrame.setVisible(true);
	}

	public void buttonClicked( JButton whichButton ){
        String actionCommand = whichButton.getActionCommand();
	    if(actionCommand.equals(submitButton.getActionCommand())){
//Do something
        }else{
//Do something else
        }
	    return;
    }

	public static void main(String[] args){
		new Gui();
	}
}