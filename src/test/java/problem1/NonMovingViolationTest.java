package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class NonMovingViolationTest {
    private NonMovingViolation nv1;

    @Before
    public void setUp() {
        nv1 = new NonMovingViolation(LocalDate.of(2020, 5, 20), NonMovingType.PAPERWORK_ISSUES);
    }

    @Test
    public void getType(){
        assertEquals(NonMovingType.PAPERWORK_ISSUES, nv1.getType());
    }

    @Test
    public void testEquals(){
        NonMovingViolation nv2 = new NonMovingViolation(LocalDate.of(2020, 5, 20), NonMovingType.PAPERWORK_ISSUES);
        NonMovingViolation nv3 = new NonMovingViolation(LocalDate.of(2020, 6, 20), NonMovingType.PAPERWORK_ISSUES);
        NonMovingViolation nv4 = new NonMovingViolation(LocalDate.of(2020, 5, 20), NonMovingType.PARKING_VIOLATION);

        assertEquals(nv1, nv1);
        assertEquals(nv1, nv2);
        assertNotEquals(nv1, nv3);
        assertNotEquals(nv1, nv4);
        assertNotEquals(nv1, "nv1");
    }

    @Test
    public void testHashCode(){
        NonMovingViolation nv2 = new NonMovingViolation(LocalDate.of(2020, 5, 20), NonMovingType.PAPERWORK_ISSUES);
        assertEquals(nv1.hashCode(), nv2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "NonMovingViolation{type=PAPERWORK_ISSUES, violationDate=2020-05-20}";
        assertEquals(expected, nv1.toString());
    }
}