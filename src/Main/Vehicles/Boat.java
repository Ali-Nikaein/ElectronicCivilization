package Main.Vehicles;

import java.io.Serializable;

public class Boat extends Marine_vehicle implements Serializable
{
    private String Means_of_movement;

    public Boat(int Capacity, int ID, String Company_name,String Type_of_fuel_required,float Min_depth_to_move, String Means_of_movement) {
        super(100, Capacity, ID, Company_name,Type_of_fuel_required,Min_depth_to_move);
        this.Means_of_movement=Means_of_movement;
    }
}
