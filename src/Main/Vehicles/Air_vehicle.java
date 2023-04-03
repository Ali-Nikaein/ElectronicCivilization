package Main.Vehicles;
import java.io.Serializable;
import java.util.ArrayList;
import Main.Buildings.Terminal;
abstract public class Air_vehicle extends Vehicle implements Serializable {
    private float max_height;
    private float landing_Band_length;

    public Air_vehicle(int price, int Capacity, int ID, String Company_name,float max_height,float landing_Band_length) {
        super(price, Capacity, ID, Company_name);
        this.max_height=max_height;
        this.landing_Band_length=landing_Band_length;
    }
}
