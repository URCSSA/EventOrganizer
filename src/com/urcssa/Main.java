package com.urcssa;

import com.urcssa.Event.EventManager;
import com.urcssa.Event.EventImpl.MidAutumnCssaEventImpl;
import com.urcssa.Event.ManagerImpl.MidAutumnEventManager;


public class Main {

    public static void main(String[] args) {
	// write your code here
        //entry point is CssaEvent.



    }

    public void startMidAutumn(){
        EventManager eventManager = new MidAutumnEventManager();

        if (eventManager instanceof MidAutumnEventManager) {
            MidAutumnEventManager midAutumnEventManager = (MidAutumnEventManager) eventManager;
            midAutumnEventManager.setEvent(new MidAutumnCssaEventImpl());

            //
//            midAutumnEventManager.setEvent(midAutumnEventManager.loadEvent());

            midAutumnEventManager.startEvent(midAutumnEventManager.getEvent());
        }

    }
}

