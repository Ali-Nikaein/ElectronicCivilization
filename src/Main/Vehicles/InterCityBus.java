package Main.Vehicles;

import java.io.Serializable;

public class InterCityBus extends landVehicle implements Serializable
{
    private final String seat_type;
    private final String Type_of_bus;

    public InterCityBus(int Capacity, int ID, String Company_name, int Engine_power, float acceleration, int max_speed, String seat_type, String Type_of_bus) {
        super(150, Capacity, ID, Company_name,Engine_power,acceleration,max_speed);
        this.seat_type=seat_type;
        this.Type_of_bus=Type_of_bus;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public String getType_of_bus() {
        return Type_of_bus;
    }
}
