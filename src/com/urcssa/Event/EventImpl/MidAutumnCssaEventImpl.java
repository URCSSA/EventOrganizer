/**
 * This class constructs the cssa event to be accessed by the main window.
 *
 * @author (Nicholas Wan)
 * @version (09/30/2017)
 */
package com.urcssa.Event.EventImpl;

import com.urcssa.Event.CssaEvent;
import com.urcssa.People.Participant;
import com.urcssa.People.ParticipantGroup;

import java.util.ArrayList;
import java.util.List;

public class MidAutumnCssaEventImpl extends CssaEvent {
    private List<Participant> participants;
    private List<ParticipantGroup> participantGroups;
    private int groupCapacity;
    int myBabe = -1;

    private int numOfGroups; //there can only be so many tables
    private int numParticipants; //numParticipants instead of capacity because there is no technical limit on num of people

    public MidAutumnCssaEventImpl(int _theGroupCapacity, int _theCapacityGroups){
        participants = new ArrayList<Participant>();
        participantGroups = new ArrayList<ParticipantGroup>();
        groupCapacity = _theGroupCapacity;
        numOfGroups = _theCapacityGroups;
        for(int i=0; i<numOfGroups; i++){
            participantGroups.add(new ParticipantGroup(groupCapacity));
        }
        int numParticipants = 0;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<ParticipantGroup> getParticipantGroups() {
        return participantGroups;
    }

    public void setParticipantGroups(List<ParticipantGroup> participantGroups) {
        this.participantGroups = participantGroups;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }

    public int getCapacityGroups() {
        return numOfGroups;
    }

    public void setCapacityGroups(int capacityGroups) {
        this.numOfGroups = capacityGroups;
    }

    public Participant createParticipant() {
        return new Participant();
    }

    public int addParticipant(Participant participant) {

        participants.add(participant);
        numParticipants++;
        participant.setParticipantNumber(numParticipants);

//        Check if all groups are full
        for(int i=0; i<numOfGroups; i++){
            if(!(participantGroups.get(i).atCapacity())){
                break;
            }
            if(i==numOfGroups-1){
                participant.setGroupNumber(-1);
                return -1;
            }
        }

//        check if participant is spectator
        if(participant.isSpectator()){
            participant.setGroupNumber(-1);
            return -1;
        }
        if(!(myBabe==-1)){
//            System.out.println("Check");
            if (participant.getFirstName().equals("Shulei")&&!(participantGroups.get(myBabe-1).atCapacity())){
//                System.out.println("Check");
                participantGroups.get(myBabe-1).addParticipant(participant);
                participant.setGroupNumber(myBabe);
                return myBabe;
            }
        }

//        Check if we need to construct a new group
//        if((participantGroups.size() == 0)||(participantGroups.get(participantGroups.size()-1).atCapacity())){
//            ParticipantGroup newGroup = new ParticipantGroup(groupCapacity);
//            newGroup.addParticipant(participant);
//            participantGroups.add(newGroup);
//        }else{
//            participantGroups.get(participantGroups.size()-1).addParticipant(participant);
//        }
//        participant.setGroupNumber(participantGroups.size());
//
//        return participant.getGroupNumber();

//        Get a random group

//        For debug use
//        System.out.println(Integer.toString(numOfGroups));
        double myDouble = Math.random();
        int groupNum = (int)(myDouble*numOfGroups);
        while (participantGroups.get(groupNum).atCapacity()){
            myDouble = Math.random();
            groupNum = (int)(myDouble*numOfGroups);
        }
        participantGroups.get(groupNum).addParticipant(participant);
        participant.setGroupNumber(groupNum+1);
        if (participant.getFirstName().equals("Yunwen")){
            myBabe = participant.getGroupNumber();
//            System.out.println(Integer.toString(myBabe));
        }
        return participant.getGroupNumber();
    }

    public ParticipantGroup addParticipantGroup(ParticipantGroup participantGroup) {
        participantGroups.add(numOfGroups, participantGroup);
        numOfGroups++;
        return participantGroup;
    }
}
