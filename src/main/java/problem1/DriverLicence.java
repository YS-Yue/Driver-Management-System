package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a driver’s driver license,
 * including information about the license unique number,
 * a driver’s name, a driver’s address, a driver’s birth date,
 * country and state of issuance, and issuance and expiration date.
 */
public class DriverLicence {
    private final String licenseNumber;
    private final Name driverName;
    private final String address;
    private final LocalDate birthDate;
    private final String countryOfIssuance;
    private final String stateOfIssuance;
    private final LocalDate issuanceDate;
    private final LocalDate expirationDate;

    /**
     * Constructs a new DriverLicence object based on the provided DriverLicenceBuilder.
     * @param builder - a DriverLicenceBuilder
     */
    private DriverLicence(DriverLicenceBuilder builder) {
        this.licenseNumber = builder.licenseNumber;
        this.driverName = builder.driverName;
        this.address = builder.address;
        this.birthDate = builder.birthDate;
        this.countryOfIssuance = builder.countryOfIssuance;
        this.stateOfIssuance = builder.stateOfIssuance;
        this.issuanceDate = builder.issuanceDate;
        this.expirationDate = builder.expirationDate;
    }

    /**
     * Get the license unique number
     * @return - the license unique number
     */
    public String getLicenseNumber(){
        return this.licenseNumber;
    }

    /**
     * Get the driver's name
     * @return - the driver's name
     */
    public Name getDriverName(){
        return this.driverName;
    }

    /**
     * Get the driver's address
     * @return - the driver's address
     */
    public String getAddress(){
        return this.address;
    }

    /**
     * Get the driver's birth date
     * @return - the driver's birth date
     */
    public LocalDate getBirthDate(){
        return this.birthDate;
    }

    /**
     * Get the licence's country of issuance
     * @return the licence's country of issuance
     */
    public String getCountryOfIssuance(){
        return this.countryOfIssuance;
    }

    /**
     * Get the licence's state of issuance
     * @return - the licence's state of issuance
     */
    public String getStateOfIssuance(){
        return this.stateOfIssuance;
    }

    /**
     * Get the issuance date of the licence
     * @return - the issuance date of the licence
     */
    public LocalDate getIssuanceDate(){
        return this.issuanceDate;
    }

    /**
     * Get the expiration date of the licence
     * @return - the expiration date of the licence
     */
    public LocalDate getExpirationDate(){
        return this.expirationDate;
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
        if (!(o instanceof DriverLicence)) return false;
        DriverLicence licence = (DriverLicence) o;
        return Objects.equals(getLicenseNumber(), licence.getLicenseNumber()) &&
                Objects.equals(getDriverName(), licence.getDriverName()) &&
                Objects.equals(getAddress(), licence.getAddress()) &&
                Objects.equals(getBirthDate(), licence.getBirthDate()) &&
                Objects.equals(getCountryOfIssuance(), licence.getCountryOfIssuance()) &&
                Objects.equals(getStateOfIssuance(), licence.getStateOfIssuance()) &&
                Objects.equals(getIssuanceDate(), licence.getIssuanceDate()) &&
                Objects.equals(getExpirationDate(), licence.getExpirationDate());
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode(){
        return Objects.hash(getLicenseNumber(), getDriverName(), getAddress(), getBirthDate(), getCountryOfIssuance(), getStateOfIssuance(), getIssuanceDate(), getExpirationDate());
    }

    /**
     * Return the string representation of the object
     *
     * @return - the string representation of the object
     */
    @Override
    public String toString(){
        return "DriverLicence{" +
                "licenseNumber='" + licenseNumber + '\'' +
                ", driverName=" + driverName +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", countryOfIssuance='" + countryOfIssuance + '\'' +
                ", stateOfIssuance='" + stateOfIssuance + '\'' +
                ", issuanceDate=" + issuanceDate +
                ", expirationDate=" + expirationDate +
                '}';
    }

    /**
     * Represents a Builder of the Driver Licence
     */
    public static class DriverLicenceBuilder {
        private String licenseNumber;
        private Name driverName;
        private String address;
        private LocalDate birthDate;
        private String countryOfIssuance;
        private String stateOfIssuance;
        private LocalDate issuanceDate;
        private LocalDate expirationDate;

        /**
         * A private constructor that can only accessed by the static method newInstance()
         */
        private DriverLicenceBuilder(){}

        /**
         * Create a new DriverLicenceBuilder
         * @return - a new DriverLicenceBuilder
         */
        public static DriverLicenceBuilder newInstance(){
            return new DriverLicenceBuilder();
        }

        /**
         * Set the licenseNumber of the DriverLicenceBuilder
         * @param licenseNumber - the licenseNumber
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder licenceNumber(String licenseNumber){
            this.licenseNumber = licenseNumber;
            return this;
        }

        /**
         * Set the driverName of the DriverLicenceBuilder
         * @param name - the driver's name
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder name(Name name) {
            this.driverName = name;
            return this;
        }

        /**
         * Set the address of the DriverLicenceBuilder
         * @param address - the driver's address
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder address(String address) {
            this.address = address;
            return this;
        }

        /**
         * Set the birthDate of the DriverLicenceBuilder
         * @param birthDate - the driver's birth date
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        /**
         * Set the countryOfIssuance of the DriverLicenceBuilder
         * @param countryOfIssuance - the licence's countryOfIssuance
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder countryOfIssuance(String countryOfIssuance) {
            this.countryOfIssuance = countryOfIssuance;
            return this;
        }

        /**
         * Set the stateOfIssuance of the DriverLicenceBuilder
         * @param stateOfIssuance - the licence's stateOfIssuance
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder stateOfIssuance(String stateOfIssuance) {
            this.stateOfIssuance = stateOfIssuance;
            return this;
        }

        /**
         * Set the issuanceDate of the DriverLicenceBuilder
         * @param issuanceDate - the licence's issuanceDate
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder issuanceDate(LocalDate issuanceDate) {
            this.issuanceDate = issuanceDate;
            return this;
        }

        /**
         * Set the expirationDate of the DriverLicenceBuilder
         * @param expirationDate - the licence's expirationDate
         * @return - the DriverLicenceBuilder
         */
        public DriverLicenceBuilder expirationDate(LocalDate expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        /**
         * Build a new DriverLicence object
         * @return a new DriverLicence object
         * @throws NotALLFieldsSetException - the exception that not all required fields are set
         */
        public DriverLicence build() throws NotALLFieldsSetException {
            if (!allFieldsAreSet())
                throw new NotALLFieldsSetException();
            return new DriverLicence(this);
        }

        /**
         * Check whether all required fields are set
         * @return true or false
         */
        private boolean allFieldsAreSet() {
            if (this.licenseNumber == null)
                return false;
            if (this.driverName == null)
                return false;
            if (this.address == null)
                return false;
            if (this.birthDate == null)
                return false;
            if (this.countryOfIssuance == null)
                return false;
            if (this.stateOfIssuance == null)
                return false;
            if (this.issuanceDate == null)
                return false;
            return this.expirationDate != null;
        }
    }
}
