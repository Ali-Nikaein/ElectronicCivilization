package Main.Buildings;

import Main.City;
import Main.Travel.Travel;
import Main.Vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;

import static Main.Main.ANSI_RED;
import static Main.Main.ANSI_RESET;

public class Airport extends Terminal implements Serializable {
    private final ArrayList<Air_vehicle> passengerPlane = new ArrayList<>();
    private final ArrayList<Air_vehicle> cargoPlane = new ArrayList<>();
    private final ArrayList<Travel> sendPeople = new ArrayList<>();
    private final ArrayList<Travel> getPeople = new ArrayList<>();
    private String typeOfAirport;
    private int Number_of_runways;

    public ArrayList<Air_vehicle> getCargoPlane() {

        return cargoPlane;
    }

    public ArrayList<Air_vehicle> getPassengerPlanePlane() {

        return passengerPlane;
    }

    public void addNewCargoAirplane(City city) {
        int myPrice;
        System.out.println("Fill the below fields in order : \n 1.Capacity \n 2.ID \n 3.Company_name \n 4.max_height \n 5.landing_Band_length \n 6.Total_portable_weight \n");
        CargoPlane cargo_plane1 = new CargoPlane(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 800));
        System.out.println("Your price : "+ANSI_RED + city.price_getPrice()+ANSI_RESET);
        cargoPlane.add(cargo_plane1);
    }

    public void addNewPassengerAirplane(City city) {
        int myPrice;
        System.out.println("Fill the below fields in order : \n 1.Capacity \n 2.ID \n 3.Company_name \n 4.max_height \n 5.landing_Band_length \n 6.Number_of_crew \n 7.Classification_of_aircraft_seats \n");
        PassengerAircraft passenger_aircraft1 = new PassengerAircraft(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextFloat(), sc.nextFloat(), sc.nextInt(), sc.next());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 700));
        System.out.println("Your price : "+ANSI_RED + city.price_getPrice()+ANSI_RESET);
        passengerPlane.add(passenger_aircraft1);
    }

    @Override
    public void addVehicle(Vehicle v) {
        if (v instanceof CargoPlane)
            cargoPlane.add((CargoPlane) v);
        else if (v instanceof PassengerAircraft)
            passengerPlane.add((PassengerAircraft) v);
    }

    @Override
    public void removeVehicle(Vehicle v) {
        if (v instanceof CargoPlane)
            cargoPlane.remove((CargoPlane) v);
        else if (v instanceof PassengerAircraft)
            passengerPlane.remove((PassengerAircraft) v);
    }

    public void addCargoAirplane(CargoPlane c) {
        cargoPlane.add(c);
    }

    public void removeCargoAirplane() {
        cargoPlane.remove(cargoPlane.size() - 1);
    }

    public void addPassengerAirplane(PassengerAircraft b) {
        passengerPlane.add(b);
    }

    public void removePassengerAirplane() {
        passengerPlane.remove(passengerPlane.size() - 1);
    }

    public Airport(String city_name, String terminal_name, String address, float Area, int Number_of_vehicles, String Type_of_airport, int Number_of_runways) {
        super(1000, city_name, terminal_name, address, Area, Number_of_vehicles);
        this.typeOfAirport = Type_of_airport;
        this.Number_of_runways = Number_of_runways;
        if (this.typeOfAirport.equals("International") || this.typeOfAirport.equals("international")) {
            this.typeOfAirport = "True";
        }
    }

    public int getNumber_of_runways() {
        return Number_of_runways;
    }

    public void setNumber_of_runways(int number_of_runways) {
        Number_of_runways = number_of_runways;
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
