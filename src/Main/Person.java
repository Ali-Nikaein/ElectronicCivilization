package Main;

import Main.Buildings.Terminal;
import Main.Vehicles.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable {
    private String Name;
    private String Last_name;
    private City birth_place;
    private String Business;
    private String Gender;
    private int birth_year;
    private float basic_salary;

    public String get_Name() {
        return this.Name;
    }

    public String get_Last_name() {
        return this.Last_name;
    }

    public City get_birth_place() {
        return this.birth_place;
    }

    public String get_Gender() {
        return this.Gender;
    }

    public String get_Business() {
        return this.Business;
    }

    public float basic_salary() {
        return this.basic_salary;
    }

    public int get_birth_year() {
        return this.birth_year;
    }

    public static void transportPerson(Terminal initial, Terminal destination, City newCity, City lastCity, ArrayList<Person> passengers, Vehicle vehicle) {
        for(int i=0;i<passengers.size();i++)
        {
            for(int j=0;j<lastCity.getPeople().size();j++)
            {
                if (passengers.get(i) == lastCity.getPeople().get(j)) {
                    lastCity.removePeople(lastCity.getPeople().get(j));
                    newCity.addPeople(lastCity.getPeople().get(j));
                }
            }
        }

        for(int i=0;i<initial.getEmployee().size();i++)
        {
            if (vehicle instanceof InterCityBus) {
                if (initial.getEmployee().get(i).get_Business().equals("Bus driver")) {
                    destination.addEmployee(initial.getEmployee().get(i));
                    initial.removeEmployee(initial.getEmployee().get(i));
                }
            } else if (vehicle instanceof Train) {
                if (initial.getEmployee().get(i).get_Business().equals("Train driver")) {
                    destination.addEmployee(initial.getEmployee().get(i));
                    initial.removeEmployee(initial.getEmployee().get(i));
                }
            } else if (vehicle instanceof Ship || vehicle instanceof Boat) {
                if (initial.getEmployee().get(i).get_Business().equals("sailor")) {
                    initial.removeEmployee(initial.getEmployee().get(i));
                    destination.addEmployee(initial.getEmployee().get(i));
                }
            } else if (vehicle instanceof CargoPlane || vehicle instanceof PassengerAircraft) {
                if (initial.getEmployee().get(i).get_Business().equals("pilot")) {
                    initial.removeEmployee(initial.getEmployee().get(i));
                    destination.addEmployee(initial.getEmployee().get(i));
                }
            }
        }
    }

    public Person(String Name, String Last_name, City birth_place, String Business, String Gender, int birth_year, float basic_salary) {
        this.Name = Name;
        this.Last_name = Last_name;
        this.birth_place = birth_place;
        //  this.birth_place.people.add(this);
        this.Business = Business;
        this.Gender = Gender;
        this.birth_year = birth_year;
        this.basic_salary = basic_salary;
    }
}
