package Main.Travel;

import Main.BellTravel;
import Main.Buildings.*;
import Main.City;
import Main.Person;
import Main.Vehicles.*;

import static Main.Main.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Travel implements Comparable, BellTravel , Serializable {
    private int ID;
    private int costOfTravel;
    private String date;
    private Terminal initialTerminal;
    private Terminal destinationTerminal;
    private ArrayList<Person> passengers;
    private Person driver;
    private Vehicle vehicle;
    private City newCity;
    private City lastCity;

    public void addPassenger(Person p) {
        passengers.add(p);
    }

    @Override
    public int compareTo(Object o) {
        // based on cost of travel !
        if (this.costOfTravel > ((Travel) o).costOfTravel) {
            return 1;
        } else if (this.costOfTravel == ((Travel) o).costOfTravel) {
            return 0;
        } else {
            return -1;
        }

    }

    @Override
    public void newTravel() {
        // make new travel
        for (Terminal terminal : this.lastCity.getTerminals()) {
            if (terminal == this.initialTerminal) {
                if (terminal instanceof BusTerminal) {
                    ((BusTerminal) terminal).setSendPeople(this);
                } else if (terminal instanceof RailwayStation) {
                    ((RailwayStation) terminal).setSendPeople(this);
                } else if (terminal instanceof Airport) {
                    ((Airport) terminal).setSendPeople(this);
                } else if (terminal instanceof ShippingPort) {
                    ((ShippingPort) terminal).setSendPeople(this);
                }
            }
        }
        for (Terminal terminal : this.newCity.getTerminals())
        {
            if (terminal == this.destinationTerminal) {
                if (terminal instanceof BusTerminal) {
                    ((BusTerminal) terminal).setGetPeople(this);
                } else if (terminal instanceof RailwayStation) {
                    ((RailwayStation) terminal).setGetPeople(this);
                } else if (terminal instanceof Airport) {
                    ((Airport) terminal).setGetPeople(this);
                } else if (terminal instanceof ShippingPort) {
                    ((ShippingPort) terminal).setGetPeople(this);
                }
            }
        }
        // transport vehicle to other city
        Vehicle.transportVehicle(this.initialTerminal, this.destinationTerminal, this.vehicle);
        // transport Driver & passengers to other city
        Person.transportPerson(this.initialTerminal, this.destinationTerminal, this.lastCity, this.newCity, this.passengers, this.vehicle);
        // transport cost of travel
        int cityPrice;
        cityPrice = this.lastCity.price_getPrice();
        this.lastCity.price_setPrice(this.getCostOfTravel() + cityPrice);
    }

    @Override
    public void sortSendTravels(City c) {
        for (Terminal t : c.getTerminals()) {
            if (t instanceof Airport) {
                for (int i = 0; i < ((Airport) t).getSendPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((Airport) t).getSendPeople().size(); j++) {
                        if (((Airport) t).getSendPeople().get(i).compareTo(((Airport) t).getSendPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((Airport) t).getSendPeople().get(i);
                            Travel b = ((Airport) t).getSendPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((Airport) t).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((Airport) t).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
            if (t instanceof BusTerminal) {
                for (int i = 0; i < ((BusTerminal) t).getSendPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((BusTerminal) t).getSendPeople().size(); j++) {
                        if (((BusTerminal) t).getSendPeople().get(i).compareTo(((BusTerminal) t).getSendPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((BusTerminal) t).getSendPeople().get(i);
                            Travel b = ((BusTerminal) t).getSendPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((BusTerminal) t).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((BusTerminal) t).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
            if (t instanceof ShippingPort) {
                for (int i = 0; i < ((ShippingPort) t).getSendPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((ShippingPort) t).getSendPeople().size(); j++) {
                        if (((ShippingPort) t).getSendPeople().get(i).compareTo(((ShippingPort) t).getSendPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((ShippingPort) t).getSendPeople().get(i);
                            Travel b = ((ShippingPort) t).getSendPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((ShippingPort) t).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((ShippingPort) t).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
            if (t instanceof RailwayStation) {
                for (int i = 0; i < ((RailwayStation) t).getSendPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((RailwayStation) t).getSendPeople().size(); j++) {
                        if (((RailwayStation) t).getSendPeople().get(i).compareTo(((RailwayStation) t).getSendPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((RailwayStation) t).getSendPeople().get(i);
                            Travel b = ((RailwayStation) t).getSendPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((RailwayStation) t).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((RailwayStation) t).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
        }

    }

    @Override
    public void sortGetTravels(City city) {
        for (Terminal t2 : city.getTerminals()) {
            if (t2 instanceof Airport) {
                for (int i = 0; i < ((Airport) t2).getGetPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((Airport) t2).getGetPeople().size(); j++) {
                        if (((Airport) t2).getGetPeople().get(i).compareTo(((Airport) t2).getGetPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((Airport) t2).getGetPeople().get(i);
                            Travel b = ((Airport) t2).getGetPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((Airport) t2).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((Airport) t2).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
            if (t2 instanceof BusTerminal) {
                for (int i = 0; i < ((BusTerminal) t2).getGetPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((BusTerminal) t2).getGetPeople().size(); j++) {
                        if (((BusTerminal) t2).getGetPeople().get(i).compareTo(((BusTerminal) t2).getGetPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((BusTerminal) t2).getGetPeople().get(i);
                            Travel b = ((BusTerminal) t2).getGetPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((BusTerminal) t2).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((BusTerminal) t2).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
            if (t2 instanceof ShippingPort) {
                for (int i = 0; i < ((ShippingPort) t2).getGetPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((ShippingPort) t2).getGetPeople().size(); j++) {
                        if (((ShippingPort) t2).getGetPeople().get(i).compareTo(((ShippingPort) t2).getGetPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((ShippingPort) t2).getGetPeople().get(i);
                            Travel b = ((ShippingPort) t2).getGetPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((ShippingPort) t2).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((ShippingPort) t2).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
            if (t2 instanceof RailwayStation) {
                for (int i = 0; i < ((RailwayStation) t2).getGetPeople().size() - 1; i++) {
                    for (int j = i + 1; j < ((RailwayStation) t2).getGetPeople().size(); j++) {
                        if (((RailwayStation) t2).getGetPeople().get(i).compareTo(((RailwayStation) t2).getGetPeople().get(j)) < 0) {
                            Travel temp;
                            Travel a = ((RailwayStation) t2).getGetPeople().get(i);
                            Travel b = ((RailwayStation) t2).getGetPeople().get(j);
                            temp = a;
                            a = b;
                            b = temp;
                        }
                    }
                    System.out.println("date : " + ANSI_GREEN + ((RailwayStation) t2).getGetPeople().get(i).date + ANSI_RESET + " ID : " + ANSI_GREEN + ((RailwayStation) t2).getGetPeople().get(i).ID + ANSI_RESET);
                }
            }
        }
    }

    @Override
    public int calculateCostOfTravel(Vehicle vehicles, ArrayList<Person> passenger) {
        int sum = 0;
        vehicle = vehicles;
        if (vehicle instanceof landVehicle) {
            if (vehicle instanceof InterCityBus) {
                sum = passenger.size() * 30;  // every ticket of Bus is 30$
            } else if (vehicle instanceof Train) {
                sum = passenger.size() * 60;  // every ticket of Bus is 60$
            }
        } else if (vehicle instanceof Marine_vehicle) {
            if (vehicle instanceof Ship) {
                sum = passenger.size() * 80;  // every ticket of Bus is 80$
            } else if (vehicle instanceof Boat) {
                sum = passenger.size() * 20;  // every ticket of Bus is 20$
            }
        } else {
            if (vehicle instanceof CargoPlane) {
                sum = passenger.size() * 100;  // every ticket of Bus is 100$
            } else if (vehicle instanceof PassengerAircraft) {
                sum = passenger.size() * 200;  // every ticket of Bus is 200$
            }
        }
        return sum;
    }

    @Override
    public void HistoryOfTravels(City city) {
        int counter=0;
        for (Terminal terminal : city.getTerminals()) {
            if (terminal instanceof Airport) {
                System.out.println("List of input travels :");
                for (Travel travel : ((Airport) terminal).getGetPeople()) {

                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                    counter++;
                }
                System.out.println("List of output travels :");
                for (Travel travel : ((Airport) terminal).getSendPeople()) {
                    counter++;
                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                }
            }
            else if (terminal instanceof RailwayStation) {
                System.out.println("List of input travels :");
                for (Travel travel : ((RailwayStation) terminal).getGetPeople()) {
                    counter++;
                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                }
                System.out.println("List of output travels :");
                for (Travel travel : ((RailwayStation) terminal).getSendPeople()) {
                    counter++;
                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                }
            }
            else if (terminal instanceof BusTerminal) {
                System.out.println("List of input travels :");
                for (Travel travel : ((BusTerminal) terminal).getGetPeople()) {
                    counter++;
                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                }
                System.out.println("List of output travels :");
                for (Travel travel : ((BusTerminal) terminal).getSendPeople()) {
                    counter++;
                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                }
            }
            else if (terminal instanceof ShippingPort) {
                System.out.println("List of input travels :");
                for (Travel travel : ((ShippingPort) terminal).getGetPeople()) {
                    counter++;
                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                }
                System.out.println("List of output travels :");
                for (Travel travel : ((ShippingPort) terminal).getSendPeople()) {
                    counter++;
                    System.out.println("ID : " + ANSI_CYAN + travel.ID + ANSI_RESET + " | Date : " + ANSI_CYAN + travel.date + ANSI_RESET + " | initialTerminal : " + ANSI_CYAN + travel.initialTerminal.get_terminal_name() + ANSI_RESET + " | destinationTerminal : " + ANSI_CYAN + travel.destinationTerminal.get_terminal_name() + ANSI_RESET + " | costOfTravel : " + ANSI_CYAN + travel.costOfTravel + ANSI_RESET);
                }
            }
        }
    }

    public void sortTravels(City city)
    {
        sortSendTravels(city);
        sortGetTravels(city);
    }

    public boolean checkNumberOfTravels(City city)
    {
        int counter =0;
        for (Terminal terminal : city.getTerminals()){
            if (terminal instanceof Airport){
                for (Travel travel : ((Airport) terminal).getGetPeople())
                {
                    counter++;
                }
                for (Travel travel : ((Airport) terminal).getSendPeople()) {
                    counter++;
                }
            }
            else if (terminal instanceof RailwayStation)
            {
                for (Travel travel : ((RailwayStation) terminal).getGetPeople())
                {
                    counter++;
                }
                for (Travel travel : ((RailwayStation) terminal).getSendPeople()) {
                    counter++;
                }
            }
            else if (terminal instanceof BusTerminal)
            {
                for (Travel travel : ((BusTerminal) terminal).getGetPeople())
                {
                    counter++;
                }
                for (Travel travel : ((BusTerminal) terminal).getSendPeople()) {
                    counter++;
                }
            }
            else if (terminal instanceof ShippingPort)
            {
                for (Travel travel : ((ShippingPort) terminal).getGetPeople())
                {
                    counter++;
                }
                for (Travel travel : ((ShippingPort) terminal).getSendPeople()) {
                    counter++;
                }
            }

        }
        if(counter > 1){
            return true;
        }else {
            return false;
        }
    }
    public int getCostOfTravel() {
        return costOfTravel;
    }

    public void setCostOfTravel(int costOfTravel) {
        this.costOfTravel = costOfTravel;
    }

    public Travel(City newCity, City lastCity, Terminal initialTerminal, Terminal destinationTerminal, Vehicle vehicle, Person driver, ArrayList<Person> p, int ID, String date) {
        this.newCity = newCity;
        this.lastCity = lastCity;
        this.initialTerminal = initialTerminal;
        this.destinationTerminal = destinationTerminal;
        this.vehicle = vehicle;
        this.driver = driver;
        passengers = new ArrayList<>(p);
        this.ID = ID;
        this.date = date;
        this.costOfTravel = calculateCostOfTravel(vehicle, p);
    }

    public Travel() {

    }

    public City getNewCity() {
        return newCity;
    }

    public City getLastCity() {
        return lastCity;
    }
}
