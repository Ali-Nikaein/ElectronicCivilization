package Main.Vehicles;

import java.io.Serializable;

public class CargoPlane extends Air_vehicle implements Serializable
{
    private float Total_portable_weight;

    public CargoPlane(int Capacity, int ID, String Company_name, float max_height, float landing_Band_length, float Total_portable_weight) {
        super(800, Capacity, ID, Company_name,max_height,landing_Band_length);
        this.Total_portable_weight=Total_portable_weight;
    }
}
