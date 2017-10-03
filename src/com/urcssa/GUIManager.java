/**
 * This class constructs the GUIManager to access Welcome Window, Settings Window and Main Window.
 *
 * @author (Nicholas Wan)
 * @version (09/30/2017)
 */
package com.urcssa;

import com.urcssa.Event.ManagerImpl.MidAutumnEventManager;
import com.urcssa.Gui.MainWindow;
import com.urcssa.Gui.SettingsWindow;
import com.urcssa.Gui.WelcomeWindow;

public class GUIManager {
    public int numOfGroups;
    public int groupsCapacity;
    private WelcomeWindow welcomeWindow;
    private SettingsWindow settingsWindow;

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
        MainWindow mainWindow = new MainWindow(new MidAutumnEventManager(), "Happy Mid-autumn Festival!");
    }

    public static void main(String[] args){
        new GUIManager();
    }
}
