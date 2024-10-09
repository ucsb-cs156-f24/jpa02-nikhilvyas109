package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void equal_returns_correct_boolean_same_object() {
        Team t = new Team();
        assertTrue(t.equals(t), "Same Object should be true");
    }

    @Test
    public void equal_returns_correct_boolean_different_class() {
        Team t = new Team();
        int i = 0;
        assertFalse(t.equals(i), "Not Team, should be false");
    }

    @Test
    public void equal_returns_correct_boolean_equivalent_teams() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertTrue(t1.equals(t2), "Teams are identical, should be true");
    }

    @Test
    public void equal_returns_correct_boolean_different_names() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("bar");
        t2.addMember("bar");
        assertFalse(t1.equals(t2), "Different Names, should be false");
    }

    @Test
    public void equal_returns_correct_boolean_different_members() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("foo");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertFalse(t1.equals(t2), "Different Members, should be false");
    }

    @Test
    public void hashCode_equal_for_equivalent_teams() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    public void hashCode_is_correct_value() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
