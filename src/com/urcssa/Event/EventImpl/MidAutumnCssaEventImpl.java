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
    private int numOfGroups; //there can only be so many tables
    private int numParticipants; //numParticipants instead of capacity because there is no technical limit on num of people

    public MidAutumnCssaEventImpl(int _theGroupCapacity, int _theCapacityGroups){
        participants = new ArrayList<Participant>();
        participantGroups = new ArrayList<ParticipantGroup>();
        groupCapacity = _theGroupCapacity;
        numOfGroups = _theCapacityGroups;
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

    public Participant addParticipant(Participant participant) {
        participants.add(participant);
        numParticipants++;
        participant.setParticipantNumber(numParticipants);

//        Check if we need to construct a new group
        if((participantGroups.size() == 0)||(participantGroups.get(participantGroups.size()-1).atCapacity())){
            ParticipantGroup newGroup = new ParticipantGroup(groupCapacity);
            newGroup.addParticipant(participant);
            participantGroups.add(newGroup);
        }else{
            participantGroups.get(participantGroups.size()-1).addParticipant(participant);
        }

        return participant;
    }

    public ParticipantGroup addParticipantGroup(ParticipantGroup participantGroup) {
        participantGroups.add(numOfGroups, participantGroup);
        numOfGroups++;
        return participantGroup;
    }
}
