package Main.Buildings;

import Main.City;
import Main.Travel.Travel;
import Main.Vehicles.InterCityBus;
import Main.Vehicles.Vehicle;
import static Main.Main.*;

import java.io.Serializable;
import java.util.ArrayList;

public class BusTerminal extends Terminal implements Serializable {
    String bus_company_name;
    private final ArrayList<InterCityBus> bus = new ArrayList<>();
    private final ArrayList<Travel> sendPeople = new ArrayList<>();
    private final ArrayList<Travel> getPeople = new ArrayList<>();

    public ArrayList<InterCityBus> getBus()
    {
        return bus;
    }
    public void addNewBus(City city) {
        int myPrice;
        System.out.println("Fill the below fields in order : \n 1.Capacity \n 2.ID \n 3.Company_name \n 4.Engine_power \n 5.acceleration \n 6.max_speed \n 7.seat_type \n 8.Type_of_bus \n");
        InterCityBus bus1 = new InterCityBus(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextFloat(), sc.nextInt(), sc.next(), sc.next());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 150));
        System.out.println("Your price : "+ANSI_RED+ city.price_getPrice()+ANSI_RESET);
        bus.add(bus1);
    }

    @Override
    public void addVehicle(Vehicle v) {
        bus.add((InterCityBus) v);
    }

    @Override
    public void removeVehicle(Vehicle v) {
        bus.remove((InterCityBus) v);
    }

    public BusTerminal(String city_name, String terminal_name, String address, float Area, int Number_of_vehicles, String bus_company_name) {
        super(600, city_name, terminal_name, address, Area, Number_of_vehicles);
        this.bus_company_name = bus_company_name;
    }

    public ArrayList<Travel> getSendPeople() {
        return sendPeople;
    }

    public void setSendPeople(Travel T) {
        sendPeople.add(T);
    }

    public ArrayList<Travel> getGetPeople() {
        return getPeople;
    }

    public void setGetPeople(Travel T) {
        getPeople.add(T);
    }

}
