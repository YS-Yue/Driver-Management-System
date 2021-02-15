package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a vehicle violation
 */
public abstract class VehicleViolation {
    protected Name offendingDriverName;
    protected LocalDate dateOfViolation;

    /**
     * Constructs a new VehicleViolation object based upon given parameters
     * @param offendingDriverName - the name of the offending driver
     * @param dateOfViolation - the violation date
     */
    public VehicleViolation(Name offendingDriverName, LocalDate dateOfViolation){
        this.offendingDriverName = offendingDriverName;
        this.dateOfViolation = dateOfViolation;
    }

    /**
     * Get the name of the offending driver
     * @return - the name of the offending driver
     */
    public Name getOffendingDriverName(){
        return this.offendingDriverName;
    }

    /**
     * Get the violation date
     * @return - the violation date
     */
    public LocalDate getDateOfViolation(){
        return this.dateOfViolation;
    }

    /**
     * Get the type of the violation
     * @return - the type of the violation
     */
    public abstract Enum getType();

    /**
     * Return whether or not the given object is the same as this object.
     *
     * @param o the object to be compared to for equality.
     * @return whether or not the given object is the same as this object.
     */
    @Override
    public boolean equals(Object o){
        VehicleViolation that = (VehicleViolation) o;
        return getOffendingDriverName().equals(that.getOffendingDriverName()) &&
                getDateOfViolation().equals(that.getDateOfViolation());
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode(){
        return Objects.hash(getOffendingDriverName(), getDateOfViolation());
    }
}
