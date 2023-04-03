package Main.Exception;

import java.io.Serializable;

public class CityExistingException extends InvalidInput implements Serializable {
    public CityExistingException(String str)
    {
        super(str);
    }
}
