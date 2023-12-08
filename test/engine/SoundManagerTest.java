package engine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundManagerTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void playSound() {
        SoundManager soundManager = new SoundManager();
        boolean noExceptionThrown = true;
        try {
            soundManager.playSound("BGM/B_Main_e", "help", false, true);
        } catch (Exception e) {
            noExceptionThrown = false;
        }
        assertTrue(noExceptionThrown, "playSound should not throw an exception");

    }

    @Test
    void stopSound() {
        SoundManager soundManager = new SoundManager();
        boolean noExceptionThrown = true;
        try {
            soundManager.stopSound("menu", 1f);
        } catch (Exception e) {
            noExceptionThrown = false;
        }
        assertTrue(noExceptionThrown, "stopSound should not throw an exception");

    }
}