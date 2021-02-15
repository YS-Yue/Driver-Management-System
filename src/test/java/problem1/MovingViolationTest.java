package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MovingViolationTest {
    private MovingViolation mv1;

    @Before
    public void setUp() {
        mv1 = new MovingViolation(LocalDate.of(2020, 5, 20), MovingType.SPEEDING);
    }

    @Test
    public void getViolationDate(){
        assertEquals(LocalDate.of(2020, 5, 20), mv1.getViolationDate());
    }

    @Test
    public void getType(){
        assertEquals(MovingType.SPEEDING, mv1.getType());
    }

    @Test
    public void testEquals(){
        MovingViolation mv2 = new MovingViolation(LocalDate.of(2020, 5, 20), MovingType.SPEEDING);
        MovingViolation mv3 = new MovingViolation(LocalDate.of(2020, 6, 20), MovingType.SPEEDING);
        MovingViolation mv4 = new MovingViolation(LocalDate.of(2020, 5, 20), MovingType.DISTRACTED_DRIVING);

        assertEquals(mv1, mv1);
        assertEquals(mv1, mv2);
        assertNotEquals(mv1, mv3);
        assertNotEquals(mv1, mv4);
        assertNotEquals(mv1, "mv1");
    }

    @Test
    public void testHashCode(){
        MovingViolation mv2 = new MovingViolation(LocalDate.of(2020, 5, 20), MovingType.SPEEDING);
        assertEquals(mv1.hashCode(), mv2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "MovingViolation{type=SPEEDING, violationDate=2020-05-20}";
        assertEquals(expected, mv1.toString());
    }
}