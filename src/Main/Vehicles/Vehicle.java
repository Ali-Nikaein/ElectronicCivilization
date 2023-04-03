package Main.Vehicles;

import Main.Buildings.*;
import Main.Person;

import java.io.Serializable;

abstract public class Vehicle implements Serializable {
    private final int price;
    private final int Capacity;
    private final int ID;
    private final String Company_name;

    public static void transportVehicle(Terminal newTerminal, Terminal lastTerminal, Vehicle v) {
        // will use to transport vehicle to other terminal in other city
        newTerminal.addVehicle(v);
        lastTerminal.removeVehicle(v);
    }

    Vehicle(int price, int Capacity, int ID, String Company_name) {
        this.price = price;
        this.Capacity = Capacity;
        this.ID = ID;
        this.Company_name = Company_name;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return Capacity;
    }

    public int getID() {
        return ID;
    }

    public String getCompany_name() {
        return Company_name;
    }

}