package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a traffic violation committed by driver
 */
public abstract class DriverViolation{
    protected LocalDate violationDate;

    /**
     * Constructs a new DriverViolation with given violation date
     * @param violationDate - violation date
     */
    protected DriverViolation(LocalDate violationDate){
        this.violationDate = violationDate;
    }

    /**
     * Get the violation date
     * @return - violation date
     */
    protected LocalDate getViolationDate(){
        return this.violationDate;
    }


    public abstract Enum getType();

    /**
     * Return whether or not the given object is the same as this object.
     *
     * @param o the object to be compared to for equality.
     * @return whether or not the given object is the same as this object.
     */
    @Override
    public boolean equals(Object o){
        DriverViolation that = (DriverViolation) o;
        return getViolationDate().equals(that.getViolationDate());
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode(){
        return Objects.hash(getViolationDate());
    }
}
