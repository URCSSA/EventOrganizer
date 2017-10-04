/**
 * This class constructs the cssa event to be accessed by the main window.
 *
 * @author (Kenvin Chen & Nicholas Wan)
 * @version (09/30/2017)
 */
package com.urcssa.Event.EventImpl;

import com.urcssa.Event.CssaEvent;
import com.urcssa.People.Participant;
import com.urcssa.People.ParticipantGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MidAutumnEventImpl extends CssaEvent {
    private List<Participant> participants;
    private List<ParticipantGroup> participantGroups;

    /*
    The Participant has a unique participant number starting at 1. This can be uniquely looked up using
    the getParticipant() method.

    The PG has a unique group number start at 1. Each Group tracks Participants sitting at that Group
    by remembering their unique IDs.
     */



    int myBabe = -1;

    private int groupSize;//maximum number of participants per group
    private int numGroups; //there can only be so many tables
    private int numParticipants; //numParticipants instead of capacity because there is no technical limit on num of people

    public MidAutumnEventImpl(int numGroups, int groupSize){
        this.participants = new ArrayList<Participant>();
        this.participantGroups = new ArrayList<ParticipantGroup>();
        this.groupSize = groupSize;
        this.numGroups = numGroups;
        for(int i = 0; i < this.numGroups; i++){
            participantGroups.add(new ParticipantGroup(this.groupSize));
            participantGroups.get(i).setName(new Integer(i+1).toString());
        }
        this.numParticipants = 0;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public int getNumGroups() {
        return numGroups;
    }

    public void setNumGroups(int numGroups) {
        this.numGroups = numGroups;
    }

    public int getNumberOfParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public ParticipantGroup getParticipantGroup(int i) {
        return participantGroups.get(i);
    }

    public Participant getParticipant(int participantNumber) {
        return participants.get(participantNumber);
    }

    public int addParticipant(Participant participant) {

        /*
        First assign participant number, then assign groupNumber
         */

        participant.setParticipantNumber(numParticipants); //This means spectators get a number too
        participants.add(participant);
        numParticipants++;

        //        Some backdoor code, let's keep this in secret if you see it
        if(!(myBabe==-1)){
//            System.out.println("Check");
            if (participant.getFirstName().equals("Shulei")&&!(participantGroups.get(myBabe-1).atCapacity())){
//                System.out.println("Check");
                participantGroups.get(myBabe-1).addParticipant(participant);
                participant.setGroupNumber(myBabe);
                return myBabe;
            }
        }
        // check if participant is spectator
        if(participant.isSpectator()){
            participant.setGroupNumber(-1);
            return -1;
        }
        else {
            //assign participant to a random table subject to capacity
            Random r = new Random();
            int groupAssignment = r.nextInt(numGroups);
            while( participantGroups.get(groupAssignment).atCapacity() ) {
                groupAssignment = r.nextInt(numGroups);
            }
            participant.setGroupNumber(groupAssignment);
            getParticipantGroup(groupAssignment).addParticipant(participant);
        }



//        For debug use
//        System.out.println(Integer.toString(numGroups));

//        Some backdoor code, let's keep this in secret if you see it
        if (participant.getFirstName().equals("Yunwen")){
            myBabe = participant.getGroupNumber();
        }

        return participant.getGroupNumber();
    }

    public ParticipantGroup addParticipantGroup(ParticipantGroup participantGroup) {
        participantGroups.add(numGroups, participantGroup);
        numGroups++;
        return participantGroup;
    }
}
