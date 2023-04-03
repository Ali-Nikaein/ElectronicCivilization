package Main.Buildings;

import Main.City;
import Main.Travel.Travel;
import Main.Vehicles.Train;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

import static Main.Main.ANSI_RED;
import static Main.Main.ANSI_RESET;

public class RailwayStation extends Terminal implements Serializable {
    private final ArrayList<Train> train = new ArrayList<>();
    private final ArrayList<Travel> sendPeople = new ArrayList<>();
    private final ArrayList<Travel> getPeople = new ArrayList<>();
    private int number_of_input_rails;
    private int number_of_output_rails;

    public ArrayList<Train> getTrain() {
        return train;
    }

    public void addNewTrain(City city) {
        int myPrice;
        System.out.println("Fill the below fields in order : \n 1.Capacity \n 2.ID \n 3.Company_name \n 4.Engine_power \n 5.acceleration \n 6.max_speed \n 7.number_of_wagons \n 8.Stars \n 9.RefahType");
        Train train1 = new Train(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt(), sc.nextFloat(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 600));
        System.out.println("Your price : "+ANSI_RED + city.price_getPrice()+ANSI_RESET);
        train.add(train1);
    }

    @Override
    public void addVehicle(Vehicle v) {
        train.add((Train) v);
    }

    @Override
    public void removeVehicle(Vehicle v) {
        train.remove((Train) v);
    }

    public RailwayStation(String city_name, String terminal_name, String address, float Area, int Number_of_vehicles, int number_of_input_rails, int number_of_output_rails) {
        super(900, city_name, terminal_name, address, Area, Number_of_vehicles);
        setNumber_of_input_rails(number_of_input_rails);
        setNumber_of_output_rails(number_of_output_rails);
    }

    public void setNumber_of_input_rails(int number_of_input_rails) {
        this.number_of_input_rails = number_of_input_rails;
    }

    public void setNumber_of_output_rails(int number_of_output_rails) {
        this.number_of_output_rails = number_of_output_rails;
    }

    public int getNumber_of_input_rails() {
        return number_of_input_rails;
    }

    public int getNumber_of_output_rails() {
        return number_of_output_rails;
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
