package Main.Exception;

import java.io.Serializable;

public class TerminalException extends InvalidTrip implements Serializable {
    public TerminalException(String str)
    {
        super(str);
    }
}
