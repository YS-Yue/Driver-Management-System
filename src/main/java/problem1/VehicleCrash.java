package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a vehicle crash
 */
public class VehicleCrash extends VehicleViolation{
    private final Crash crashType;

    /**
     * Constructs a VehicleCrash object based upon all given parameters
     * @param offendingDriverName - the name of the offending driver
     * @param dateOfViolation - teh date of violation
     * @param crashType - the crash type
     */
    public VehicleCrash(Name offendingDriverName, LocalDate dateOfViolation, Crash crashType){
        super(offendingDriverName, dateOfViolation);
        this.crashType = crashType;
    }

    /**
     * Get the crash type
     * @return - the crash type
     */
    public Crash getType(){
        return this.crashType;
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
        if (!(o instanceof VehicleCrash)) return false;
        if (!super.equals(o)) return false;
        VehicleCrash that = (VehicleCrash) o;
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
        return "VehicleCrash{" +
                "crashType=" + crashType +
                ", offendingDriverName=" + offendingDriverName +
                ", dateOfViolation=" + dateOfViolation +
                '}';
    }
}
