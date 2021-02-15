package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a vehicle non-moving violation
 */
public class VehicleNonMovingViolation extends VehicleViolation{
    private final NonMovingType type;

    /**
     * Constructs a new VehicleNonMovingViolation object based upon all given parameters
     * @param offendingDriverName - the offending driver's name
     * @param dateOfViolation - the date of violation
     * @param type - the moving violation type
     */
    public VehicleNonMovingViolation(Name offendingDriverName, LocalDate dateOfViolation, NonMovingType type){
        super(offendingDriverName, dateOfViolation);
        this.type = type;
    }

    /**
     * Get the the non-moving violation type
     * @return - the non-moving violation type
     */
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
        if (!(o instanceof VehicleNonMovingViolation)) return false;
        if (!super.equals(o)) return false;
        VehicleNonMovingViolation that = (VehicleNonMovingViolation) o;
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
        return "VehicleNonMovingViolation{" +
                "type=" + type +
                ", offendingDriverName=" + offendingDriverName +
                ", dateOfViolation=" + dateOfViolation +
                '}';
    }
}
