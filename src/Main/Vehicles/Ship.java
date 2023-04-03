package Main.Vehicles;

import java.io.Serializable;

public class Ship extends Marine_vehicle implements Serializable
{
    private String size_of_body;

    public Ship(int Capacity, int ID, String Company_name,String Type_of_fuel_required,float Min_depth_to_move,String size_of_body)
    {
        super(700, Capacity, ID, Company_name,Type_of_fuel_required,Min_depth_to_move);
        this.size_of_body = size_of_body;
    }
}
