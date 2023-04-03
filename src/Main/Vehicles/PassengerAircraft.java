package Main.Vehicles;

import java.io.Serializable;

public class PassengerAircraft extends Air_vehicle implements Serializable
{
    private int Number_of_crew;
    private String Classification_of_aircraft_seats;

    public PassengerAircraft(int Capacity, int ID, String Company_name, float max_height, float landing_Band_length, int Number_of_crew, String Classification_of_aircraft_seats)
    {
        super(700, Capacity, ID, Company_name,max_height,landing_Band_length);
        this.Number_of_crew=Number_of_crew;
        this.Classification_of_aircraft_seats=Classification_of_aircraft_seats;
    }
}
