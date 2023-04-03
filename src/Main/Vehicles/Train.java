package Main.Vehicles;

import Main.RefahType;

import java.io.Serializable;

public class Train extends landVehicle implements Serializable {
    private int number_of_wagons;
    private int Stars;
    private RefahType type;

    public Train(int Capacity, int ID, String Company_name, int Engine_power, float acceleration, int max_speed, int number_of_wagons, int Stars, String refahType) {
        super(600, Capacity, ID, Company_name, Engine_power, acceleration, max_speed);
        setType(refahType);
        this.number_of_wagons = number_of_wagons;
        this.Stars = Stars;
    }

    public void setType(String std) {
        switch (std) {
            case "restaurant":
            case "RESTAURANT":
                this.type = RefahType.RESTAURANT;
            case "healthservices":
            case "healthSERVICES":
                this.type = RefahType.healthSERVICES;
            case "WC":
            case "wc":
                this.type = RefahType.wc;
        }
    }

    public RefahType getType() {
        return type;
    }
}
