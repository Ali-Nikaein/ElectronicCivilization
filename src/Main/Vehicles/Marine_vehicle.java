package Main.Vehicles;
import java.io.Serializable;
import java.util.ArrayList;
import Main.Buildings.Terminal;
abstract public class Marine_vehicle extends Vehicle implements Serializable
{
    private String Type_of_fuel_required;
    private float Min_depth_to_move;

    public Marine_vehicle(int price, int Capacity, int ID, String Company_name,String Type_of_fuel_required,float Min_depth_to_move) {
        super(price, Capacity, ID, Company_name);
        this.Type_of_fuel_required=Type_of_fuel_required;
        this.Min_depth_to_move=Min_depth_to_move;
    }
}
