package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class VehicleMovingViolationTest {
    private VehicleMovingViolation vmv1;

    @Before
    public void setUp() {
        vmv1 = new VehicleMovingViolation(new Name("AA", "BB"), LocalDate.of(2020, 5, 20), MovingType.SPEEDING);
    }

    @Test
    public void getMovingType(){
        assertEquals(MovingType.SPEEDING, vmv1.getType());
    }

    @Test
    public void testEquals(){
        VehicleMovingViolation vmv2 = new VehicleMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), MovingType.SPEEDING);

        VehicleMovingViolation vmv3 = new VehicleMovingViolation(new Name("FF", "DD"),
                LocalDate.of(2020, 5, 20), MovingType.SPEEDING);

        VehicleMovingViolation vmv4 = new VehicleMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 6, 20), MovingType.SPEEDING);

        VehicleMovingViolation vmv5 = new VehicleMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), MovingType.RECKLESS_DRIVING);

        assertEquals(vmv1, vmv1);
        assertEquals(vmv1, vmv2);
        assertNotEquals(vmv1, vmv3);
        assertNotEquals(vmv1, vmv4);
        assertNotEquals(vmv1, vmv5);
        assertNotEquals(vmv1, "vmv1");
    }

    @Test
    public void testHashCode(){
        VehicleMovingViolation vmv2 = new VehicleMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), MovingType.SPEEDING);

        assertEquals(vmv1.hashCode(), vmv2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "VehicleMovingViolation{movingType=SPEEDING, " +
                "offendingDriverName=Name{firstName='AA', lastName='BB'}, " +
                "dateOfViolation=2020-05-20}";
        assertEquals(expected, vmv1.toString());
    }
}