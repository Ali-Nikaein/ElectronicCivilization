package Main.Exception;

import java.io.Serializable;

public class VehicleExistingException extends CancelTravel implements Serializable {
    public VehicleExistingException(String str)
    {
        super(str);
    }
}
