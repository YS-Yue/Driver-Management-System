package problem1;

import java.util.Objects;

/**
 * Representing a person's name with the first name and the last name.
 */
public class Name {
    private final String firstName;
    private final String lastName;

    /**
     * Constructs a new Name object based on given first name and last name.
     * @param firstName - the first name
     * @param lastName - the last name
     */
    public Name(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Return the first name
     * @return - the first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Return the last name
     * @return - the last name
     */
    public String getLastName(){
        return this.lastName;
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
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return Objects.equals(getFirstName(), name.getFirstName()) &&
                Objects.equals(getLastName(), name.getLastName());
    }

    /**
     * Return the hash value of this object.
     *
     * @return the hash value of this object.
     */
    @Override
    public int hashCode(){
        return Objects.hash(getFirstName(), getLastName());
    }

    /**
     * Return the string representation of the object
     *
     * @return - the string representation of the object
     */
    @Override
    public String toString(){
        return "Name{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                '}';
    }
}
