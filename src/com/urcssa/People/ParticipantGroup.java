package com.urcssa.People;

import java.util.ArrayList;
import java.util.List;
//import com.urcssa.People.Participant;

/**
 * A table at the event
 */
public class ParticipantGroup {
    private String name;
    private int capacity;
    private List<Integer> participants;

    public int getSize() {
        return participants.size();
    }

    public ParticipantGroup(int capacity) {
        this.capacity = capacity;
        participants = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Integer> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Integer> participants) {
        this.participants = participants;
    }

    public boolean atCapacity() {
        return ! (participants.size() < capacity);
    }

    /**
     * Adds participant to the table
     * @param participant
     */
    public int addParticipant(Participant participant) {
        if (!atCapacity()) {
            participants.add(participant.getParticipantNumber());
        }
        return participants.size();
    }
}
