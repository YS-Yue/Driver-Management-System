package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DriverSystemTest {
    private DriverSystem system;
    private Driver driver1;
    private Driver driver2;
    private Driver driver3;
    private Driver driver4;
    private Driver driver5;

    @Before
    public void setUp() throws Exception{

        system = new DriverSystem();

        DriverLicence licence1 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("9809")
                .name(new Name("Ann", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        Vehicle vehicle1 = Vehicle.VehicleBuilder
                .newInstance()
                .make("BMW")
                .model("Z4")
                .year(2016)
                .officialOwner("9809")
                .coveredDrivers(Arrays.asList("1234", "9809", "1257"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(new ArrayList<>())
                .plate("AMZ001")
                .build();

        Vehicle vehicle2 = Vehicle.VehicleBuilder
                .newInstance()
                .make("Audi")
                .model("Q7")
                .year(2016)
                .officialOwner("9809")
                .coveredDrivers(Arrays.asList("1234", "9809"))
                .insuranceExpirationDate(LocalDate.of(2022, 5, 20))
                .history(new ArrayList<>())
                .plate("ZZ033")
                .build();

        driver1 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence1)
                .vehicle(vehicle1)
                .history(new ArrayList<>())
                .build();

        driver4 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence1)
                .vehicle(vehicle1)
                .history(new ArrayList<>())
                .build();

        driver2 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ann", "Taylor"))
                .birthDate(LocalDate.of(1990, 1,20))
                .licence(licence1)
                .vehicle(vehicle2)
                .history(new ArrayList<>())
                .build();


        List<DriverViolation> history1 = new ArrayList<>();
        history1.add(new NonMovingViolation(LocalDate.of(2019, 7,30), NonMovingType.PARKING_VIOLATION));
        history1.add(new MovingViolation(LocalDate.of(2020, 3, 4), MovingType.DISTRACTED_DRIVING));

        DriverLicence licence2 = DriverLicence.DriverLicenceBuilder
                .newInstance()
                .licenceNumber("1257")
                .name(new Name("Zeka", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 10,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        driver3 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Zeka", "Taylor"))
                .birthDate(LocalDate.of(1990, 10,20))
                .licence(licence2)
                .vehicle(vehicle1)
                .history(history1)
                .build();

        DriverLicence licence3 = DriverLicence.DriverLicenceBuilder
                .newInstance()
                .licenceNumber("4570")
                .name(new Name("Ruby", "Taylor"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 10,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        driver5 = Driver.DriverBuilder
                .newInstance()
                .name(new Name("Ruby", "Taylor"))
                .birthDate(LocalDate.of(1990, 10,20))
                .licence(licence3)
                .vehicle(vehicle1)
                .history(new ArrayList<>())
                .build();

        system.add(driver1);
        system.add(driver3);
        system.add(driver2);

    }

    @Test
    public void getPool(){
        List<Driver> expected = Arrays.asList(driver1, driver3, driver2);
        assertEquals(expected, system.getPool());
    }

    @Test
    public void add(){
        try {
            system.add(driver4);
            fail("An excepiton should have been thrown");
        } catch (DriverRejectedException e) {
            assertEquals("Driver rejected. Pool uniqueness fail.", e.getMessage());
        }

        try {
            system.add(driver5);
            fail("An excepiton should have been thrown");
        } catch (DriverRejectedException e) {
            assertEquals("Driver rejected. Registration Validator fail.", e.getMessage());
        }
    }

    @Test
    public void provideDriverInfo(){
        system.provideDriverInfo("Taylor");
        system.provideDriverInfo("Smith");
    }
}