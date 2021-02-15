package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DriverTest {
    private Driver d1;
    private Vehicle vehicle;
    private DriverLicence licence;
    private List<DriverViolation> history;

    @Before
    public void setUp() throws Exception{
        vehicle = Vehicle.VehicleBuilder
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

        licence = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        MovingViolation mv = new MovingViolation(LocalDate.of(2020, 5, 20), MovingType.SPEEDING);
        NonMovingViolation nv = new NonMovingViolation(LocalDate.of(2020, 5, 20), NonMovingType.PAPERWORK_ISSUES);
        history =Arrays.asList(mv, nv);

        d1 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("AA", "BB"))
                .birthDate(LocalDate.of(1990, 5, 20))
                .licence(licence)
                .vehicle(vehicle)
                .history(history)
                .build();
    }

    @Test
    public void getName(){
        assertEquals(new Name("AA", "BB"), d1.getName());
    }

    @Test
    public void getBirthDate(){
        assertEquals(LocalDate.of(1990, 5, 20), d1.getBirthDate());
    }

    @Test
    public void getLicence(){
        assertEquals(licence, d1.getLicence());
    }

    @Test
    public void getVehicle(){
        assertEquals(vehicle, d1.getVehicle());
    }

    @Test
    public void getHistory(){
        assertEquals(history, d1.getHistory());
    }

    @Test
    public void testEquals() throws NotALLFieldsSetException{
        assertEquals(d1, d1);

        Vehicle vehicle2 = Vehicle.VehicleBuilder
                .newInstance()
                .make("BMW")
                .model("Q5")
                .year(2016)
                .officialOwner("1234")
                .coveredDrivers(Arrays.asList("1234", "5678"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(new ArrayList<>())
                .plate("AMZ001")
                .build();

        DriverLicence licence2 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        MovingViolation mv2 = new MovingViolation(LocalDate.of(2020, 6, 20), MovingType.SPEEDING);
        NonMovingViolation nv2 = new NonMovingViolation(LocalDate.of(2020, 5, 21), NonMovingType.PAPERWORK_ISSUES);
        List<DriverViolation> history2 =Arrays.asList(mv2, nv2);

        Driver d2 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("AA", "BB"))
                .birthDate(LocalDate.of(1990, 5, 20))
                .licence(licence)
                .vehicle(vehicle)
                .history(history)
                .build();

        assertEquals(d1, d2);

        Driver d3 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("FF", "NN"))
                .birthDate(LocalDate.of(1990, 5, 20))
                .licence(licence)
                .vehicle(vehicle)
                .history(history)
                .build();

        assertNotEquals(d1, d3);

        Driver d4 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("AA", "BB"))
                .birthDate(LocalDate.of(1990, 8, 20))
                .licence(licence)
                .vehicle(vehicle)
                .history(history)
                .build();

        assertNotEquals(d1, d4);

        Driver d5 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("AA", "BB"))
                .birthDate(LocalDate.of(1990, 5, 20))
                .licence(licence2)
                .vehicle(vehicle)
                .history(history)
                .build();

        assertNotEquals(d1, d5);

        Driver d6 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("AA", "BB"))
                .birthDate(LocalDate.of(1990, 5, 20))
                .licence(licence)
                .vehicle(vehicle2)
                .history(history)
                .build();

        assertNotEquals(d1, d6);

        Driver d7 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("AA", "BB"))
                .birthDate(LocalDate.of(1990, 5, 20))
                .licence(licence)
                .vehicle(vehicle)
                .history(history2)
                .build();

        assertNotEquals(d1, d7);

        assertNotEquals(d1, "d1");
    }

    @Test
    public void testHashCode() throws NotALLFieldsSetException{
        Driver d2 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("AA", "BB"))
                .birthDate(LocalDate.of(1990, 5, 20))
                .licence(licence)
                .vehicle(vehicle)
                .history(history)
                .build();

        assertEquals(d1.hashCode(), d2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "Driver{name=Name{firstName='AA', lastName='BB'}, " +
                "birthDate=1990-05-20, " +
                "licence=DriverLicence{licenseNumber='1234', " +
                "driverName=Name{firstName='Ann', lastName='Taylor'}, " +
                "address='address1', birthDate=1990-01-20, " +
                "countryOfIssuance='US', stateOfIssuance='WA', " +
                "issuanceDate=2018-07-30, expirationDate=2024-07-30}, " +
                "vehicle=Vehicle{make='Audi', model='Q5', year=2016, " +
                "officialOwnerID='1234', coveredDrivers=[1234, 5678], " +
                "insuranceExpirationDate=2022-05-20, history=[]}, " +
                "history=[MovingViolation{type=SPEEDING, violationDate=2020-05-20}, " +
                "NonMovingViolation{type=PAPERWORK_ISSUES, violationDate=2020-05-20}]}";

        assertEquals(expected, d1.toString());
    }

    @Test
    public void constructorException(){
        try {
            Driver d2 = Driver.DriverBuilder
                    .newInstance()
                    .birthDate(LocalDate.of(1990, 5, 20))
                    .licence(licence)
                    .vehicle(vehicle)
                    .history(history)
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Driver d2 = Driver.DriverBuilder
                    .newInstance()
                    .name(new Name("AA", "BB"))
                    .licence(licence)
                    .vehicle(vehicle)
                    .history(history)
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Driver d2 = Driver.DriverBuilder
                    .newInstance()
                    .name(new Name("AA", "BB"))
                    .birthDate(LocalDate.of(1990, 5, 20))
                    .vehicle(vehicle)
                    .history(history)
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Driver d2 = Driver.DriverBuilder
                    .newInstance()
                    .name(new Name("AA", "BB"))
                    .birthDate(LocalDate.of(1990, 5, 20))
                    .licence(licence)
                    .history(history)
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            Driver d2 = Driver.DriverBuilder
                    .newInstance()
                    .name(new Name("AA", "BB"))
                    .birthDate(LocalDate.of(1990, 5, 20))
                    .licence(licence)
                    .vehicle(vehicle)
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }
    }
}