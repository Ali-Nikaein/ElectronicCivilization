package Main.Exception;

import java.io.Serializable;

public class DriverException extends CancelTravel implements Serializable {
    public DriverException(String srt)
    {
        super(srt);
    }
}
