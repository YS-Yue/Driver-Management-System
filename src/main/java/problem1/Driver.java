package problem1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Represents a Driver object
 */
public class Driver {
    private final Name name;
    private final LocalDate birthDate;
    private final DriverLicence licence;
    private final Vehicle vehicle;
    private final List<DriverViolation> history;

    /**
     * Constructs a new Driver object with given builder
     * @param builder - the DriverBuilder
     */
    private Driver(DriverBuilder builder){
        this.name = builder.name;
        this.birthDate = builder.birthDate;
        this.licence = builder.licence;
        this.vehicle = builder.vehicle;
        this.history = builder.history;
    }

    /**
     * Get the name of driver
     * @return - the name of driver
     */
    public Name getName(){
        return this.name;
    }

    /**
     * Get the birth date of driver
     * @return - the birth date of driver
     */
    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    /**
     * Get the driver licence
     * @return - the driver licence
     */
    public DriverLicence getLicence(){
        return this.licence;
    }

    /**
     * Get the vehicle
     * @return - the vehicle
     */
    public Vehicle getVehicle(){
        return this.vehicle;
    }

    /**
     * Get the list of all driver violations
     * @return -  the list of all driver violations
     */
    public List<DriverViolation> getHistory(){
        return this.history;
    }

    /**
     * Return whether or not the given object is the same as this object.
     *
     * @param o the object to be compared to for equality.
     * @return whether or not the given object is the same as this object.
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return getName().equals(driver.getName()) &&
                getBirthDate().equals(driver.getBirthDate()) &&
                getLicence().equals(driver.getLicence()) &&
                getVehicle().equals(driver.getVehicle()) &&
                getHistory().equals(driver.getHistory());
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode(){
        return Objects.hash(getName(), getBirthDate(), getLicence(), getVehicle(), getHistory());
    }

    /**
     * Return the string representation of the object
     *
     * @return - the string representation of the object
     */
    @Override
    public String toString(){
        return "Driver{" +
                "name=" + name +
                ", birthDate=" + birthDate +
                ", licence=" + licence +
                ", vehicle=" + vehicle +
                ", history=" + history +
                '}';
    }

    /**
     * Represents a DriverBuilder
     */
    public static class DriverBuilder {
        private Name name;
        private LocalDate birthDate;
        private DriverLicence licence;
        private Vehicle vehicle;
        private List<DriverViolation> history;

        /**
         * A private constructor that can only accessed by the static method newInstance()
         */
        private DriverBuilder(){}

        /**
         * Create a new DriverBuilder
         * @return - a new DriverBuilder
         */
        public static DriverBuilder newInstance() {
            return new DriverBuilder();
        }

        /**
         * Set name
         * @param name - driver's name
         * @return - the DriverBuilder
         */
        public DriverBuilder name(Name name) {
            this.name = name;
            return this;
        }

        /**
         * Set birthDate
         * @param birthDate - birthDate
         * @return - the DriverBuilder
         */
        public DriverBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * Set driver licence
         * @param licence - the driver licence
         * @return - the DriverBuilder
         */
        public DriverBuilder licence(DriverLicence licence) {
            this.licence = licence;
            return this;
        }

        /**
         * Set vehicle
         * @param vehicle - the vehicle
         * @return - the DriverBuilder
         */
        public DriverBuilder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        /**
         * Set history
         * @param history - list of all driver violations
         * @return - the DriverBuilder
         */
        public DriverBuilder history(List<DriverViolation> history) {
            this.history = history;
            return this;
        }

        /**
         * Check whether all required fields are set
         * @return true or false
         */
        private boolean allFieldsAreSet(){
            if (this.name == null)
                return false;
            if (this.birthDate == null)
                return false;
            if (this.licence == null)
                return false;
            if (this.vehicle == null)
                return false;
            return this.history != null;
        }

        /**
         * Build a new Driver object
         * @return a new Driver object
         * @throws NotALLFieldsSetException - the exception that not all required fields are set
         */
        public Driver build() throws NotALLFieldsSetException {
            if (!allFieldsAreSet())
                throw new NotALLFieldsSetException();
            return new Driver(this);
        }
    }
}
