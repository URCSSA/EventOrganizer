package com.urcssa.Gui;

/**
 * This class constructs the settings window for a event.
 *
 * @author (Nicholas Wan)
 * @version (09/30/2017)
 */
import com.urcssa.EventOrganizer;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow {
//    GUI Stuff
    private JFrame myFrame;
    private JPanel myPanel;
    private JLabel numOfGroupLabel;
    private JLabel groupSizeLabel;
    private JTextField numOfGroupField;
    private JTextField groupSizeField;
    private JButton submitButton;

//    Data Stuff
    private EventOrganizer eventOrganizer;
    private int numOfGroups;
    private int groupSize;

    public SettingsWindow(EventOrganizer eventOrganizer){
        this.eventOrganizer = eventOrganizer;
        myFrame = new JFrame("Please enter the parameters");
        myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.PAGE_AXIS));
        numOfGroupLabel = new JLabel("Number of Groups: ");
        numOfGroupField = new JTextField(15);
        groupSizeLabel = new JLabel("Size of each group: ");
        groupSizeField = new JTextField(15);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submit();
            }
        });
        myPanel.add(numOfGroupLabel);
        myPanel.add(numOfGroupField);
        myPanel.add(groupSizeLabel);
        myPanel.add(groupSizeField);
        myPanel.add(submitButton);
        myFrame.add(myPanel);

        myFrame.setSize(300,300);
        myFrame.setVisible(true);
    }

    public int getNumOfGroup(){
        return numOfGroups;
    }

    public int getGroupSize(){
        return groupSize;
    }

    public void submit(){
        numOfGroups = Integer.parseInt(numOfGroupField.getText());
        groupSize = Integer.parseInt(groupSizeField.getText());
        eventOrganizer.startMidAutumnMainWindow();
    }

    public void setInvisible(){
        myFrame.setVisible(false);
    }

//    public static void main(String[] args){
//
//    }
}
