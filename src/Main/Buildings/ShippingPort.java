package Main.Buildings;

import Main.City;
import Main.Travel.Travel;
import Main.Vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;

import static Main.Main.*;

public class ShippingPort extends Terminal implements Serializable {
    private int number_of_docks;
    private final ArrayList<Travel> sendPeople = new ArrayList<>();
    private final ArrayList<Travel> getPeople = new ArrayList<>();
    private final ArrayList<Ship> ship = new ArrayList<>();
    private final ArrayList<Boat> boat = new ArrayList<>();

    public ArrayList<Ship> getShip()
    {
        return ship;
    }

    public ArrayList<Boat> getBoat()
    {
        return boat;
    }

    public void addShip(City city) {
        int myPrice;
        System.out.println("Fill the below fields in order : \n 1.Capacity \n 2.ID \n 3.Company_name \n 4.Type_of_fuel_required \n 5.Min_depth_to_move \n 6.size_of_body \n");
        Ship ship1 = new Ship(sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextFloat(), sc.next());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 700));
        System.out.println("Your price : " +ANSI_RED+ city.price_getPrice()+ANSI_RESET);
        ship.add(ship1);
    }

    public void addNewBoat(City city) {
        int myPrice;
        System.out.println("Fill the below fields in order : \n 1.Capacity \n 2.ID \n 3.Company_name \n 4.Type_of_fuel_required \n 5.Min_depth_to_move \n 6.Means_of_movement \n");
        Boat boat1 = new Boat(sc.nextInt(), sc.nextInt(), sc.next(), sc.next(), sc.nextFloat(), sc.next());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 100));
        System.out.println("Your price : "+ANSI_RED+city.price_getPrice()+ANSI_RESET);
        boat.add(boat1);
    }

    @Override
    public void addVehicle(Vehicle v) {
        if (v instanceof Ship)
            ship.add((Ship) v);
        else if (v instanceof Boat)
            boat.add((Boat) v);
    }

    @Override
    public void removeVehicle(Vehicle v) {
        if (v instanceof Ship)
            ship.remove((Ship) v);
        else if (v instanceof Boat)
            boat.remove((Boat) v);
    }

    public void addBoat(Boat b) {
        boat.add(b);
    }

    public void removeBoat() {
        boat.remove(boat.size() - 1);
    }

    public void setNumber_of_docks(int number_of_docks) {
        this.number_of_docks = number_of_docks;
    }

    public ShippingPort(String city_name, String terminal_name, String address, float Area, int Number_of_vehicles, int x) {
        super(500, city_name, terminal_name, address, Area, Number_of_vehicles);
        setNumber_of_docks(x);
    }

    public int getNumber_of_docks() {
        return number_of_docks;
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
