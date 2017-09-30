package com.urcssa.Gui;

/**
 * This class constructs the main window for a event.
 *
 * @author (Nicholas Wan)
 * @version (09/30/2017)
 */

import com.urcssa.Event.EventImpl.MidAutumnCssaEventImpl;
//import com.urcssa.Event.ManagerImpl.MidAutumnEventManager;
import com.urcssa.GUIManager;
import com.urcssa.People.Participant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow {
//    GUI part
    private JFrame myFrame;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private JLabel titleLabel;
    private JPanel wholePanel;
    private JButton signInButton;
    private JButton lotteryButton;
    private JButton exitButton;
    private ArrayList<JPanel> panelList;
    private ArrayList<JLabel> tableList;
    private ArrayList<JTextField> capacityList;
    private SignInWindow signInWindow;
    private LotteryWindow lotteryWindow;

//    Dara part
    GUIManager manager;
    String eventTitle;
    int numOfGroups;
    int groupCapacity;
//    private MidAutumnEventManager midAutumnEventManager;
    private MidAutumnCssaEventImpl midAutumnCssaEvent;

    public MainWindow(GUIManager theManager, String theEventTitle){
//        Construct data
        manager = theManager;
        eventTitle = theEventTitle;
        numOfGroups = manager.numOfGroups;
        groupCapacity = manager.groupsCapacity;
        midAutumnCssaEvent = new MidAutumnCssaEventImpl(groupCapacity, numOfGroups);

//        construct the window (GUI Part)
//        construct the title panel
        titleLabel = new JLabel("Happy Mid-Autumn Festival!");
        titleLabel.setFont(new Font("Goudy Old Style", Font.ITALIC, 70));
        titlePanel = new JPanel();
        titlePanel.setSize(900,200);
        titlePanel.add(titleLabel);

//        construct the table panel
        panelList = new ArrayList<JPanel>(numOfGroups);
        tableList = new ArrayList<JLabel>(numOfGroups);
        capacityList = new ArrayList<JTextField>(numOfGroups);
        tablePanel = new JPanel(new GridLayout(numOfGroups/5 +1,5));
        tablePanel.setSize(900, 500);
        for(int i=0; i<numOfGroups; i++){
//            Flora I really love you!!
            panelList.add(new JPanel());
            tableList.add(new JLabel("Table " + Integer.toString(i+1)));
            capacityList.add(new JTextField("0/" + Integer.toString(groupCapacity)));
            panelList.get(i).add(tableList.get(i));
            panelList.get(i).add(capacityList.get(i));
            panelList.get(i).setSize(30, 30);
            tablePanel.add(panelList.get(i));
        }

//        construct the button panel
        buttonPanel = new JPanel();
        buttonPanel.setSize(900,100);
        signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        signInButton.setSize(200,90);
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signIn();
            }
        });
        lotteryButton = new JButton("Lottery");
        lotteryButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        lotteryButton.setSize(200,90);
        lotteryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lottery();
            }
        });
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        exitButton.setSize(200,90);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
        buttonPanel.add(signInButton);
        buttonPanel.add(lotteryButton);
        buttonPanel.add(exitButton);

//        construct the frame
        myFrame = new JFrame("CSSA Event");
        myFrame.setSize(900,800);
//        myFrame.setLayout(new BoxLayout(, BoxLayout.PAGE_AXIS));
        wholePanel = new JPanel();
        wholePanel.setLayout(new BoxLayout(wholePanel, BoxLayout.PAGE_AXIS));
        wholePanel.add(titlePanel);
        wholePanel.add(tablePanel);
        wholePanel.add(buttonPanel);
        myFrame.add(wholePanel);

        myFrame.setVisible(true);
    }

    public void signIn(){
        signInWindow = new SignInWindow("Please sign in", this);
    }

    public void lottery(){
        lotteryWindow = new LotteryWindow(this);
    }

    public void exit(){
        myFrame.setVisible(false);
    }

    public void addParticipant(String firstName, String lastName, int classLevel, String words, boolean isInspector){
        Participant newParticipant = new Participant();
        newParticipant.setFirstName(firstName);
        newParticipant.setGradYear(classLevel);
        newParticipant.setLastName(lastName);
        newParticipant.setSpectator(isInspector);
        newParticipant.setWords(words);
        int groupNum = midAutumnCssaEvent.addParticipant(newParticipant);
        if (groupNum == -1){
            signInWindow.allTableFull();
            return;
        }
        signInWindow.setInformationArea(Integer.toString(groupNum));

    }

    public void update(){
//        Component[] components = tablePanel.getComponents();
        for(int i=0; i<midAutumnCssaEvent.getParticipantGroups().size(); i++){
            capacityList.get(i).setText(Integer.toString(midAutumnCssaEvent.getParticipantGroups()
                    .get(i).getParticipants().size()) + "/" + Integer.toString(groupCapacity));
        }

    }

    public MidAutumnCssaEventImpl getEvent(){
        return midAutumnCssaEvent;
    }

//    public static void main(String[] args){
//        new MainWindow(new GUIManager(), "testing");
//    }
}
