package com.urcssa.Event.EventImpl;

import com.urcssa.Event.CssaEvent;
import com.urcssa.People.Participant;
import com.urcssa.People.ParticipantGroup;

import java.util.List;

public class MidAutumnCssaEventImpl extends CssaEvent {
    private List<Participant> participants;
    private List<ParticipantGroup> participantGroups;
    private int capacityGroups; //there can only be so many tables
    private int numParticipants; //numParticipants instead of capacity because there is no technical limit on num of people

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
        return capacityGroups;
    }

    public void setCapacityGroups(int capacityGroups) {
        this.capacityGroups = capacityGroups;
    }

    public Participant createParticipant() {
        return new Participant();
    }

    public Participant addParticipant(Participant participant) {
        participants.add(numParticipants, participant);
        numParticipants++;
        return participant;
    }

    public ParticipantGroup addParticipantGroup(ParticipantGroup participantGroup) {
        participantGroups.add(capacityGroups, participantGroup);
        capacityGroups++;
        return participantGroup;
    }
}
