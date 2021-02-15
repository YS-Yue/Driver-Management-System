package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameTest {
    private Name name1;

    @Before
    public void setUp() {
        name1 = new Name("Ann", "Taylor");
    }

    @Test
    public void getFirstName(){
        assertEquals("Ann", name1.getFirstName());
    }

    @Test
    public void getLastName(){
        assertEquals("Taylor", name1.getLastName());
    }

    @Test
    public void testEquals(){
        Name name2 = new Name("Ann", "Taylor");
        Name name3 = new Name("Ann", "Bee");
        Name name4 = new Name("Sarah", "Taylor");

        assertEquals(name1, name1);
        assertEquals(name1, name2);
        assertNotEquals(name1, name3);
        assertNotEquals(name1, name4);
        assertNotEquals(name1, "Ann Taylor");
    }

    @Test
    public void testHashCode(){
        Name name2 = new Name("Ann", "Taylor");
        assertEquals(name1.hashCode(), name2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "Name{firstName='Ann', lastName='Taylor'}";
        assertEquals(expected, name1.toString());
    }
}