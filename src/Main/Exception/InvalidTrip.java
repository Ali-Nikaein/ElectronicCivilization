package Main.Exception;

import java.io.Serializable;

public class InvalidTrip extends RuntimeException implements Serializable {
    public InvalidTrip(String str)
    {
        super(str);
    }
    public InvalidTrip()
    {
        super("The information of your trip is not correct !");
    }
}
