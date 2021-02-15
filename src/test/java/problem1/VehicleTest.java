package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleTest {
    private Vehicle v1;
    private List<VehicleViolation> history;

    @Before
    public void setUp() throws Exception{
        VehicleCrash vc1 = new VehicleCrash(new Name("AA", "BB"), LocalDate.of(2020, 5, 20),
                Crash.CRASH_WITHOUT_BODILY_INJURIES);
        VehicleMovingViolation vmv1 = new VehicleMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), MovingType.SPEEDING);
        VehicleNonMovingViolation vnv1 = new VehicleNonMovingViolation(new Name("AA", "BB"),
                LocalDate.of(2020, 5, 20), NonMovingType.PARKING_VIOLATION);
        history = Arrays.asList(vmv1, vnv1,vc1);

        v1 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();
    }

    @Test
    public void getMake(){
        assertEquals("Audi", v1.getMake());
    }

    @Test
    public void getModel(){
        assertEquals("Q5", v1.getModel());
    }

    @Test
    public void getYear(){
        assertEquals((Integer)2016, v1.getYear());
    }

    @Test
    public void getOfficialOwnerID(){
        assertEquals("1234", v1.getOfficialOwnerID());
    }

    @Test
    public void getCoveredDrivers(){
        assertEquals(Arrays.asList("1234", "5678"), v1.getCoveredDrivers());
    }

    @Test
    public void getInsuranceExpirationDate(){
        assertEquals(LocalDate.of(2022, 5, 20), v1.getInsuranceExpirationDate());
    }

    @Test
    public void getHistory(){
        assertEquals(history, v1.getHistory());
    }

    @Test
    public void getPlate(){
        assertEquals("AMZ001", v1.getPlate());
    }

    @Test
    public void testEquals() throws NotALLFieldsSetException{
        assertEquals(v1, v1);

        Vehicle v2 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();

        assertEquals(v1, v2);

        Vehicle v3 = Vehicle.VehicleBuilder
                .newInstance()
                .make("BMW")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();

        assertNotEquals(v1, v3);

        Vehicle v4 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q3")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();

        assertNotEquals(v1, v4);

        Vehicle v5 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2017)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();

        assertNotEquals(v1, v5);

        Vehicle v6 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("6578")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();

        assertNotEquals(v1, v6);

        Vehicle v7 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "9087"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();

        assertNotEquals(v1, v7);

        Vehicle v8 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 7, 20))
                .history(history)
                .plate("AMZ001")
                .build();

        assertNotEquals(v1, v8);

        Vehicle v9 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(new ArrayList<>())
                .plate("AMZ001")
                .build();

        assertNotEquals(v1, v9);

        Vehicle v10 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ900")
                .build();

        assertNotEquals(v1, v10);

        assertNotEquals(v1, "v1");
    }

    @Test
    public void testHashCode() throws NotALLFieldsSetException{
        Vehicle v2 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(history)
                .plate("AMZ001")
                .build();
        assertEquals(v1.hashCode(), v2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "Vehicle{make='Audi', model='Q5', year=2016, " +
                "officialOwnerID='1234', coveredDrivers=[1234, 5678], " +
                "insuranceExpirationDate=2022-05-20, " +
                "history=[VehicleMovingViolation{movingType=SPEEDING, " +
                "offendingDriverName=Name{firstName='AA', lastName='BB'}, " +
                "dateOfViolation=2020-05-20}, " +
                "VehicleNonMovingViolation{type=PARKING_VIOLATION, " +
                "offendingDriverName=Name{firstName='AA', lastName='BB'}, " +
                "dateOfViolation=2020-05-20}, " +
                "VehicleCrash{crashType=CRASH_WITHOUT_BODILY_INJURIES, " +
                "offendingDriverName=Name{firstName='AA', lastName='BB'}, " +
                "dateOfViolation=2020-05-20}]}";

        assertEquals(expected, v1.toString());
    }

    @Test
    public void constructorException(){
        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .model("Q5")
                    .year(2016)
                    .officialOwner("1234")
                    .coveredDrivers(Arrays.asList("1234", "5678"))
                    .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                    .history(history)
                    .plate("AMZ001")
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .make("Audi")
                    .year(2016)
                    .officialOwner("1234")
                    .coveredDrivers(Arrays.asList("1234", "5678"))
                    .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                    .history(history)
                    .plate("AMZ001")
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .make("Audi")
                    .model("Q5")
                    .officialOwner("1234")
                    .coveredDrivers(Arrays.asList("1234", "5678"))
                    .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                    .history(history)
                    .plate("AMZ001")
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .make("Audi")
                    .model("Q5")
                    .year(2016)
                    .coveredDrivers(Arrays.asList("1234", "5678"))
                    .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                    .history(history)
                    .plate("AMZ001")
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .make("Audi")
                    .model("Q5")
                    .year(2016)
                    .officialOwner("1234")
                    .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                    .history(history)
                    .plate("AMZ001")
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .make("Audi")
                    .model("Q5")
                    .year(2016)
                    .officialOwner("1234")
                    .coveredDrivers(Arrays.asList("1234", "5678"))
                    .history(history)
                    .plate("AMZ001")
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .make("Audi")
                    .model("Q5")
                    .year(2016)
                    .officialOwner("1234")
                    .coveredDrivers(Arrays.asList("1234", "5678"))
                    .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                    .plate("AMZ001")
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Vehicle v2 = Vehicle.VehicleBuilder
                    .newInstance()
                    .make("Audi")
                    .model("Q5")
                    .year(2016)
                    .officialOwner("1234")
                    .coveredDrivers(Arrays.asList("1234", "5678"))
                    .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                    .history(history)
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }
    }
}