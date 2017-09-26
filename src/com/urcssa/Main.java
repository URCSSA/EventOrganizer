package com.urcssa;

import com.urcssa.Event.Manager;
import com.urcssa.Event.EventImpl.MidAutumnCssaEventImpl;
import com.urcssa.Event.ManagerImpl.ActivityManager;


public class Main {

    public static void main(String[] args) {
	// write your code here
        //entry point is CssaEvent.

        Manager manager = new ActivityManager();

        if (manager instanceof ActivityManager) {
            ActivityManager activityManager = (ActivityManager) manager;
            activityManager.setEvent(new MidAutumnCssaEventImpl());
            activityManager.startEvent(activityManager.getEvent());
        }

    }
}
