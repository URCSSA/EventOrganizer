package com.urcssa;

import com.urcssa.Gui.MainWindow;
import com.urcssa.Gui.SettingsWindow;
import com.urcssa.Gui.SignInWindow;
import com.urcssa.Gui.WelcomeWindow;

public class GUIManager {
    private WelcomeWindow welcomeWindow;
    private SettingsWindow settingsWindow;
    private MainWindow mainWindow;
    private SignInWindow signInWindow;

    public GUIManager(){
        welcomeWindow = new WelcomeWindow(this);
    }

    public void getEventSettings(){
        settingsWindow = new SettingsWindow();
        welcomeWindow.setInvisible();
    }

    public static void main(String[] args){
        new GUIManager();
    }
}
