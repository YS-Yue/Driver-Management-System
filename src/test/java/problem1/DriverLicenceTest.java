package problem1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DriverLicenceTest {
    private DriverLicence dl1;

    @Before
    public void setUp() throws Exception{
        Name name1 = new Name("Ann", "Taylor");
        dl1 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name1)
        .address("address1")
        .birthDate(LocalDate.of(1990, 1,20))
        .countryOfIssuance("US")
        .stateOfIssuance("WA")
        .issuanceDate(LocalDate.of(2018, 7, 30))
        .expirationDate(LocalDate.of(2024, 7, 30))
        .build();
    }

    @Test
    public void getLicenseNumber(){
        assertEquals("1234", dl1.getLicenseNumber());
    }

    @Test
    public void getDriverName(){
        Name expected = new Name("Ann", "Taylor");
        assertEquals(expected, dl1.getDriverName());
    }

    @Test
    public void getAddress(){
        assertEquals("address1", dl1.getAddress());
    }

    @Test
    public void getBirthDate(){
        assertEquals(LocalDate.of(1990, 1,20), dl1.getBirthDate());
    }

    @Test
    public void getCountryOfIssuance(){
        assertEquals("US", dl1.getCountryOfIssuance());
    }

    @Test
    public void getStateOfIssuance(){
        assertEquals("WA", dl1.getStateOfIssuance());
    }

    @Test
    public void getIssuanceDate(){
        assertEquals(LocalDate.of(2018, 7, 30), dl1.getIssuanceDate());
    }

    @Test
    public void getExpirationDate(){
        assertEquals(LocalDate.of(2024, 7, 30), dl1.getExpirationDate());
    }

    @Test
    public void testEquals() throws NotALLFieldsSetException{
        assertEquals(dl1, dl1);

        Name name2 = new Name("Ann", "Taylor");
        DriverLicence dl2 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertEquals(dl1, dl2);

        DriverLicence dl3 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("5678")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertNotEquals(dl1, dl3);

        DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(new Name("AA", "BB"))
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertNotEquals(dl1, dl4);

        DriverLicence dl5 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address2")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertNotEquals(dl1, dl5);

        DriverLicence dl6 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1980, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertNotEquals(dl1, dl6);

        DriverLicence dl7 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("JAP")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertNotEquals(dl1, dl7);

        DriverLicence dl8 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("CA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertNotEquals(dl1, dl8);

        DriverLicence dl9 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2017, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertNotEquals(dl1, dl9);

        DriverLicence dl10 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2022, 7, 30))
                .build();

        assertNotEquals(dl1, dl10);

        assertNotEquals(dl1, "dl1");
    }

    @Test
    public void testHashCode() throws NotALLFieldsSetException{
        Name name2 = new Name("Ann", "Taylor");
        DriverLicence dl2 = DriverLicence.DriverLicenceBuilder.newInstance()
                .licenceNumber("1234")
                .name(name2)
                .address("address1")
                .birthDate(LocalDate.of(1990, 1,20))
                .countryOfIssuance("US")
                .stateOfIssuance("WA")
                .issuanceDate(LocalDate.of(2018, 7, 30))
                .expirationDate(LocalDate.of(2024, 7, 30))
                .build();

        assertEquals(dl1.hashCode(), dl2.hashCode());
    }

    @Test
    public void testToString(){
        String expected = "DriverLicence{licenseNumber='1234', " +
                "driverName=Name{firstName='Ann', " +
                "lastName='Taylor'}, address='address1', " +
                "birthDate=1990-01-20, countryOfIssuance='US', " +
                "stateOfIssuance='WA', issuanceDate=2018-07-30, " +
                "expirationDate=2024-07-30}";

        assertEquals(expected, dl1.toString());
    }

    @Test
    public void constructorException() {
        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .name(new Name("AA", "BB"))
                    .address("address1")
                    .birthDate(LocalDate.of(1990, 1,20))
                    .countryOfIssuance("US")
                    .stateOfIssuance("WA")
                    .issuanceDate(LocalDate.of(2018, 7, 30))
                    .expirationDate(LocalDate.of(2024, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .licenceNumber("1234")
                    .address("address1")
                    .birthDate(LocalDate.of(1990, 1,20))
                    .countryOfIssuance("US")
                    .stateOfIssuance("WA")
                    .issuanceDate(LocalDate.of(2018, 7, 30))
                    .expirationDate(LocalDate.of(2024, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .licenceNumber("1234")
                    .name(new Name("AA", "BB"))
                    .birthDate(LocalDate.of(1990, 1,20))
                    .countryOfIssuance("US")
                    .stateOfIssuance("WA")
                    .issuanceDate(LocalDate.of(2018, 7, 30))
                    .expirationDate(LocalDate.of(2024, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .licenceNumber("1234")
                    .name(new Name("AA", "BB"))
                    .address("address1")
                    .countryOfIssuance("US")
                    .stateOfIssuance("WA")
                    .issuanceDate(LocalDate.of(2018, 7, 30))
                    .expirationDate(LocalDate.of(2024, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .licenceNumber("1234")
                    .name(new Name("AA", "BB"))
                    .address("address1")
                    .birthDate(LocalDate.of(1990, 1,20))
                    .stateOfIssuance("WA")
                    .issuanceDate(LocalDate.of(2018, 7, 30))
                    .expirationDate(LocalDate.of(2024, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .licenceNumber("1234")
                    .name(new Name("AA", "BB"))
                    .address("address1")
                    .birthDate(LocalDate.of(1990, 1,20))
                    .countryOfIssuance("US")
                    .issuanceDate(LocalDate.of(2018, 7, 30))
                    .expirationDate(LocalDate.of(2024, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .licenceNumber("1234")
                    .name(new Name("AA", "BB"))
                    .address("address1")
                    .birthDate(LocalDate.of(1990, 1,20))
                    .countryOfIssuance("US")
                    .stateOfIssuance("WA")
                    .expirationDate(LocalDate.of(2024, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }

        try {
            DriverLicence dl4 = DriverLicence.DriverLicenceBuilder.newInstance()
                    .licenceNumber("1234")
                    .name(new Name("AA", "BB"))
                    .address("address1")
                    .birthDate(LocalDate.of(1990, 1,20))
                    .countryOfIssuance("US")
                    .stateOfIssuance("WA")
                    .issuanceDate(LocalDate.of(2018, 7, 30))
                    .build();

            fail("An exception should have been thrown");
        } catch (NotALLFieldsSetException e) {
            assertEquals("Not all required fields are set", e.getMessage());
        }
    }
}