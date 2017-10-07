
package com.urcssa.Event.ManagerImpl;

import com.urcssa.Event.CssaEvent;
import com.urcssa.Event.EventImpl.MidAutumnEventImpl;
import com.urcssa.Event.EventManager;
import com.urcssa.People.Participant;
import com.urcssa.People.ParticipantGroup;

import java.io.*;
import java.util.Date;
import java.util.Scanner;


public class MidAutumnEventManagerImpl extends EventManager {
    private static String metadataFileName = "metadata.cssa";
    private String csvFilePath;
    private String metatdatafilepath;

    /*    public CssaEvent startEvent() {
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
    }*/

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

    public void updateEventData(Participant participant) throws Exception {
        if (csvFilePath != null) {
            File outFile = new File (csvFilePath);
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(outFile, true))) {
                pw.println(participant.toString());
            } catch (FileNotFoundException e) {
                String message = "FileNotFoundException caught when writing data";
                throw new Exception(message);
            }
        }
    }

    /**
     * Takes an absolute path to a file or directory. Checks
     * if the path is to a file that it has .cssa extension.
     * Creates a new metadata.cssa file if path is to directory.
     * @param outFilePath
     * @throws Exception
     */
    public void saveEvent(String outFilePath) throws Exception {

        File outFile = new File(outFilePath);

        if (outFile.isDirectory()) {
            outFile = new File(outFilePath + "/" + metadataFileName);
        }
        else {
            if (!outFile.exists())
                outFile.createNewFile();
            if (!outFilePath.endsWith(".cssa")) {
                outFilePath = outFilePath + ".cssa";
                outFile = new File(outFilePath);
            }
        }

        metatdatafilepath = outFile.getAbsolutePath();

        //here, outFile refers to a file named metadata.cssa
        writeMetaData(outFile);
        writeData(outFile);
    }

    /**
     * Writes metadata to file. Assumes the file is empty/does not contain meaningful information.
     * Overwrites the file.
     * @param file
     * @throws Exception
     */
    private void writeMetaData(File file) throws Exception {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(new Date (System.currentTimeMillis()).toString()); //Start with date
            pw.println(getEvent().toString());
            csvFilePath = file.getParentFile().getAbsolutePath() + "/Participants.csv";
            pw.println(csvFilePath);
        } catch (FileNotFoundException e) {
            String message = "FileNotFoundException caught when writing metadata";
            throw new Exception(message);
        }

    }

    private void writeData(File file) throws Exception {
        File outFile = new File (file.getParentFile().getAbsolutePath() + "/Participants.csv");
//        try (PrintWriter pw = new PrintWriter(new FileOutputStream(outFile, true))) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(outFile))) {
                getEvent().getAllParticipant().forEach(participant -> {
                pw.println(participant.toString());
            });
        } catch (FileNotFoundException e) {
            String message = "FileNotFoundException caught when writing data";
            throw new Exception(message);
        }

    }

    public CssaEvent loadEvent(String inFilePath) throws Exception {
        File inFile = new File(inFilePath);

        if (!inFile.getName().endsWith(".cssa")) {
            String message = "Wrong type of file is given";
            throw new Exception(message);
        }
        MidAutumnEventImpl event = null;
        event = loadMetaData(inFile);
        event = loadData(inFile, event);
        return event;
    }

    private MidAutumnEventImpl loadMetaData(File inFile) throws Exception {
        try (Scanner s = new Scanner(inFile)) {
            if (s.hasNextLine()) { //skip the line of date
                s.nextLine();
            }
            String[] tokens = s.nextLine().split(",");
            MidAutumnEventImpl event = new MidAutumnEventImpl(
                    Integer.parseInt(tokens[MidAutumnEventImpl.NUM_GROUP_POS])  ,
                    Integer.parseInt(tokens[MidAutumnEventImpl.GROUP_SIZE_POS]));

            csvFilePath = s.nextLine();
            return event;

        } catch (FileNotFoundException e) {
            String message = "FileNotFoundException caught when reading metadata";
            throw new Exception(message);
        }
    }

    private MidAutumnEventImpl loadData(File inFile, MidAutumnEventImpl event) throws Exception {
        try (Scanner s = new Scanner(inFile)) {
            if (s.hasNextLine()) { //skip the line of date
                s.nextLine();
            }
            if (s.hasNextLine()) { //skip the line of event data
                s.nextLine();
            }


            String dataPath = s.nextLine();

            try (Scanner csvScan = new Scanner(new File(dataPath))) {
                while (csvScan.hasNextLine()) {
                    String[] tokens = csvScan.nextLine().split(",");
                    Participant participant = new Participant();
                    participant.setFirstName(           tokens[Participant.FIRST_NAME_POS]);
                    participant.setLastName(            tokens[Participant.LAST_NAME_POS]);
                    participant.setGradYear(            Integer.parseInt(tokens[Participant.GRAD_YEAR_POS].trim()));
                    participant.setSpectator(           Boolean.parseBoolean(tokens[Participant.IS_SPECTATOR_POS].trim()));
                    participant.setGroupNumber(         Integer.parseInt(tokens[Participant.GROUP_NUM_POS].trim()));
                    participant.setParticipantNumber(   Integer.parseInt(tokens[Participant.PARTICIPANT_NUM_POS].trim()));
//                    participant.setRemark(              tokens[Participant.REMARK_POS].trim());
                    event.addParticipant(participant);
                }
                return event;
            }

        } catch (FileNotFoundException e) {
            String message = "FileNotFoundException caught when reading data";
            throw new Exception(message);
        }

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
        try {
            updateEventData(participant);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
