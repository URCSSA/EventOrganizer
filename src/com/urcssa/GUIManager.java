package com.urcssa;

import com.urcssa.Gui.MainWindow;
import com.urcssa.Gui.SettingsWindow;
import com.urcssa.Gui.SignInWindow;
import com.urcssa.Gui.WelcomeWindow;

public class GUIManager {
    public int numOfGroups;
    public int groupsCapacity;
    private WelcomeWindow welcomeWindow;
    private SettingsWindow settingsWindow;
    private MainWindow mainWindow;
    private SignInWindow signInWindow;

    public GUIManager(){
        welcomeWindow = new WelcomeWindow(this);
    }

    public void getEventSettings(){
        settingsWindow = new SettingsWindow(this);
        welcomeWindow.setInvisible();
    }

    public void getMainWindow(){
        numOfGroups = settingsWindow.getNumOfGroup();
        groupsCapacity = settingsWindow.getGroupCapacity();
        settingsWindow.setInvisible();
        mainWindow = new MainWindow(this, "Happy Mid-autumn Festival!");
    }

    public static void main(String[] args){
        new GUIManager();
    }

}
