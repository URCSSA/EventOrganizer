
package com.urcssa.Event.ManagerImpl;

import com.urcssa.Event.CssaEvent;
import com.urcssa.Event.EventImpl.MidAutumnCssaEventImpl;
import com.urcssa.Event.EventManager;
import com.urcssa.People.Participant;
import com.urcssa.People.ParticipantGroup;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MidAutumnEventManager extends EventManager {

//    public manageWindow;


    public CssaEvent startEvent(CssaEvent event) {
        if (event instanceof MidAutumnCssaEventImpl) {
//            log.info("Starting midAutumn event");
            System.out.println("Starting midAutumn event");
            MidAutumnCssaEventImpl midAutumnCssaEvent = (MidAutumnCssaEventImpl) event;

            midAutumnCssaEvent.setCapacityGroups(askForCapGroups()); //remember how many fully participating tables there are

            for (int i = 0; i < midAutumnCssaEvent.getCapacityGroups(); i++) {
                midAutumnCssaEvent.addParticipantGroup(new ParticipantGroup(0));
            }

            //All "tables" are set. Ready to admit participants!

            while (takeBooleanInput("Continuing adding participant?")) {
//                midAutumnCssaEvent.addParticipant(populateParticipant(firstName, lastName, gradYear, isSpectator));
            }
        }
        return null;
    }


    public void saveEvent(CssaEvent event) throws Exception {
        FileOutputStream saveEvent = new FileOutputStream("SaveEvent.sav");
        ObjectOutputStream save = new ObjectOutputStream(saveEvent);
//        save.writeObject();
//        save.wtireObject(group);
        save.close();

    }

    public CssaEvent loadEvent() throws Exception {
        FileInputStream saveEvent = new FileInputStream("SaveEvent.sav");
        ObjectInputStream save = new ObjectInputStream(saveEvent);

        save.close();

        System.out.println("\tparticipant: " );

//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    /**
     * Asks participant for their name and grad year, and if they want
     * to be just a spectator.
     * Assigns them a participant number and a group number if they want to participate.
     * Assigns them 0 for participant number and group number if they don't.
     * @return
     * @param firstName
     * @param lastName
     * @param gradYear
     * @param isSpectator
     */
    public Participant populateParticipant(String firstName, String lastName, int gradYear, String remark, boolean isSpectator) {
        Participant participant = new Participant();
        participant.setFirstName( firstName);
        participant.setLastName(  lastName         ) ;
        participant.setGradYear(   gradYear         );
        participant.setRemark(remark);
        participant.setSpectator(  isSpectator         );

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

    public Participant seatParticipant(Participant participant) {
        MidAutumnCssaEventImpl event = (MidAutumnCssaEventImpl)this.getEvent();
        event.addParticipant(participant);
        return participant;
    }

    public Participant selectParticipant() {
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
        return 0;
    }

    /**
     * May need to update the participantNum of the participant
     * AND
     * update any relevant field in the event
     * @return
     */
    private int assignParticipantNumber() {
        return 0;
    }
}
