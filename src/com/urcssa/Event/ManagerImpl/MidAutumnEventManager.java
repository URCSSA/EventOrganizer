package com.urcssa.Event.ManagerImpl;

import com.urcssa.Event.CssaEvent;
import com.urcssa.Event.EventImpl.MidAutumnCssaEventImpl;
import com.urcssa.Event.EventManager;
import com.urcssa.People.Participant;
import com.urcssa.People.ParticipantGroup;

public class MidAutumnEventManager extends EventManager {

//    public manageWindow;

    public CssaEvent startEvent(int numGroups, int peoplePerGroup) {
        MidAutumnCssaEventImpl midAutumnCssaEvent = new MidAutumnCssaEventImpl();

        midAutumnCssaEvent.setCapacityGroups(numGroups);
        for(int i = 0; i < midAutumnCssaEvent.getCapacityGroups(); i++) {
            midAutumnCssaEvent.addParticipantGroup(new ParticipantGroup(peoplePerGroup));
        }

        return midAutumnCssaEvent;
    }

    //TODO: delete when startEvent(int, int) is done
//    public CssaEvent startEvent(CssaEvent event) {
//        if (event instanceof MidAutumnCssaEventImpl) {
////            log.info("Starting midAutumn event");
//            System.out.println("Starting midAutumn event");
//            MidAutumnCssaEventImpl midAutumnCssaEvent = (MidAutumnCssaEventImpl) event;
//
//            midAutumnCssaEvent.setCapacityGroups(askForCapGroups()); //remember how many fully participating tables there are
//
//            for(int i = 0; i < midAutumnCssaEvent.getCapacityGroups(); i++) {
//                midAutumnCssaEvent.addParticipantGroup(new ParticipantGroup(0));
//            }
//
//            //All "tables" are set. Ready to admit participants!
//
//            while (takeBooleanInput("Continuing adding participant?")) {
//                midAutumnCssaEvent.addParticipant(askForParticipantInfo());
//            }
//
//        }
//        System.out.println("exiting");
//
//        return null;
//    }

    public void saveEvent(CssaEvent event) {

    }

    //TODO change parameter to take EventData file
    public CssaEvent loadEvent() {
        return null;
    }

    /**
     * Asks participant for their name and grad year, and if they want
     * to be just a spectator.
     * Assigns them a participant number and a group number if they want to participate.
     * Assigns them 0 for participant number and group number if they don't.
     * @return
     */
    public Participant askForParticipantInfo() {
        Participant participant = new Participant();
        participant.setFirstName(           askForFirstName());
        participant.setLastName(            askForLastName());
        participant.setGradYear(            askForGradYear());
        participant.setSpectator(           askForSpectator());

        if (!participant.isSpectator()) {
            participant.setParticipantNumber(       assignParticipantNumber()    );
            participant.setGroupNumber(             assignGroupNumber()          );
        }
        else {
            participant.setParticipantNumber(SPECTATOR);
            participant.setGroupNumber(SPECTATOR);
        }

        return participant;
    }

    public Participant selectParticipant() {
        //TODO: need impl
        return null;
    }

    private boolean askForSpectator() {
        return takeBooleanInput("Do you want to play");
    }

    private int askForGradYear() {
        return takeIntInput("What's your grad year");
    }

    private String askForLastName() {
        return takeInput("What's your last name");
    }

    private String askForFirstName() {
        return takeInput("What's your first name");
    }

    /**
     * This API should ask the user to enter a number of max group numbers
     * for active audience.
     * @return
     */
    public int askForCapGroups() {
        //TODO: needs impl
        int answer = 0;

        String message = "Max number of groups is: " + answer;
//        log.info(message);
        return answer;
    }

    /**
     * Should update the groupNum field of the participant
     * AND
     * update the group of the event
     * @return
     */
    private int assignGroupNumber() {
        //TODO need impl
        return 0;
    }

    /**
     * May need to update the participantNum of the participant
     * AND
     * update any relevant field in the event
     * @return
     */
    private int assignParticipantNumber() {
        //TODO need impl
        return 0;
    }
}
