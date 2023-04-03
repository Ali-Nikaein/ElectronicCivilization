package Main.Buildings;

import java.io.Serializable;

public class Room implements Serializable
{
    private int room_number;
    private int number_of_beds;
    private float area_of_room;
    final int cost_of_booking_per_night = 5;
    public int get_room_number()
    {
        return this.room_number;
    }
    public int get_number_of_beds()
    {
        return this.number_of_beds;
    }
    public float get_area_of_room()
    {
        return this.area_of_room;
    }
    public int get_cost_of_booking_per_night()
    {
        return this.cost_of_booking_per_night;
    }

    public Room(int room_number,int number_of_beds,float area_of_room)
    {
        this.room_number=room_number;
        this.number_of_beds=number_of_beds;
        this.area_of_room=area_of_room;
    }
}
