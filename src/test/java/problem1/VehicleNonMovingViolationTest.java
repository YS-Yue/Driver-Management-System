package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class VehicleNonMovingViolationTest {

    private VehicleNonMovingViolation vnv1;

    @Before
    public void setUp() {
        vnv1 = new VehicleNonMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), NonMovingType.PARKING_VIOLATION);
    }

    @Test
    public void getType(){
        assertEquals(NonMovingType.PARKING_VIOLATION, vnv1.getType());
    }

    @Test
    public void testEquals(){
        VehicleNonMovingViolation vnv2 = new VehicleNonMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), NonMovingType.PARKING_VIOLATION);

        VehicleNonMovingViolation vnv3 = new VehicleNonMovingViolation(new Name("FF", "DD"),
                LocalDate.of(2020, 5, 20), NonMovingType.PARKING_VIOLATION);

        VehicleNonMovingViolation vnv4 = new VehicleNonMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 6, 20), NonMovingType.PARKING_VIOLATION);

        VehicleNonMovingViolation vnv5 = new VehicleNonMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), NonMovingType.PROBLEMS_WITH_THE_VEHICLE);

        assertEquals(vnv1, vnv1);
        assertEquals(vnv1, vnv2);
        assertNotEquals(vnv1, vnv3);
        assertNotEquals(vnv1, vnv4);
        assertNotEquals(vnv1, vnv5);
        assertNotEquals(vnv1, "vnv1");
    }

    @Test
    public void testHashCode(){
        VehicleNonMovingViolation vnv2 = new VehicleNonMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), NonMovingType.PARKING_VIOLATION);

        assertEquals(vnv1.hashCode(), vnv2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "VehicleNonMovingViolation{type=PARKING_VIOLATION, " +
                "offendingDriverName=Name{firstName='AA', lastName='BB'}, " +
                "dateOfViolation=2020-05-20}";

        assertEquals(expected, vnv1.toString());
    }
}