/**
 * This class constructs the lottery window to be accessed by main window.
 *
 * @author (Nicholas Wan)
 * @version (09/30/2017)
 */

package com.urcssa.Gui;

//import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;
//import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LotteryWindow {

//    Data
    private MainWindow mainWindow;
    private int maxNumber;
//    Gui
    private JFrame myFrame;
    private JTextField nameField;
    private JPanel namePanel;
    private JPanel buttonPanel;
    private JPanel wholePanel;
    private JButton startButton;
    private JButton stopButton;
    private JButton exitButton;

    public LotteryWindow(MainWindow theMainWindow){
//        Data
        mainWindow = theMainWindow;
        maxNumber = mainWindow.getEvent().getParticipants().size();
        Timer t = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRandomName(maxNumber);
            }
        });
        t.setRepeats(true);

//        Gui
        myFrame = new JFrame();

        namePanel = new JPanel(new BorderLayout());
        nameField = new JTextField(10);
        nameField.setFont(new Font("Goudy Old Style", Font.ITALIC, 120));
        namePanel.add(nameField, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        startButton = new JButton("Start");
        startButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        startButton.setSize(200,90);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.start();
            }
        });
        stopButton = new JButton("Stop");
        stopButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        stopButton.setSize(200,90);
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        });
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 35));
        exitButton.setSize(200,90);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
            }
        });
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(exitButton);

        wholePanel = new JPanel();
        wholePanel.setLayout(new BoxLayout(wholePanel, BoxLayout.PAGE_AXIS));

        wholePanel.add(namePanel);
        wholePanel.add(buttonPanel);
        myFrame.add(wholePanel);
        myFrame.setSize(600,600);
        myFrame.setVisible(true);
    }

    public void printRandomName(int maxNumer){
//        int maxNumber = mainWindow.getEvent().getParticipants().size();
        int num = (int)(Math.random() * maxNumber);
        nameField.setText(mainWindow.getEvent().getParticipants().get(num).getFirstName() + "  " +
                mainWindow.getEvent().getParticipants().get(num).getLastName());
    }


}
