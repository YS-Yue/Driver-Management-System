package problem1;

// A NotALLFieldsSetException is dedicated towards the exception that not all required fields are set.
public class NotALLFieldsSetException extends Exception{
    public NotALLFieldsSetException(){
        super("Not all required fields are set");
    }
}
