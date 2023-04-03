package Main.Exception;

import java.io.Serializable;

public class InvalidInput extends RuntimeException implements Serializable {
    public InvalidInput(String str)
    {
        super(str);
    }
    public InvalidInput()
    {
        super("Your entered information is not correct !");
    }
}
