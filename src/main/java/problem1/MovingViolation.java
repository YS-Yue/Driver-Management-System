package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a moving traffic violation committed by driver
 */
public class MovingViolation extends DriverViolation{
    private final MovingType type;

    /**
     * Constructs a new MovingViolation object based on provided parameters
     * @param violationDate - the violation date
     * @param type - the violation type
     */
    public MovingViolation(LocalDate violationDate, MovingType type){
        super(violationDate);
        this.type = type;
    }

    @Override
    public MovingType getType(){
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
        if (!(o instanceof MovingViolation)) return false;
        if (!super.equals(o)) return false;
        MovingViolation that = (MovingViolation) o;
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
        return "MovingViolation{" +
                "type=" + type +
                ", violationDate=" + violationDate +
                '}';
    }
}
