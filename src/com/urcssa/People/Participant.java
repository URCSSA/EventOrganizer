package com.urcssa.People;

public class Participant {
    private String firstName;
    private String lastName;
    private int gradYear;
    public boolean isSpectator; //a spectator is someone who won't be participating in games
    private String remark = "NULL";

    private int participantNumber;//1 - max number
    private int groupNumber;//1 - numOfTable


    public boolean isSpectator() {
        return isSpectator;
    }

    public void setSpectator(boolean spectator) {
        isSpectator = spectator;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setRemark(String s){ this.remark = s;}

    public String getRemark(){return remark;}

    @Override
    public String toString() {
        String delimiter = ", ";
        return new StringBuffer().append(firstName).append(delimiter)
                .append(lastName).append(delimiter)
                .append(gradYear).append(delimiter)
                .append(isSpectator).append(delimiter)
                .append(participantNumber).append(delimiter)
                .append(groupNumber)
                .toString();
    }

    public static final int FIRST_NAME_POS = 0;
    public static final int LAST_NAME_POS = 1;
    public static final int GRAD_YEAR_POS = 2;
    public static final int IS_SPECTATOR_POS = 3;
    public static final int PARTICIPANT_NUM_POS = 4;
    public static final int GROUP_NUM_POS = 5;
    public static final int REMARK_POS = 6;

}
