package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void equals_returns_true_for_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        assertEquals(false, team.equals("a string"));
    }

    @Test
    public void equals_returns_true_for_identical_fields() {
        Team other = new Team("test-team");
        assertEquals(true, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team other = new Team("different-team");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void hashCode_returns_same_for_identical_teams() {
        Team t1 = new Team("test-team");
        Team t2 = new Team("test-team");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_kills_bitwise_mutant() {
        int expectedResult = team.getName().hashCode() | team.getMembers().hashCode();
        assertEquals(expectedResult, team.hashCode());
    }
}
