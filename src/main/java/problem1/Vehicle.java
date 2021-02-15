package problem1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Represent a Vehicle object
 */
public class Vehicle {
    private final String make;
    private final String model;
    private final Integer year;
    private final String officialOwnerID;
    private final List<String> coveredDrivers;
    private final LocalDate insuranceExpirationDate;
    private final List<VehicleViolation> history;
    private final String plate;

    /**
     * Constructs a new Vehicle object with given builder
     * @param builder - the VehicleBuilder
     */
    private Vehicle(VehicleBuilder builder) {
        this.make = builder.make;
        this.model = builder.model;
        this.year = builder.year;
        this.officialOwnerID= builder.officialOwnerID;
        this.coveredDrivers = builder.coveredDrivers;
        this.insuranceExpirationDate = builder.insuranceExpirationDate;
        this.history = builder.history;
        this.plate = builder.plate;
    }

    /**
     * Get the make of the vehicle
     * @return - the make of the vehicle
     */
    public String getMake(){
        return this.make;
    }

    /**
     * Get the model of the vehicle
     * @return - the model of the vehicle
     */
    public String getModel(){
        return this.model;
    }

    /**
     * Get the year of production of the vehicle
     * @return - the year of production of the vehicle
     */
    public Integer getYear(){
        return this.year;
    }

    /**
     * Get the official own's driver licence number that can represent the owner since the number is unique.
     * @return - the official own's driver licence number
     */
    public String getOfficialOwnerID(){
        return this.officialOwnerID;
    }

    /**
     * Get a list of all covered drivers's unique driver licence number
     * @return - a list of all covered drivers's unique driver licence number
     */
    public List<String> getCoveredDrivers(){
        return this.coveredDrivers;
    }

    /**
     * Get the insurance expiration date
     * @return - the insurance expiration date
     */
    public LocalDate getInsuranceExpirationDate(){
        return this.insuranceExpirationDate;
    }

    /**
     * Get the list of all vehicle violation history
     * @return - the list of all vehicle violation history
     */
    public List<VehicleViolation> getHistory(){
        return this.history;
    }

    /**
     * Get the plate of vehicle
     * @return - the plate of vehicle
     */
    public String getPlate(){
        return this.plate;
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
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getMake().equals(vehicle.getMake()) &&
                getModel().equals(vehicle.getModel()) &&
                getYear().equals(vehicle.getYear()) &&
                getOfficialOwnerID().equals(vehicle.getOfficialOwnerID()) &&
                getCoveredDrivers().equals(vehicle.getCoveredDrivers()) &&
                getInsuranceExpirationDate().equals(vehicle.getInsuranceExpirationDate()) &&
                getHistory().equals(vehicle.getHistory()) &&
                getPlate().equals(vehicle.getPlate());
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode(){
        return Objects.hash(getMake(), getModel(), getYear(), getOfficialOwnerID(), getCoveredDrivers(), getInsuranceExpirationDate(), getHistory(), getPlate());
    }

    /**
     * Return the string representation of the object
     *
     * @return - the string representation of the object
     */
    @Override
    public String toString(){
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", officialOwnerID='" + officialOwnerID + '\'' +
                ", coveredDrivers=" + coveredDrivers +
                ", insuranceExpirationDate=" + insuranceExpirationDate +
                ", history=" + history +
                '}';
    }

    /**
     * Represents a Builder of the Vehicle
     */
    public static class VehicleBuilder {
        private String make;
        private String model;
        private Integer year;
        private String officialOwnerID;
        private List<String> coveredDrivers;
        private LocalDate insuranceExpirationDate;
        private List<VehicleViolation> history;
        private String plate;


        /**
         * A private constructor that can only accessed by the static method newInstance()
         */
        private VehicleBuilder(){}

        /**
         * Create a new VehicleBuilder
         * @return - a new VehicleBuilder
         */
        public static VehicleBuilder newInstance(){
            return new VehicleBuilder();
        }

        /**
         * Set the make
         * @param make - make of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder make(String make) {
            this.make = make;
            return this;
        }

        /**
         * Set the model
         * @param model - model of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder model(String model) {
            this.model = model;
            return this;
        }

        /**
         * Set the year
         * @param year - year of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder year(Integer year) {
            this.year = year;
            return this;
        }

        /**
         * Set the officialOwnerID
         * @param officialOwnerID - officialOwnerID of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder officialOwner(String officialOwnerID) {
            this.officialOwnerID = officialOwnerID;
            return this;
        }

        /**
         * Set the coveredDrivers
         * @param coveredDrivers - all coveredDrivers of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder coveredDrivers(List<String> coveredDrivers) {
            this.coveredDrivers = coveredDrivers;
            return this;
        }

        /**
         * Set the insuranceExpirationDate
         * @param insuranceExpirationDate - insuranceExpirationDate of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder insuranceExpirationDate(LocalDate insuranceExpirationDate) {
            this.insuranceExpirationDate = insuranceExpirationDate;
            return this;
        }

        /**
         * Set the history
         * @param history - history of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder history(List<VehicleViolation> history) {
            this.history = history;
            return this;
        }

        /**
         * Set the plate
         * @param plate - the plate of vehicle
         * @return - the VehicleBuilder
         */
        public VehicleBuilder plate(String plate) {
            this.plate = plate;
            return this;
        }

        /**
         * Check whether all required fields are set
         * @return true or false
         */
        private boolean allFieldsAreSet(){
            if (this.make == null)
                return false;
            if (this.model == null)
                return false;
            if (this.year == null)
                return false;
            if (this.officialOwnerID == null)
                return false;
            if (this.coveredDrivers == null)
                return false;
            if (this.insuranceExpirationDate == null)
                return false;
            if (this.plate == null)
                return false;
            return this.history != null;
        }

        /**
         * Build a new Vehicle object
         * @return a new Vehicle object
         * @throws NotALLFieldsSetException - the exception that not all required fields are set
         */
        public Vehicle build() throws NotALLFieldsSetException {
            if (!allFieldsAreSet())
            throw new NotALLFieldsSetException();
            return new Vehicle(this);
        }
    }

}
