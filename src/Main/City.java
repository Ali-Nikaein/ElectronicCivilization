package Main;

import Main.Buildings.*;
import Main.Exception.CapacityOfVehicle;
import Main.Exception.DriverException;
import Main.Exception.NumberOfPassengers;
import Main.Exception.TerminalException;
import Main.Vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import static Main.Main.*;

public class City implements Serializable {
    private String name;
    private int price = 10000;
    private int population = 1000;
    private final ArrayList<Terminal> terminals = new ArrayList<>();
    private final ArrayList<Hotel> hotels = new ArrayList<>();
    private final ArrayList<Person> people = new ArrayList<>();  // should not be static   should be private
    private final ArrayList<Bank> banks = new ArrayList<>();
    transient Scanner sc = new Scanner(System.in);

    public void terminalsInfo() {
        int counter = 0;
        System.out.println("Terminals Info : \n");
        for (Terminal t : terminals) {
            counter++;
            if (t instanceof Airport) {
                System.out.println(counter + ". Air Port");
                System.out.println("its place : "+t.get_terminal_name());
            } else if (t instanceof BusTerminal) {
                System.out.println(counter + ". Bus Terminal");
                System.out.println("its place : "+t.get_terminal_name());
            } else if (t instanceof RailwayStation) {
                System.out.println(counter + ". Railway Station");
                System.out.println("its place : "+t.get_terminal_name());
            } else if (t instanceof ShippingPort) {
                System.out.println(counter + ". Shipping Port");
                System.out.println("its place : "+t.get_terminal_name());
            }
        }
    }

    public ArrayList<Terminal> terminalsInfo(Terminal initial) {
        ArrayList<Terminal> temp = new ArrayList<>();
        int counter = 0;
        System.out.println("Terminals Info : \n");
        for (Terminal t : terminals) {
            counter++;
            if (initial instanceof Airport) {
                if (t instanceof Airport) {
                    temp.add(t);
                    System.out.println(counter + ". Air Port");
                    System.out.println("its place : "+t.get_terminal_name());
                }
            } else if (initial instanceof BusTerminal) {
                if (t instanceof BusTerminal) {
                    temp.add(t);
                    System.out.println(counter + ". Bus Terminal");
                    System.out.println("its place : "+t.get_terminal_name());
                }
            } else if (initial instanceof RailwayStation) {
                if (t instanceof RailwayStation) {
                    temp.add(t);
                    System.out.println(counter + ". Railway Station");
                    System.out.println("its place : "+t.get_terminal_name());
                }
            } else if (initial instanceof ShippingPort) {
                if (t instanceof ShippingPort) {
                    temp.add(t);
                    System.out.println(counter + ". Shipping Port");
                    System.out.println("its place : "+t.get_terminal_name());
                }
            }
        }
        return temp;
    }

    public Terminal returnDestinationTerminal(int number) {
        int count = 0;
        int flag=1;
        for (Terminal t : terminals) {
            count++;
            if (count == number) {
                return t;
            }
            else {
                flag=0;
            }
        }
        if (flag==0)
        {
            throw new TerminalException("The selected terminal doesn't exist in city !");
        }
        return null;
    }

    public Terminal returnDestinationTerminal(ArrayList<Terminal> temp, int number) {
        int count = 0;
        for (Terminal t : temp) {
            count++;
            if (count == number) {
                return t;
            }
        }
        return null;
    }

    public Vehicle returnVehicleForTravel(Terminal terminal) {
        int h;
        sc = new Scanner(System.in);
        if (terminal instanceof Airport) {
            System.out.println("What kind of plane do you want ?");
            System.out.println("1. Passenger ");
            System.out.println("2. Cargo ");
            System.out.println("write the number of selected plane : ");
            h = sc.nextInt();
            if (h == 1) {
                int size = ((Airport) terminal).getPassengerPlanePlane().size();
                return ((Airport) terminal).getPassengerPlanePlane().get(size - 1);
            } else {
                int size = ((Airport) terminal).getCargoPlane().size();
                return ((Airport) terminal).getCargoPlane().get(size - 1);
            }
        } else if (terminal instanceof BusTerminal) {
            int size = ((BusTerminal) terminal).getBus().size();
            return ((BusTerminal) terminal).getBus().get(size - 1);
        } else if (terminal instanceof ShippingPort) {
            System.out.println("What kind of Marin vehicle do you want ?");
            System.out.println("1. Ship ");
            System.out.println("2. Boat ");
            System.out.println("write the number of selected terminal : " + (h = sc.nextInt()));
            if (h == 1) {
                int size = ((ShippingPort) terminal).getShip().size();
                return ((ShippingPort) terminal).getShip().get(size - 1);
            } else {
                int size = ((ShippingPort) terminal).getBoat().size();
                return ((ShippingPort) terminal).getBoat().get(size - 1);
            }
        } else {
            int size = ((RailwayStation) terminal).getTrain().size();
            return ((RailwayStation) terminal).getTrain().get(size - 1);
        }
    }

    public Person returnDriverForTravel(Terminal terminal, Vehicle vehicle) {
        int flag=1;
        if (vehicle instanceof Train) {
            for (Person p : terminal.getEmployee()) {
                if (p.get_Business().equals("Train driver")) {
                    return p;
                }
                else {
                    flag=0;
                }
            }
            if(flag==0)
            {
                throw new DriverException("For now there is no any train driver in your city !");
            }
            return null;
        } else if (vehicle instanceof Ship || vehicle instanceof Boat) {
            for (Person p : terminal.getEmployee()) {
                if (p.get_Business().equals("sailor")) {
                    return p;
                }
                else {
                    flag=0;
                }
            }
            if(flag==0)
            {
                throw new DriverException("For now there is no any sailor in your city !");
            }
            return null;
        } else if (vehicle instanceof PassengerAircraft || vehicle instanceof CargoPlane) {
            for (Person p : terminal.getEmployee()) {
                if (p.get_Business().equals("pilot")) {
                    return p;
                }
                else {
                    flag=0;
                }
            }
            if(flag==0)
            {
                throw new DriverException("For now there is no any pilot in your city !");
            }
            return null;
        } else {
            for (Person p : terminal.getEmployee()) {
                if (p.get_Business().equals("Bus driver")) {
                    return p;
                }
                else {
                    flag=0;
                }
            }
            if(flag==0)
            {
                throw new DriverException("For now there is no any Bus driver in your city !");
            }
            return null;
        }
    }

    public void addToBankList(Bank bank)
    {
        banks.add(bank);
    }

    public int price_getPrice() {
        return this.price;
    }

    public void price_setPrice(int x) {
        this.price = x;
    }

    public int population_getPopulation() {
        return this.population;
    }

    public void population_setPopulation(int x) {
        this.population = x;
    }

    public void addPeople(Person p) {
        people.add(p);
    }

    public void removePeople(Person p) {
        people.remove(p);
    }

    public ArrayList<Person> getPeople() {

        return people;
    }

    public ArrayList<Terminal> getTerminals() {

        return terminals;
    }

    public ArrayList<Hotel> getHotels() {

        return hotels;
    }

    void addPeople(City c) {
        sc = new Scanner(System.in);
        System.out.println("Fill the below fields in order : "+ANSI_GREEN+"\n 1.name \n 2.last_name \n 3.Business \n 4.Gender \n 5.birth_year \n 6.basic_salary \n "+ANSI_RESET);
        Person p = new Person(sc.next(), sc.next(), c, sc.next(), sc.next(), sc.nextInt(), sc.nextFloat());
        people.add(p);
    }

    Terminal addShippingPortTerminals(City city) {
        int myPrice;
        sc = new Scanner(System.in);
        System.out.println("Fill the below fields in order : "+ANSI_GREEN+"\n 1.city_name \n 2.terminal_name \n 3.address \n 4.Area \n 5.Number_of_vehicles \n 6.number_of_docks \n "+ANSI_RESET);
        ShippingPort port = new ShippingPort(sc.next(), sc.next(), sc.next(), sc.nextFloat(), sc.nextInt(), sc.nextInt());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 500));
        System.out.println("Your price : "+ANSI_RED+ city.price_getPrice()+ANSI_RESET);
        terminals.add(port);
        return port;
    }

    Terminal addBusTerminals(City city) {
        int myPrice;
        sc = new Scanner(System.in);
        System.out.println("Fill the below fields in order : "+ANSI_GREEN+"\n 1.city_name \n 2.terminal_name \n 3.address \n 4.Area \n 5.Number_of_vehicles \n 6.bus_company_name \n "+ANSI_RESET);
        BusTerminal busTerminal = new BusTerminal(sc.next(), sc.next(), sc.next(), sc.nextFloat(), sc.nextInt(), sc.next());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 600));
        System.out.println("Your price : "+ANSI_RED + city.price_getPrice()+ANSI_RESET);
        terminals.add(busTerminal);
        return busTerminal;
    }

    Terminal addTrainTerminals(City city) {
        int myPrice;
        sc = new Scanner(System.in);
        System.out.println("Fill the below fields in order : "+ANSI_GREEN+"\n 1.city_name \n 2.terminal_name \n 3.address \n 4.Area \n 5.Number_of_vehicles \n 6.number_of_input_rails \n 7.number_of_output_rails \n "+ANSI_RESET);
        RailwayStation railway_station = new RailwayStation(sc.next(), sc.next(), sc.next(), sc.nextFloat(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 900));
        System.out.println("Your price : " +ANSI_RED + city.price_getPrice()+ANSI_RESET);
        terminals.add(railway_station);
        return railway_station;
    }

    Terminal addAirplaneTerminals(City city) {
        int myPrice;
        sc = new Scanner(System.in);
        System.out.println("Fill the below fields in order : "+ANSI_GREEN+"\n 1.city_name \n 2.terminal_name \n 3.address \n 4.Area \n 5.Number_of_vehicles \n 6.Type_of_airport \n 7.Number_of_runways \n "+ANSI_RESET);
        System.out.println("<<Warning>> : For more than 2 runways you should pay 200$ for each additional runway !");
        Airport airport = new Airport(sc.next(), sc.next(), sc.next(), sc.nextFloat(), sc.nextInt(), sc.next(), sc.nextInt());
        if (2 < airport.getNumber_of_runways()) {
            int sum, counter = 0;
            for (int i = 0; i < (airport.getNumber_of_runways() - 2); i++) {
                counter++;
            }
            sum = counter * 200;
            myPrice = city.price_getPrice();
            city.price_setPrice((myPrice - 1000) - sum);
        } else {
            myPrice = city.price_getPrice();
            city.price_setPrice((myPrice - 1000));
        }
        System.out.println("Your price : "+ANSI_RED  + city.price_getPrice()+ANSI_RESET);
        terminals.add(airport);
        return airport;
    }

    public ArrayList<Person> choosePassenger(Vehicle travelVehicle) {
        int counter = 0, n;
        sc = new Scanner(System.in);
        ArrayList<Person> pass = new ArrayList<>();
        for (Person p : this.getPeople()) {
            counter++;
            System.out.println(counter + ". " + p.get_Name());
        }
        System.out.println("How many people do you want to choose ?");
        n = sc.nextInt();
        if(n > this.getPeople().size() )
        {
            throw new NumberOfPassengers("the number of passengers that you have entered is more than people number !");
        }
        if(n < (travelVehicle.getCapacity()/2))
        {
            throw new CapacityOfVehicle("the number of passengers that you have entered is less than half of capacity of the vehicle !");
        }
        for (int i = 0; i < n; i++) {
            pass.add(this.getPeople().get(i));
        }
        return pass;
    }

    Hotel addHotels() {
        sc = new Scanner(System.in);
        System.out.println("Fill the below fields in order : "+ANSI_GREEN+"\n 1.hotel_name \n 2.hotel_address \n 3.hotel_stars \n 4.number_of_rooms \n "+ANSI_RESET);
        Hotel hotel = new Hotel(sc.next(), sc.next(), sc.nextInt(), sc.nextInt());
        hotels.add(hotel);
        return hotel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    City(String Name, int price, int population) {
        setName(Name);
        price_setPrice(price);
        population_setPopulation(population);
    }

    City() {

    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
}
