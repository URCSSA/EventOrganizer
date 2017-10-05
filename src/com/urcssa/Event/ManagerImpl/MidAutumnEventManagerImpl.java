
package com.urcssa.Event.ManagerImpl;

import com.urcssa.Event.CssaEvent;
import com.urcssa.Event.EventImpl.MidAutumnEventImpl;
import com.urcssa.Event.EventManager;
import com.urcssa.People.Participant;
import com.urcssa.People.ParticipantGroup;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class MidAutumnEventManagerImpl extends EventManager {


    public CssaEvent startEvent() {
        if (event instanceof MidAutumnEventImpl) {
//            log.info("Starting midAutumn event");
            System.out.println("Starting midAutumn event");
            MidAutumnEventImpl midAutumnCssaEvent = (MidAutumnEventImpl) event;

            midAutumnCssaEvent.setNumGroups(askForNumGroups()); //remember how many fully participating tables there are

            for (int i = 0; i < midAutumnCssaEvent.getNumGroups(); i++) {
                midAutumnCssaEvent.addParticipantGroup(new ParticipantGroup(0));
            }

            //All "tables" are set. Ready to admit participants!

        }
        return null;
    }

    /**
     * Initializes a MidAutumnEventManager using input given
     * @param groupSize
     * @param numGroups
     * @return
     */
    public MidAutumnEventManagerImpl startEvent(int numGroups, int groupSize) {
        event = new MidAutumnEventImpl(numGroups, groupSize);

        return this;
    }

    public void saveEvent(String outFileName) throws Exception {
        FileOutputStream saveEvent = new FileOutputStream("SaveEvent.sav");
        ObjectOutputStream save = new ObjectOutputStream(saveEvent);
//        save.writeObject();
//        save.wtireObject(group);
        save.close();

    }

    public CssaEvent loadEvent(String inFileName) throws Exception {
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

    public int getGroupSize() {
        return getEvent().getGroupSize();
    }

    public ParticipantGroup getParticipantGroup(int i) {
        return getEvent().getParticipantGroup(i);
    }

    protected MidAutumnEventImpl getEvent() {
        if (super.getEvent() instanceof MidAutumnEventImpl) {
            return (MidAutumnEventImpl) super.getEvent();
        } else throw new TypeNotPresentException("This manager is not managing a MidAutumn activity", new Exception());
    }

    public int numberOfGroups() {
        return  getEvent().getNumGroups();
    }

    public int numberOfParticipants() {
        return getEvent().getNumberOfParticipants();
    }

    /**
     * Given a participant number, returns a specific participant
     * @param participantNumber
     * @return
     */
    public Participant selectParticipant(int participantNumber) {
        return getEvent().getParticipant(participantNumber);
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
    public Participant addParticipant(String firstName, String lastName, int gradYear, String remark, boolean isSpectator) {
        Participant participant = new Participant();
        participant.setFirstName( firstName);
        participant.setLastName(  lastName         ) ;
        participant.setGradYear(   gradYear         );
        participant.setRemark(remark);
        participant.setSpectator(  isSpectator         );

        //The above fields are created here. Assignments of group and participant number are
        //done by the seating method.

        seatParticipant(participant);

        return participant;
    }

    /**
     * Sends the Participant (whose biographic information is provided) to
     * the activity for group and participant number assignment
     * @param participant
     * @return
     */
    public Participant seatParticipant(Participant participant) {
        MidAutumnEventImpl event = getEvent();
        event.addParticipant(participant);
        return participant;
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
    public int askForNumGroups() {
        int answer = 0;

        String message = "Max number of groups is: " + answer;
//        log.info(message);
        return answer;
    }
}
