package problem1;

/**
 * A DriverRejectedException is dedicated towards the exception that the driver is rejected by validator.
 */
public class DriverRejectedException extends Exception{
    public DriverRejectedException(String message){
        super(message);
    }
}
