package com.urcssa.Event;

//Comment out to test GUI
//import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Provides APIs for updating activity details such as signIn(), lotteryDraw(), randCall()
 * Also provides APIs for I/O features such as saving/opening activity status
 *
 * A generic manager manages an event. The event knows nothing about its manager.
 */
public class EventManager {
    protected static final int SPECTATOR = -1;

    protected CssaEvent event; //the event this manager is managing

    public EventManager() {
//        this.log = Logger.getLogger(EventManager.class);
    }

    public EventManager(CssaEvent event) {
        this.event = event;
    }


    /**
     * A helper method to ask the question to stdout and receive answer via stdin
     * This answer is reported as a string.
     * @param question
     * @return
     */
    protected String takeInput(String question) {
        System.out.println(question);
        Scanner s = new Scanner(System.in);
        String answer = null;
        if (s.hasNextLine()) {
            answer = s.nextLine();
        }
        s.close();
        return answer;
    }

    /**
     * A helper method to ask the question to stdout and receive answer via stdin
     * Answer reported as int
     * @param question
     * @return
     */
    protected int takeIntInput(String question) {
        Scanner s = new Scanner(System.in);
        System.out.println(question);
        int answer = 0;
        if (s.hasNextInt()) {
            answer = s.nextInt();
        }
        s.close();
        return answer;
    }

    /**
     * A helper method to ask the question to stdout and receive answer via stdin
     * Answer reported as boolean
     * @param question
     * @return
     */
    protected boolean takeBooleanInput(String question) {
        Scanner s = new Scanner(System.in);
        System.out.println(question);
        boolean answer = false;
        if (s.hasNextBoolean()) {
            answer = s.nextBoolean();
        } else if (s.hasNextLine()) {
            switch (s.next().charAt(0)) {
                case('y'):
                case('Y'):
                    answer = true;
                    break;
                case('n'):
                case('N'):
                    answer = false;
                    break;
                default:
                    break;
            }
        }
        s.close();
        return answer;
    }

    protected CssaEvent getEvent() {
        return event;
    }

    protected void setEvent(CssaEvent event) {
        this.event = event;
    }
}
