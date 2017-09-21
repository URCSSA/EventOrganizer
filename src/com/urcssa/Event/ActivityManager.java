package com.urcssa.Event;

import com.urcssa.Event.EventImpl.MidAutumnCssaEventImpl;
import com.urcssa.People.Participant;

/**
 * Provides APIs for updating activity details such as signIn(), lotteryDraw(), randCall()
 * Also provides APIs for I/O features such as saving/opening activity status
 */
public class ActivityManager {
    CssaEvent event; //the event this manager is managing

    public ActivityManager(CssaEvent event) {
        this.event = event;
    }

    public CssaEvent startEvent(CssaEvent event) {
        if (event instanceof MidAutumnCssaEventImpl) {
            MidAutumnCssaEventImpl midAutumnCssaEvent = (MidAutumnCssaEventImpl) event;

            midAutumnCssaEvent.setCapacityGroups(askForCapGroups()); //remember how many fully participating tables there are

        }
        return null;
    }

    public Participant askForParticipant() {
        return new Participant();
    }

    public int askForCapGroups() {
        return 0;
    }

}
