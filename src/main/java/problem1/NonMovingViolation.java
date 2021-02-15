package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an non-moving traffic violation committed by driver
 */
public class NonMovingViolation extends DriverViolation{
    private final NonMovingType type;

    /**
     * Constructs a new Non-movingViolation object based on provided parameters
     * @param violationDate - the violation date
     * @param type - the violation type
     */
    public NonMovingViolation(LocalDate violationDate, NonMovingType type){
        super(violationDate);
        this.type = type;
    }

    /**
     * Get the violation type
     * @return - the violation type
     */
    @Override
    public NonMovingType getType(){
        return this.type;
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
        if (!(o instanceof NonMovingViolation)) return false;
        if (!super.equals(o)) return false;
        NonMovingViolation that = (NonMovingViolation) o;
        return getType() == that.getType();
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), getType());
    }

    /**
     * Return the string representation of the object
     *
     * @return - the string representation of the object
     */
    @Override
    public String toString(){
        return "NonMovingViolation{" +
                "type=" + type +
                ", violationDate=" + violationDate +
                '}';
    }
}
