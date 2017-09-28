package com.urcssa;

import com.urcssa.Event.EventManager;
import com.urcssa.Event.EventImpl.MidAutumnCssaEventImpl;
import com.urcssa.Event.ManagerImpl.MidAutumnEventManager;
import com.urcssa.Gui.MainWindow;
import com.urcssa.Gui.WelcomeWindow;
import com.urcssa.Gui.SettingsWindow;
import com.urcssa.Gui.SignInWindow;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //entry point is CssaEvent.

        new WelcomeWindow();
//  Get a welcome gui window and determine if it's a mid-autumn event
        startMidAutumn();


    }

    public static void startMidAutumn(){
        String midAutumn = "Welcome to Mid-autumn Festival";
        MidAutumnEventManager midAutumnEventManager = new MidAutumnEventManager();

        SettingsWindow midAutumnSettings = new SettingsWindow();

        int numOfGroup = midAutumnSettings.getNumOfGroup();
        int getGroupCpacity = midAutumnSettings.getGroupCapacity();

//        MidAutumnEventManager midAutumnEventManager = (MidAutumnEventManager) eventManager;
        midAutumnEventManager.setEvent(new MidAutumnCssaEventImpl());
        MainWindow midAutumnWindow = new MainWindow();
            //
//      midAutumnEventManager.setEvent(midAutumnEventManager.loadEvent());

        //Start when sign-in is clicked
        SignInWindow midAutumnSignInWindow = new SignInWindow(midAutumn);

        midAutumnEventManager.startEvent(midAutumnEventManager.getEvent());

    }

    public static void startSomethingElse(){

    }
}

