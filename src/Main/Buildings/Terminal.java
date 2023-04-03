package Main.Buildings;

import Main.City;
import Main.Exception.TerminalException;
import Main.Person;
import Main.Vehicles.Air_vehicle;
import Main.Vehicles.InterCityBus;
import Main.Vehicles.Vehicle;
import static Main.Main.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Terminal implements Serializable {
    private final int cost_of_built;
    private final String city_name;
    private final String terminal_name;
    private final String address;
    private final float Area;
    private final int Number_of_vehicles;
    private final ArrayList<Person> Employee = new ArrayList<>();
    transient Scanner sc = new Scanner(System.in);

    public void addNewEmployee(City city, int flag) {
        int javab, myPrice;
        sc = new Scanner(System.in);
        switch (flag) {
            case 1:
                System.out.println("Recruitment people for shipping port");
                for (int i=0;i<city.getPeople().size();i++)
                {
                    if (city.getPeople().get(i).get_Business().equals("sailor")) {
                        System.out.println(ANSI_PURPLE+city.getPeople().get(i).get_Name()+ANSI_RESET+" job : "+ANSI_GREEN+city.getPeople().get(i).get_Business()+ANSI_RESET);
                        System.out.println("Do you want to recruit this person ?");
                        System.out.println("1.Yes");
                        System.out.println("2.No");
                        javab = sc.nextInt();
                        if (javab == 1) {
                            Employee.add(city.getPeople().get(i));
                            city.removePeople(city.getPeople().get(i));
                            myPrice = city.price_getPrice();
                            city.price_setPrice((myPrice - 500));
                            System.out.println("Your sailor is recruited !");
                            System.out.println("Your price : "+ANSI_RED + city.price_getPrice()+ANSI_RESET);
                            break;
                        } else {
                            System.out.println("You didn't get any employee !");
                        }
                    }
                }
                break;
            case 2:
                System.out.println("Recruitment people for Bus terminal");
                for (int i=0;i<city.getPeople().size();i++)
                {
                    if (city.getPeople().get(i).get_Business().equals("Bus driver")) {
                        System.out.println(ANSI_PURPLE+city.getPeople().get(i).get_Name()+ANSI_RESET+" job : "+ANSI_GREEN+city.getPeople().get(i).get_Business()+ANSI_RESET);
                        System.out.println("Do you want to recruit this person ?");
                        System.out.println("1.Yes");
                        System.out.println("2.No");
                        javab = sc.nextInt();
                        if (javab == 1) {
                            Employee.add(city.getPeople().get(i));
                            city.removePeople(city.getPeople().get(i));
                            myPrice = city.price_getPrice();
                            city.price_setPrice((myPrice - 100));
                            System.out.println("Your bus driver is recruited !");
                            System.out.println("Your price : "+ANSI_RED  + city.price_getPrice()+ANSI_RESET);
                        } else {
                            System.out.println("You didn't get any employee !");
                        }
                    }
                }
                break;
            case 3:
                System.out.println("Recruitment people for Train station");
                for (int i=0;i<city.getPeople().size();i++)
                {
                    if (city.getPeople().get(i).get_Business().equals("Train driver")) {
                        System.out.println(ANSI_PURPLE+city.getPeople().get(i).get_Name()+ANSI_RESET+" job : "+ANSI_GREEN+city.getPeople().get(i).get_Business()+ANSI_RESET);
                        System.out.println("Do you want to recruit this person ?");
                        System.out.println("1.Yes");
                        System.out.println("2.No");
                        javab = sc.nextInt();
                        if (javab == 1) {
                            Employee.add(city.getPeople().get(i));
                            city.removePeople(city.getPeople().get(i));
                            myPrice = city.price_getPrice();
                            city.price_setPrice((myPrice - 400));
                            System.out.println("Your Train driver is recruited !");
                            System.out.println("Your price : "+ANSI_RED   + city.price_getPrice()+ANSI_RESET);
                        } else {
                            System.out.println("You didn't get any employee !");
                        }
                    }
                }
                break;
            case 4:
                System.out.println("Recruitment people for Air port");
                for (int i=0;i<city.getPeople().size();i++){
                    if (city.getPeople().get(i).get_Business().equals("pilot")) {
                        System.out.println(ANSI_PURPLE+city.getPeople().get(i).get_Name()+ANSI_RESET+" job : "+ANSI_GREEN+city.getPeople().get(i).get_Business()+ANSI_RESET);
                        System.out.println("Do you want to recruit this person ?");
                        System.out.println("1.Yes");
                        System.out.println("2.No");
                        javab = sc.nextInt();
                        if (javab == 1) {
                            Employee.add(city.getPeople().get(i));
                            city.removePeople(city.getPeople().get(i));
                            myPrice = city.price_getPrice();
                            city.price_setPrice((myPrice - 700));
                            System.out.println("Your pilot is recruited !");
                            System.out.println("Your price : "+ANSI_RED   + city.price_getPrice()+ANSI_RESET);
                        } else {
                            System.out.println("You didn't get any employee !");
                        }
                    }
                }
                break;
        }

    }

    public void addNewCrewEmployee(City city, Terminal terminal) {
        int javab, myPrice;
        sc = new Scanner(System.in);
        System.out.println("Recruitment crew for ships");
        ArrayList<Person> a = new ArrayList<>();
        for (Person element5 : city.getPeople()) {
            if (element5.get_Business().equals("crew")) {
                System.out.println(element5.get_Name());
                System.out.println("Do you want to recruit this person ?");
                System.out.println("1.Yes");
                System.out.println("2.No");
                javab = sc.nextInt();
                if (javab == 1) {
                    Employee.add(element5);
                    a.add(element5);
                    //city.removePeople(element5);
                    myPrice = city.price_getPrice();
                    city.price_setPrice((myPrice - 60));
                    System.out.println("Your crew is recruited !");
                    System.out.println("Your price : " +ANSI_RED + city.price_getPrice()+ANSI_RESET);
                } else {
                    System.out.println("You didn't get any employee !");
                }
            }
        }
        city.getPeople().removeAll(a);
    }

    public static void checkTerminalsForTravel(Terminal a, Terminal b) {
        if (a instanceof BusTerminal) {
            if (!(b instanceof BusTerminal)) {
                throw new TerminalException("initial terminal and destination terminal are not same !");
            }
        } else if (a instanceof RailwayStation) {
            if (!(b instanceof RailwayStation)) {
                throw new TerminalException("initial terminal and destination terminal are not same !");
            }
        } else if (a instanceof Airport) {
            if (!(b instanceof Airport)) {
                throw new TerminalException("initial terminal and destination terminal are not same !");
            }
        } else if (a instanceof ShippingPort) {
            if (!(b instanceof ShippingPort)) {
                throw new TerminalException("initial terminal and destination terminal are not same !");
            }
        }
    }

    public void addEmployee(Person p) {
        Employee.add(p);
    }

    public void removeEmployee(Person p) {
        Employee.remove(p);
    }

    public ArrayList<Person> getEmployee() {

        return Employee;
    }

    public int cost_of_built() {
        return this.cost_of_built;
    }

    public String get_city_name() {
        return this.city_name;
    }

    public String get_terminal_name() {
        return this.terminal_name;
    }

    public String get_address() {
        return this.address;
    }

    public float get_Area() {
        return this.Area;
    }

    public int get_Number_of_vehicles() {
        return this.Number_of_vehicles;
    }

    public Terminal(int cost_of_built, String city_name, String terminal_name, String address, float Area, int Number_of_vehicles) {
        this.cost_of_built = cost_of_built;
        this.city_name = city_name;
        this.terminal_name = terminal_name;
        this.address = address;
        this.Area = Area;
        this.Number_of_vehicles = Number_of_vehicles;
    }

    public abstract void addVehicle(Vehicle v);

    public abstract void removeVehicle(Vehicle v);

}