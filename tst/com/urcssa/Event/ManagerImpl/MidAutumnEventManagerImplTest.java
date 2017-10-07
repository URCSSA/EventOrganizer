package com.urcssa.Event.ManagerImpl;

import com.urcssa.Event.EventImpl.MidAutumnEventImpl;
import org.junit.Before;
import org.junit.Test;

public class MidAutumnEventManagerImplTest {
    private MidAutumnEventManagerImpl manager;
    private static int NUM_PARTICIPANT = 2;
    private static int NUM_GROUP = 2;

    @Before
    public void setUp() {
        manager = new MidAutumnEventManagerImpl();
        manager.startEvent(NUM_PARTICIPANT, NUM_GROUP);
        manager.addParticipant("fn", "ln", 2019, "", true);

        manager.addParticipant("fn", "ln", 2018, "", true);
    }

    @Test
    public void saveEvent_outputs_to_dir() throws Exception {
        String targetDir = "savedData";
        manager.saveEvent(targetDir);
    }

}
