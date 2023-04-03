package Main.Vehicles;
import java.io.Serializable;
import java.util.ArrayList;
import Main.Buildings.Terminal;
abstract public class landVehicle extends Vehicle implements Serializable
{
    private final int EnginePower;
    private final float acceleration;
    private final int maxSpeed;

    public landVehicle(int price, int Capacity, int ID, String Company_name, int Engine_power, float acceleration, int max_speed) {
        super(price, Capacity, ID, Company_name);
        this.EnginePower=Engine_power;
        this.acceleration=acceleration;
        this.maxSpeed=max_speed;

    }

    public int getEnginePower() {
        return EnginePower;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
