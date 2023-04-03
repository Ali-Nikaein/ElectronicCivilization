package Main.Buildings;

import Main.City;
import Main.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import static Main.Main.ANSI_RED;
import static Main.Main.ANSI_RESET;

public class Hotel implements Serializable {
    private final String hotel_name;
    private final String hotel_address;
    private final int hotel_stars;
    private final int number_of_rooms;
    private final ArrayList<Room> rooms = new ArrayList<>();   // should not be static   should be private

    transient Scanner sc3 = new Scanner(System.in);

    public String get_hotel_name() {
        return this.hotel_name;
    }

    public String get_hotel_address() {
        return this.hotel_address;
    }

    public int get_hotel_stars() {
        return this.hotel_stars;
    }

    public int get_number_of_rooms() {
        return this.number_of_rooms;
    }

    public void addRooms(City city) {
        int myPrice;
        sc3 = new Scanner(System.in);
        System.out.println("Fill the below fields in order : \n 1.room_number \n 2.number_of_beds \n 3.area_of_room \n ");
        Room r = new Room(sc3.nextInt(), sc3.nextInt(), sc3.nextFloat());
        myPrice = city.price_getPrice();
        city.price_setPrice((myPrice - 50));
        System.out.println("Your price : " + ANSI_RED + city.price_getPrice() + ANSI_RESET);
        rooms.add(r);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public Hotel(String hotel_name, String hotel_address, int hotel_stars, int number_of_rooms) {
        this.hotel_name = hotel_name;
        this.hotel_address = hotel_address;
        this.hotel_stars = hotel_stars;
        this.number_of_rooms = number_of_rooms;
    }
}

