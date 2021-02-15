package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class VehicleCrashTest {
    private VehicleCrash vc1;

    @Before
    public void setUp() {
        vc1 = new VehicleCrash(new Name("AA", "BB"), LocalDate.of(2020, 5, 20), Crash.FENDER_BENDER);
    }

    @Test
    public void getOffendingDriverName(){
        assertEquals(new Name("AA", "BB"), vc1.getOffendingDriverName());
    }

    @Test
    public void getDateOfViolation(){
        assertEquals(LocalDate.of(2020, 5, 20), vc1.getDateOfViolation());
    }

    @Test
    public void getCrashType(){
        assertEquals(Crash.FENDER_BENDER, vc1.getType());
    }

    @Test
    public void testEquals(){
        VehicleCrash vc2 = new VehicleCrash(new Name("AA", "BB"), LocalDate.of(2020, 5, 20), Crash.FENDER_BENDER);
        VehicleCrash vc3 = new VehicleCrash(new Name("FF", "DD"), LocalDate.of(2020, 5, 20), Crash.FENDER_BENDER);
        VehicleCrash vc4 = new VehicleCrash(new Name("AA", "BB"), LocalDate.of(2020, 6, 20), Crash.FENDER_BENDER);
        VehicleCrash vc5 = new VehicleCrash(new Name("AA", "BB"), LocalDate.of(2020, 5, 20),
                Crash.CRASH_WITHOUT_BODILY_INJURIES);

        assertEquals(vc1, vc1);
        assertEquals(vc1, vc2);
        assertNotEquals(vc1, vc3);
        assertNotEquals(vc1, vc4);
        assertNotEquals(vc1, vc5);
        assertNotEquals(vc1, "vc1");
    }

    @Test
    public void testHashCode(){
        VehicleCrash vc2 = new VehicleCrash(new Name("AA", "BB"), LocalDate.of(2020, 5, 20), Crash.FENDER_BENDER);
        assertEquals(vc1.hashCode(), vc2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "VehicleCrash{crashType=FENDER_BENDER, " +
                "offendingDriverName=Name{firstName='AA', lastName='BB'}, " +
                "dateOfViolation=2020-05-20}";
        assertEquals(expected, vc1.toString());
    }
}