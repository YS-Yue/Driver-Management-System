package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a vehicle moving violation
 */
public class VehicleMovingViolation extends VehicleViolation {
    private final MovingType movingType;

    /**
     * Constructs a new VehicleMovingViolation object based upon all given parameters
     * @param offendingDriverName - the offending driver's name
     * @param dateOfViolation - the date of violation
     * @param movingType - the moving violation type
     */
    public VehicleMovingViolation(Name offendingDriverName, LocalDate dateOfViolation, MovingType movingType){
        super(offendingDriverName, dateOfViolation);
        this.movingType = movingType;
    }

    /**
     * Get the the moving violation type
     * @return - the moving violation type
     */
    public MovingType getType(){
        return this.movingType;
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
        if (!(o instanceof VehicleMovingViolation)) return false;
        if (!super.equals(o)) return false;
        VehicleMovingViolation that = (VehicleMovingViolation) o;
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
        return "VehicleMovingViolation{" +
                "movingType=" + movingType +
                ", offendingDriverName=" + offendingDriverName +
                ", dateOfViolation=" + dateOfViolation +
                '}';
    }
}
