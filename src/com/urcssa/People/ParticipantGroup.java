package com.urcssa.People;

import java.util.List;

/**
 * A table at the event
 */
public class ParticipantGroup {
    private int capacity;
    private List<Integer> participants;

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

    /**
     * Adds participant to the table
     * @param participant
     */
    public void addParticipant(Participant participant) {

    }
}
