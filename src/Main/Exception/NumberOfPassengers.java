package Main.Exception;

import java.io.Serializable;

public class NumberOfPassengers extends CancelTravel implements Serializable {
    public NumberOfPassengers(String str)
    {
        super(str);
    }

}
