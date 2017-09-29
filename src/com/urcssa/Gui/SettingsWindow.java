package com.urcssa.Gui;

import com.urcssa.GUIManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow {
//    GUI Stuff
    private JFrame myFrame;
    private JPanel myPanel;
    private JLabel numOfGroupLabel;
    private JLabel groupCapacityLabel;
    private JTextField numOfGroupField;
    private JTextField groupCapacityField;
    private JButton submitButton;

//    Data Stuff
    private GUIManager manager;
    private int numOfGroups;
    private int groupCapacity;

    public SettingsWindow(GUIManager theManager){
        manager = theManager;
        myFrame = new JFrame("Please enter the parameters");
        myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        numOfGroupLabel = new JLabel("Number of Groups: ");
        numOfGroupField = new JTextField(15);
        groupCapacityLabel = new JLabel("Capacity for each group: ");
        groupCapacityField = new JTextField(15);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit();
            }
        });
        myPanel.add(numOfGroupLabel);
        myPanel.add(numOfGroupField);
        myPanel.add(groupCapacityLabel);
        myPanel.add(groupCapacityField);
        myPanel.add(submitButton);
        myFrame.add(myPanel);

        myFrame.setSize(300,300);
        myFrame.setVisible(true);
    }

    public int getNumOfGroup(){
        return numOfGroups;
    }

    public int getGroupCapacity(){
        return groupCapacity;
    }

    public void submit(){
        numOfGroups = Integer.parseInt(numOfGroupField.getText());
        groupCapacity = Integer.parseInt(groupCapacityField.getText());
        manager.getMainWindow();
    }

    public void setInvisible(){
        myFrame.setVisible(false);
    }

//    public static void main(String[] args){
//
//    }
}
