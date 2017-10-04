package com.urcssa.Gui;

/**
 * This class constructs the main window for a event.
 *
 * @author (Nicholas Wan)
 * @version (09/30/2017)
 */

//import com.urcssa.Event.ManagerImpl.MidAutumnEventManagerImpl;
import com.urcssa.Event.ManagerImpl.MidAutumnEventManagerImpl;
import com.urcssa.People.Participant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow {
//    GUI part
    private final JFrame myFrame;
    private final JComboBox<String> spectatorBox;
    private final ArrayList<JTextField> capacityList;
    private final ArrayList<JComboBox<String>> detailList;
    private SignInWindow signInWindow;

    //    Dara part
private final MidAutumnEventManagerImpl manager;
    private final int groupSize;

//    private MidAutumnEventImpl midAutumnCssaEvent;

    private void signIn(){
        signInWindow = new SignInWindow("Please sign in", manager, this);
    }

    private void lottery(){
        LotteryWindow lotteryWindow = new LotteryWindow(this);
    }

    private void exit(){
        myFrame.setVisible(false);
    }

    /**
     * Prepares a participant object for the ActManager to add to the Activity. Displays changes to
     * System that result from this add.
     * @param firstName
     * @param lastName
     * @param classLevel
     * @param remark
     * @param isSpectator
     */
    public void prepareParticipant(String firstName, String lastName, int classLevel, String remark, boolean isSpectator){
        Participant participant = manager.addParticipant(firstName, lastName, classLevel, remark, isSpectator);

        int groupNum = participant.getGroupNumber();


        if (groupNum == -1) {
            signInWindow.allTableFull();//TODO rephrase feedback text
            spectatorBox.addItem(participant.getFirstName() + " " + participant.getLastName());
            return;
        }

        signInWindow.setInformationArea(Integer.toString(groupNum));
        detailList.get(groupNum-1).addItem(participant.getFirstName() + " " + participant.getLastName());
    }

    public void update(){
//        Component[] components = tablePanel.getComponents();
        for(int i = 0; i < manager.numberOfGroups(); i++) {
            capacityList.get(i).setText(Integer.toString(manager.getParticipantGroup(i).getSize()) + "/"
                    + Integer.toString(groupSize));
        }

    }

    //    TODO implement save event function
    private void save(){
        try {
            manager.saveEvent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    TODO implement load event function
    private void load() {
        try {
            manager.loadEvent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public MainWindow(MidAutumnEventManagerImpl midAutumnEventManagerImpl, String eventTitle){
//        Construct data
        manager = midAutumnEventManagerImpl;

        String eventTitle1 = eventTitle;
        int numGroups = midAutumnEventManagerImpl.numberOfGroups();
        groupSize = midAutumnEventManagerImpl.getGroupSize();

//        construct the window (GUI Part)
//        construct the title panel
        JLabel titleLabel = new JLabel("Happy Mid-Autumn Festival!");
        titleLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 70));
        JPanel titlePanel = new JPanel();
        titlePanel.setSize(900,200);
        titlePanel.add(titleLabel);

//        construct the table panel
        ArrayList<JPanel> panelList = new ArrayList<>(numGroups);
        ArrayList<JLabel> tableList = new ArrayList<>(numGroups);
        detailList = new ArrayList<>(numGroups);
        capacityList = new ArrayList<>(numGroups);
        JPanel tablePanel = new JPanel(new GridLayout(numGroups / 5 + 1, 5));
        tablePanel.setSize(900, 500);
        for(int i = 0; i< numGroups; i++){
//            Flora I really love you!!
            panelList.add(new JPanel());
            tableList.add(new JLabel("Table " + Integer.toString(i+1)));
            detailList.add(new JComboBox<>());
            detailList.get(i).addItem("     ");
            capacityList.add(new JTextField("0/" + Integer.toString(groupSize)));
            panelList.get(i).add(tableList.get(i));
            panelList.get(i).add(capacityList.get(i));
            panelList.get(i).add(detailList.get(i));
            panelList.get(i).setSize(30, 30);
            tablePanel.add(panelList.get(i));
        }

//        construct the button panel
        spectatorBox = new JComboBox<>();
        spectatorBox.addItem("          ");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(900,100);
        JButton signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        signInButton.setSize(200,90);
        signInButton.addActionListener(e -> signIn());
        JButton lotteryButton = new JButton("Lottery");
        lotteryButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        lotteryButton.setSize(200,90);
        lotteryButton.addActionListener(e -> lottery());
        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        saveButton.setSize(200,90);
        saveButton.addActionListener(e -> save());
        JButton loadButton = new JButton("Load");
        loadButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        loadButton.setSize(200,90);
        loadButton.addActionListener(e -> load());
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        exitButton.setSize(200,90);
        exitButton.addActionListener(e -> exit());
        buttonPanel.add(spectatorBox);
        buttonPanel.add(signInButton);
        buttonPanel.add(lotteryButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(exitButton);

//        construct the frame
        myFrame = new JFrame("CSSA Event");
        myFrame.setSize(900,800);
//        myFrame.setLayout(new BoxLayout(, BoxLayout.PAGE_AXIS));
        JPanel wholePanel = new JPanel();
        wholePanel.setLayout(new BoxLayout(wholePanel, BoxLayout.PAGE_AXIS));
        wholePanel.add(titlePanel);
        wholePanel.add(tablePanel);
        wholePanel.add(buttonPanel);
        myFrame.add(wholePanel);

        myFrame.setVisible(true);
    }

}
