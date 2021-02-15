package problem1;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a Registration Validator
 */
public class RegistrationValidatorUtils {
    private static final Integer AGE_LIMIT = 21;
    private static final String US = "US";
    private static final String CANADA = "Canada";
    private static final Integer LIMIT_MONTHS = 6;
    private static final Integer VEHICLE_AGE = 15;


    /**
     * Check whether the driver's age is valid for registration.
     * if the prospective driver is underage (younger than 21),
     * they should not be accepted as a driver
     * @param driver - the prospective driver
     * @return - true or false
     */
    public static boolean validAge(Driver driver) {
        LocalDate twentyOne = driver.getBirthDate().plusYears(AGE_LIMIT);
        return (!twentyOne.isAfter(LocalDate.now()));
    }

    /**
     * Check whether the Driver Licence information is valid for registration
     * @param driver - the prospective driver
     * @return - true or false
     */
    public static boolean validDriverLicence(Driver driver) {

        // Name differences: are there any differences between the name provided
        // on the application and the name on the license?
        // If yes, the prospective driver should not be accepted as a driver.
        if (!driver.getName().equals(driver.getLicence().getDriverName()))
            return false;

        // Birth date differences: are there any differences between the birth date
        // provided on the application and the date on the license?
        // If yes, the prospective driver should not be accepted as a driver.
        if (!driver.getBirthDate().equals(driver.getLicence().getBirthDate()))
            return false;

        // Country of issuance: is the license issued in the USorCanada?
        // If not, for now, the prospective driver should not be accepted as a driver.
        if ((!driver.getLicence().getCountryOfIssuance().equals(US)) &&
                (!driver.getLicence().getCountryOfIssuance().equals(CANADA)))
            return false;

        // Date of issuance: was the driver license issued less than six months ago?
        // If yes, then the prospective driver should not be accepted as a driver.
        if (driver.getLicence().getIssuanceDate().plusMonths(LIMIT_MONTHS).isAfter(LocalDate.now()))
            return false;

        // Expiration date: has the driver license expired?
        // If yes,then the prospective driver should not be accepted as a driver.
        return !driver.getLicence().getExpirationDate().isBefore(LocalDate.now());
    }

    /**
     * Check whether the vehicle's production year is valid for registration.
     * Is the vehicle older than 15 years?
     * If yes,then prospective driver should not be accepted as a driver.
     * @param driver - the prospective driver
     * @return - true or false
     */
    public static boolean validVehicleYear(Driver driver) {
        return LocalDate.now().getYear() - driver.getVehicle().getYear() <= VEHICLE_AGE;
    }

    /**
     * Check whether the driver's vehicle insurance information is valid for registration
     * @param driver - the prospective driver
     * @return - true or false
     */
    public static boolean validVehicleInsurance(Driver driver) {

        // Has the insurance expired?
        // If yes,then the prospective driver should not be accepted as a driver.
        if (driver.getVehicle().getInsuranceExpirationDate().isBefore(LocalDate.now()))
            return false;

        // Is the prospective driver the official owner of the vehicle?
        // If not,is the prospective driver listed as an insured driver?
        // If not,then the prospective driver should not be accepted as a driver.
        if (driver.getVehicle().getOfficialOwnerID().equals(driver.getLicence().getLicenseNumber())) {
            return true;
        } else return driver.getVehicle().getCoveredDrivers().contains(driver.getLicence().getLicenseNumber());
    }

    /**
     * Check whether the driver's history is valid for registration
     * Does the prospective driver have any moving violations?
     * If yes, do those include reckless driving,speeding,DUI,or driving
     * without a valid license/insurance?
     * If yes, then prospective driver should not be accepted as a driver.
     * @param driver - the prospective driver
     * @return - true or false
     */
    public static boolean validDriverHistory(Driver driver) {
        return driver.getHistory()
                .stream()
                .noneMatch(x ->(
                x.getType() == MovingType.RECKLESS_DRIVING ||
                x.getType() == MovingType.SPEEDING ||
                x.getType() == MovingType.DRIVING_WITHOUT_A_VALID_LICENSE_AND_OR_INSURANCE ||
                x.getType() == MovingType.DRIVING_UNDER_INFLUENCE));
    }

    /**
     * Check whether the driver's vehicle's history is valid for registration
     * Are there any crashes or moving violations committed with this vehicle in the last six months?
     * If yes, then prospective driver should not be accepted as a driver.
     * @param driver - the prospective driver
     * @return - true or false
     */
    public static boolean validVehicleHistory(Driver driver) {
        for (VehicleViolation violation : driver.getVehicle().getHistory()) {
            if (violation.getType().getClass() == Crash.FENDER_BENDER.getClass() ||
                    violation.getType().getClass() == MovingType.SPEEDING.getClass()) {
                if (violation.getDateOfViolation().plusMonths(LIMIT_MONTHS).isAfter(LocalDate.now()))
                    return false;
            }
        }
        return true;
    }
}
