package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RegistrationValidatorUtilsTest {
    private Driver driver1;
    private DriverLicence licence;
    private Vehicle vehicle;
    private Driver driver2;

    @Before
    public void setUp() throws Exception{

        licence = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        vehicle = Vehicle.VehicleBuilder
                .newInstance()
                .make("BMW")
                .model("Q5")
                .year(2016)
                .officialOwner("9809")
                .coveredDrivers(Arrays.asList("1234", "9809"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(new ArrayList<>())
                .plate("AMZ001")
                .build();

        driver1 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence)
                .vehicle(vehicle)
                .history(new ArrayList<>())
                .build();

        VehicleCrash vc = new VehicleCrash(new Name("Ann", "Taylor"),
                LocalDate.of(2020, 6, 20), Crash.CRASH_WITHOUT_BODILY_INJURIES);

        VehicleCrash vc2 = new VehicleCrash(new Name("Ann", "Taylor"),
                LocalDate.of(2019, 6, 20), Crash.CRASH_WITHOUT_BODILY_INJURIES);

        List<VehicleViolation> vehicleHistory = Arrays.asList(vc, vc2);

        Vehicle vehicle2 = Vehicle.VehicleBuilder
                .newInstance()
                .make("BMW")
                .model("Q5")
                .year(2001)
                .officialOwner("9809")
                .coveredDrivers(Arrays.asList("1234", "9809"))
                .insuranceExpirationDate(LocalDate.of(2019, 5, 20))
                .history(vehicleHistory)
                .plate("AMZ001")
                .build();

        DriverLicence licence2 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Bee", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(2019, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        MovingViolation mv = new MovingViolation(LocalDate.of(2020, 5, 20), MovingType.RECKLESS_DRIVING);
        NonMovingViolation nv = new NonMovingViolation(LocalDate.of(2020, 5, 20), NonMovingType.PAPERWORK_ISSUES);
        List<DriverViolation> driverHistory =Arrays.asList(mv, nv);

        driver2 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(2010, 1,20))
                .licence(licence2)
                .vehicle(vehicle2)
                .history(driverHistory)
                .build();
    }

    @Test
    public void validAge() {
        assertTrue(RegistrationValidatorUtils.validAge(driver1));
        assertFalse(RegistrationValidatorUtils.validAge(driver2));

    }

    @Test
    public void validDriverLicence() throws NotALLFieldsSetException{
        assertTrue(RegistrationValidatorUtils.validDriverLicence(driver1));
        assertFalse(RegistrationValidatorUtils.validDriverLicence(driver2));

        DriverLicence licence3 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(2001, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();


        Driver driver3 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(2010, 1,20))
                .licence(licence3)
                .vehicle(vehicle)
                .history(new ArrayList<>())
                .build();

        assertFalse(RegistrationValidatorUtils.validDriverLicence(driver3));

        DriverLicence licence4 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(2001, 1,20))
                .countryOfIssuance("JAN")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();


        Driver driver4 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(2001, 1,20))
                .licence(licence4)
                .vehicle(vehicle)
                .history(new ArrayList<>())
                .build();

        assertFalse(RegistrationValidatorUtils.validDriverLicence(driver4));

        DriverLicence licence5 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("Canada")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();


        Driver driver5 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence5)
                .vehicle(vehicle)
                .history(new ArrayList<>())
                .build();

        assertTrue(RegistrationValidatorUtils.validDriverLicence(driver5));

        DriverLicence licence6 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("Canada")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2020, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();


        Driver driver6 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence6)
                .vehicle(vehicle)
                .history(new ArrayList<>())
                .build();

        assertFalse(RegistrationValidatorUtils.validDriverLicence(driver6));

        DriverLicence licence7 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("Canada")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2020, 7, 30))
                .build();


        Driver driver7 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence7)
                .vehicle(vehicle)
                .history(new ArrayList<>())
                .build();

        assertFalse(RegistrationValidatorUtils.validDriverLicence(driver7));
    }

    @Test
    public void validVehicleYear(){
        assertTrue(RegistrationValidatorUtils.validVehicleYear(driver1));
        assertFalse(RegistrationValidatorUtils.validVehicleYear(driver2));
    }

    @Test
    public void validVehicleInsurance() throws NotALLFieldsSetException{
        assertTrue(RegistrationValidatorUtils.validVehicleInsurance(driver1));
        assertFalse(RegistrationValidatorUtils.validVehicleInsurance(driver2));

        DriverLicence licence5 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("Canada")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();


        Driver driver5 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence5)
                .vehicle(vehicle)
                .history(new ArrayList<>())
                .build();

        assertTrue(RegistrationValidatorUtils.validVehicleInsurance(driver5));
    }

    @Test
    public void validDriverHistory() throws NotALLFieldsSetException{
        assertTrue(RegistrationValidatorUtils.validDriverHistory(driver1));
        assertFalse(RegistrationValidatorUtils.validDriverHistory(driver2));

        MovingViolation mv1 = new MovingViolation(LocalDate.of(2020, 5, 20), MovingType.SPEEDING);
        MovingViolation mv2 = new MovingViolation(LocalDate.of(2020, 5, 20),
                MovingType.DRIVING_WITHOUT_A_VALID_LICENSE_AND_OR_INSURANCE);
        List<DriverViolation> driverHistory2 =Arrays.asList(mv2, mv1);
        Driver driver3 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence)
                .vehicle(vehicle)
                .history(driverHistory2)
                .build();

        assertFalse(RegistrationValidatorUtils.validDriverHistory(driver3));

    }

    @Test
    public void validVehicleHistory() throws NotALLFieldsSetException{
        assertTrue(RegistrationValidatorUtils.validVehicleHistory(driver1));
        assertFalse(RegistrationValidatorUtils.validVehicleHistory(driver2));

        VehicleMovingViolation mv2 = new VehicleMovingViolation(new Name("Ann", "Taylor"),
                LocalDate.of(2020, 6, 20), MovingType.DRIVING_UNDER_INFLUENCE);

        VehicleMovingViolation mv1 = new VehicleMovingViolation(new Name("Ann", "Taylor"),
                LocalDate.of(2018, 6, 20), MovingType.DRIVING_UNDER_INFLUENCE);

        List<VehicleViolation> vehicleHistory = Arrays.asList(mv2);
        List<VehicleViolation> vehicleHistory3 = Arrays.asList(mv1);

        Vehicle vehicle3 = Vehicle.VehicleBuilder
                .newInstance()
                .make("BMW")
                .model("Q5")
                .year(2016)
                .officialOwner("9809")
                .coveredDrivers(Arrays.asList("1234", "9809"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(vehicleHistory)
                .plate("AMZ001")
                .build();

        Driver driver3 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence)
                .vehicle(vehicle3)
                .history(new ArrayList<>())
                .build();

        assertFalse(RegistrationValidatorUtils.validVehicleHistory(driver3));

        Vehicle vehicle4 = Vehicle.VehicleBuilder
                .newInstance()
                .make("BMW")
                .model("Q5")
                .year(2016)
                .officialOwner("9809")
                .coveredDrivers(Arrays.asList("1234", "9809"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(vehicleHistory3)
                .plate("AMZ001")
                .build();

        Driver driver4 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence)
                .vehicle(vehicle4)
                .history(new ArrayList<>())
                .build();

        assertTrue(RegistrationValidatorUtils.validDriverHistory(driver4));
    }
}