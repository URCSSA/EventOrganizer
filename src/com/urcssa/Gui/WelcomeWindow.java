package com.urcssa.Gui;

/**
 * This class constructs a welcome window for CSSA.
 *
 * @author (Nicholas Wan)
 * @version (09/28/2017)
 */

import com.urcssa.GUIManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.beans.PropertyChangeListener;
import java.lang.*;
import javax.swing.*;

public class WelcomeWindow {

    public JFrame myFrame;
    private JPanel myPanel;
    private JButton midAutumnButton;
    private JButton springFestivalButton;
    private GUIManager manager;

    public WelcomeWindow(GUIManager guiManager){
        manager = guiManager;

        myFrame = new JFrame("Please choose an event");
//        construct buttons
        midAutumnButton = new JButton("Start Mid-Autumn Festival");
//        midAutumnButton.setActionCommand("midAutumn");
        midAutumnButton.setPreferredSize(new Dimension(350,150));
        midAutumnButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 30));
        midAutumnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                midAutumnButtonClicked();
            }
        });

        springFestivalButton = new JButton("Start Spring Festival");
//        springFestivalButton.setActionCommand("spring");
        springFestivalButton.setPreferredSize(new Dimension(350,150));
        springFestivalButton.setFont(new Font("Goudy Old Style", Font.ITALIC, 30));


        myPanel = new JPanel(new FlowLayout());
        myPanel.add(midAutumnButton);
        myPanel.add(springFestivalButton);
        myFrame.add(myPanel);

        myFrame.setSize(400,400);
//        myFrame.setLayout(new BorderLayout());
        myFrame.setVisible(true);
    }

    public void midAutumnButtonClicked(){
        manager.getEventSettings();
    }

    public void setInvisible(){
        myFrame.setVisible(false);
    }

}
