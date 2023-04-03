package Main;

import Main.Buildings.Terminal;
import Main.Travel.Travel;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;

public interface BellTravel extends Serializable {
    void newTravel();
    void sortSendTravels(City city);
    void sortGetTravels(City city);
    int calculateCostOfTravel(Vehicle vehicle, ArrayList<Person> passengers);
    void HistoryOfTravels(City city);
}
