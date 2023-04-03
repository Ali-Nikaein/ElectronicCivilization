package Main;

import Main.Buildings.Bank;
import Main.City;
import Main.Buildings.Terminal;
import Main.Exception.CityExistingException;
import Main.Vehicles.Air_vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static Main.Main.*;

public class Country implements Serializable {

    private final ArrayList<City> cities = new ArrayList<City>();
    private int final_Population;
    private int final_Price;

    public double calculateSumOfMoneysInBanks()
    {
        double sum = 0 ;
        for(City city: cities)
        {
            for (Bank bank : city.getBanks())
            {
                for (BankAccount bankAccount : bank.getAccounts())
                {
                    sum += bankAccount.getAccountBalance();
                }
            }
        }
        return sum;
    }
    public void addCity(City c) {
        cities.add(c);
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void citiesInfo() {
        int counter = 0;
        int flag=0;
        System.out.println(ANSI_GREEN+"Cities Info : \n"+ANSI_RESET);
        for (City city : cities) {
            counter++;
            System.out.println("Number " + counter + " City Name :" +ANSI_YELLOW+ city.getName()+ANSI_RESET);
            System.out.println("City population :" +ANSI_YELLOW+ city.getPeople().size()+ANSI_RESET);
            System.out.println("City price :" +ANSI_YELLOW+ city.price_getPrice()+ANSI_RESET);
            System.out.println("\n");
            flag=1;
        }
       if(flag==0)
       {
           throw new CityExistingException("There is no any city in your country !");
       }
    }

    public static int finalPopulation(ArrayList<City> C) {
        int a = 0;
        for (int i = 0; i < C.size(); i++) {
            a = a + C.get(i).population_getPopulation();
        }
        return a;
    }

    public static int finalPrice(ArrayList<City> C) {
        int a = 0;
        for (int i = 0; i < C.size(); i++) {
            a = a + C.get(i).price_getPrice();
        }
        return a;
    }

    public City returnSelectedCity(int number) {
        int count = 0;
        int flag=1;
        for (City city : cities) {
            count++;
            if (count == number) {
                return city;
            }
            else {
                flag=0;
            }
        }
        if(flag==0)
        {
            throw new CityExistingException("The city that you entered its number doesn't exist !");
        }
        return null;
    }

    public int getFinal_Population() {
        return final_Population;
    }

    public void setFinal_Population() {
        this.final_Population = finalPopulation(cities);
    }

    public int getFinal_Price() {
        return final_Price;
    }

    public void setFinal_Price() {
        this.final_Price = finalPrice(cities);
    }
}
