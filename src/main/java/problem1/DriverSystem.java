package problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * IDriverSystem
 */
public class DriverSystem implements IDriverSystem{
    private final List<Driver> pool = new ArrayList<>();

    public List<Driver> getPool(){
        return this.pool;
    }

    /**
     * Add a driver to the pool of existing accepted drivers
     *
     * @param driver - a Driver object
     * @throws DriverRejectedException - throw exception when the driver is rejected by the validator
     */
    @Override
    public void add(Driver driver) throws DriverRejectedException{
        if(!passRegistrationValidator(driver))
            throw new DriverRejectedException("Driver rejected. Registration Validator fail.");

        if(!passPoolUniqueness(driver))
            throw new DriverRejectedException("Driver rejected. Pool uniqueness fail.");

        this.pool.add(driver);
    }

    /**
     * Check whether the driver pass all validations of the Registration Validator
     * @param driver - the prospective driver
     * @return - true or false
     */
    private boolean passRegistrationValidator(Driver driver) {
        return RegistrationValidatorUtils.validAge(driver) &&
                RegistrationValidatorUtils.validDriverLicence(driver) &&
                RegistrationValidatorUtils.validVehicleYear(driver) &&
                RegistrationValidatorUtils.validVehicleInsurance(driver) &&
                RegistrationValidatorUtils.validDriverHistory(driver) &&
                RegistrationValidatorUtils.validVehicleHistory(driver);
    }

    /**
     * Check Pool uniqueness, the pool of existing accepted drivers should be unique,
     * in that it should not contain multiple instances of the same driver with the same vehicle.
     * @param driver - the prospective driver
     * @return true or false
     */
    private boolean passPoolUniqueness(Driver driver) {
        return this.getPool().stream().noneMatch(x -> (x.getLicence().equals(driver.getLicence()) &&
                (x.getVehicle().equals(driver.getVehicle()))));
    }

    /**
     * Displays on the console the full name of a driver whose last name is the same as the queried name.
     * It then displays the list of all the vehicles registered with that driver.
     * Finally, if the driver has any driving violations, those are displayed too.
     *
     * @param lastName - the last name
     */
    @Override
    public void provideDriverInfo(String lastName){
        Comparator<Driver> sortByFirstName =
                Comparator.comparing((Driver d) -> d.getName().getFirstName())
                        .thenComparing((Driver d) -> d.getLicence().getLicenseNumber());

        List<Driver> filtered = this.pool
                .stream()
                .filter(x -> x.getName().getLastName().equals(lastName))
                .sorted(sortByFirstName)
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No registered driver found\n");
            return;
        }

        int i;

        for (i = 0; i < filtered.size(); i++) {
            System.out.println(filtered.get(i).getName().getFirstName() + ", " +
                    filtered.get(i).getName().getLastName());
            int count = 0;

            int j;
            for (j = i; j < filtered.size(); j++) {
                if (filtered.get(j).getLicence().getLicenseNumber()
                        .equals(filtered.get(i).getLicence().getLicenseNumber())) {
                    Vehicle v2 = filtered.get(j).getVehicle();
                    String vehicleInfor2 = "\t" + v2.getYear() +
                            " " + v2.getMake() + " " + v2.getModel() + ", " +
                            v2.getPlate();
                    System.out.println(vehicleInfor2);
                    count++;
                } else {
                    break;
                }
            }

            if (!filtered.get(i).getHistory().isEmpty()) {
                System.out.println("\t" +"Driving violations:");
                for (DriverViolation violation : filtered.get(i).getHistory()) {
                    System.out.println("\t\t" + violation.getType());
                }
            }

            System.out.println();
            i = i + count - 1;
        }
    }
}
