package problem1;

/**
 * The interface of the DriverSystem
 */
public interface IDriverSystem {

    /**
     * Add a driver to the pool of existing accepted drivers
     * @param driver - a Driver object
     * @throws DriverRejectedException - throw exception when the driver is rejected by the validator
     */
    void add(Driver driver) throws DriverRejectedException;

    /**
     * Displays on the console the full name of a driver whose last name is the same as the queried name.
     * It then displays the list of all the vehicles registered with that driver.
     * Finally, if the driver has any driving violations, those are displayed too.
     * @param lastName - the last name
     */
    void provideDriverInfo(String lastName);
}
