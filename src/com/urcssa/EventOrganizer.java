/**
 * This class constructs the EventOrganizer to access Welcome Window, Settings Window and Main Window.
 *
 * @author (Nicholas Wan)
 * @version (09/30/2017)
 */
package com.urcssa;

import com.urcssa.Event.ManagerImpl.MidAutumnEventManagerImpl;
import com.urcssa.Gui.MainWindow;
import com.urcssa.Gui.SettingsWindow;
import com.urcssa.Gui.WelcomeWindow;

public class EventOrganizer {
    public int numGroups;
    public int groupSize;
    private WelcomeWindow welcomeWindow;
    private SettingsWindow settingsWindow;

    public EventOrganizer(){
        welcomeWindow = new WelcomeWindow(this);
    }

    public void retrieveMidAutumnEventSettings(){
        settingsWindow = new SettingsWindow(this);
        welcomeWindow.setInvisible();
    }

    public void startMidAutumnMainWindow(){
        numGroups = settingsWindow.getNumOfGroup();
        groupSize = settingsWindow.getGroupSize();
        MidAutumnEventManagerImpl manager = new MidAutumnEventManagerImpl().startEvent(numGroups, groupSize);

        settingsWindow.setInvisible();
        MainWindow mainWindow = new MainWindow(manager, "Happy Mid-autumn Festival!");
    }

    public static void main(String[] args){
        new EventOrganizer();
    }
}
