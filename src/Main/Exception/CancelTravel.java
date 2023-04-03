package Main.Exception;

import java.io.Serializable;

public class CancelTravel extends RuntimeException implements Serializable {

    public CancelTravel()
    {
        super("Your entered information is wrong");
    }

    public CancelTravel(String str)
    {
        super(str);
    }
}
