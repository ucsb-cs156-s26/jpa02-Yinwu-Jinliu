package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        // TODO: Replace Chris G. with your name as shown on
        // <https://bit.ly/cs156-s26-teams>
        assertEquals("Binghao C.", Developer.getName());
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

        @Test
        public void getGithubId_returns_correct_github_id() {
            assertEquals("Yinwu-Jinliu", Developer.getGithubId());
        }

        @Test
        public void getTeam_returns_team_with_correct_members() {
            Team t = Developer.getTeam();
            assertTrue(t.getMembers().contains("Andy W."),"Team should contain Andy W.");
            assertTrue(t.getMembers().contains("Binghao C."),"Team should contain Binghao C.");
            assertTrue(t.getMembers().contains("Oscar V."),"Team should contain Oscar V.");
            assertTrue(t.getMembers().contains("Shanqin C."),"Team should contain Shanqin C.");
            assertTrue(t.getMembers().contains("Sherwin R."),"Team should contain Sherwin R.");
            assertTrue(t.getMembers().contains("Whisper X."),"Team should contain Whisper X.");
    }
}
