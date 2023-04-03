package Main;

import Main.Buildings.*;
import Main.Exception.CancelTravel;
import Main.Exception.CityExistingException;
import Main.Exception.InvalidInput;
import Main.Exception.InvalidTrip;
import Main.Travel.Travel;
import Main.Vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException {
        String lordName, lordLastName, enterCityName;
        int myPrice;
        int a, b, c, d, e, f, g, h, k, n,m, pasokh, turn = 1, terminalFlag = 0, cityExistFlag = 0;
        Scanner sc = new Scanner(System.in);
        Country country;
        country = checkFileExist();
        startAllThreads(country);
        System.out.println("Please enter your name my lord : ");
        lordName = sc.next();
        System.out.println("Please enter your lastName my lord : ");
        lordLastName = sc.next();
        System.out.println("Lord " + ANSI_GREEN + lordName + " " + lordLastName + ANSI_RESET + " You are president of our country ! \nyou can add cities to our country :) ");
        System.out.println("write yes any key to continue ...");
        sc.next();
        while (turn == 1) {
            System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t" + GREEN_BOLD_BRIGHT + ANSI_BLACK + " Welcome to the biggest electronic country in the middle earth !" + RESET);
            System.out.println("Please choose one of these commands : ");
            System.out.println("1." + ANSI_CYAN + "Build new city" + ANSI_RESET);
            System.out.println("2." + ANSI_PURPLE + "Enter to Intended city" + ANSI_RESET);
            System.out.println("3." + ANSI_GREEN + "Information of all cities" + ANSI_RESET);
            System.out.println("4." + ANSI_BLUE + "See All Money in circulation in the accounts" + ANSI_RESET);
            System.out.println("5."+ANSI_GREEN+"Financial Management"+ANSI_RESET);
            System.out.println("6." + ANSI_RED + "Exit" + ANSI_RESET);
            System.out.print("Please write here : ");
            k = sc.nextInt();
            switch (k) {
                case 1:
                    try {
                        System.out.println("Fill the below fields in order :" + ANSI_GREEN + " \n 1.City name \n 2.Price for the Beginning \n 3.Population for the Beginning" + ANSI_RESET);
                        City bigCity = new City(sc.next(), sc.nextInt(), sc.nextInt());
                        country.addCity(bigCity);
                        if (bigCity.population_getPopulation() > 10) {
                            addExistingPeople(bigCity);
                            System.out.println("10 people added as default to your city !");
                            for (int i = 0; i < (bigCity.population_getPopulation() - 10); i++) {
                                bigCity.addPeople(bigCity);
                            }
                        } else if (bigCity.population_getPopulation() == 10) {
                            addExistingPeople(bigCity);
                            System.out.println("10 people added as default to your city !");
                        } else {
                            for (int i = 0; i < bigCity.population_getPopulation(); i++) {
                                bigCity.addPeople(bigCity);
                            }

                        }
                    } catch (InvalidInput ex) {
                        ex.printStackTrace();
                    }
                    writeInFile(country);
                    break;
                case 2:
                    System.out.println("Enter the name of Intended city :");
                    enterCityName = sc.next();
                    try {
                        for (City city : country.getCities()) {
                            if (enterCityName.equals(city.getName())) {
                                cityExistFlag = 1;
                                int turn2 = 1;
                                while (turn2 == 1) {
                                    System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t" + GREEN_BOLD_BRIGHT + ANSI_BLACK + " Welcome to (" + ANSI_GREEN + city.getName() + ANSI_RESET + ")" + RESET);
                                    System.out.println("\n\n");
                                    createPeople(city);
                                    System.out.println("What do you prefer to do my lord ?");
                                    System.out.println("1." + ANSI_CYAN + "Build Terminal" + ANSI_RESET);
                                    System.out.println("2." + ANSI_PURPLE + "Build Hotel" + ANSI_RESET);
                                    System.out.println("3." + ANSI_GREEN + "Make travel to other cities" + ANSI_RESET);
                                    System.out.println("4." + ANSI_BLUE + "Information of Travels" + ANSI_RESET);
                                    System.out.println("5." + ANSI_YELLOW + "Bank" + ANSI_RESET);
                                    System.out.println("6." + ANSI_RED + "Exit" + ANSI_RESET);
                                    a = sc.nextInt();
                                    switch (a) {
                                        case 1:
                                            try {
                                                System.out.println(ANSI_PURPLE + "1.Buy Vehicle & build terminal");
                                                System.out.println("2.information about all terminals" + ANSI_RESET);
                                                b = sc.nextInt();
                                                switch (b) {
                                                    case 1:
                                                        System.out.println("What kind of Vehicle do you want to buy ?");
                                                        System.out.println(ANSI_PURPLE + "1.marine vehicle ?");
                                                        System.out.println("2.land vehicle ?");
                                                        System.out.println("3.air vehicle ?" + ANSI_RESET);
                                                        c = sc.nextInt();
                                                        switch (c) {
                                                            case 1:
                                                                System.out.println("Build your Shipping_port ! ");
                                                                System.out.println("Every Shipping port cost's 500 $ ");
                                                                if (city.price_getPrice() < 500)
                                                                    System.out.println(ANSI_RED + "Your budget is less than 500 $ " + ANSI_RESET);
                                                                else {
                                                                    terminalFlag = 1;
                                                                    ShippingPort port;
                                                                    port = (ShippingPort) city.addShippingPortTerminals(city);
                                                                    port.addNewEmployee(city, terminalFlag);
                                                                    port.addNewCrewEmployee(city, port);
                                                                    int shipTurn = 0;
                                                                    while (shipTurn != port.get_Number_of_vehicles()) {
                                                                        shipTurn++;
                                                                        System.out.println("What kind of marine_Vehicle do you want to build ?");
                                                                        System.out.println("1.Ship");
                                                                        System.out.println("2.Boat");
                                                                        d = sc.nextInt();
                                                                        switch (d) {
                                                                            case 1:
                                                                                System.out.println("Every ship cost's 700 $ ");
                                                                                if (city.price_getPrice() < 700)
                                                                                    System.out.println(ANSI_RED + "Your budget is less than 700 $ " + ANSI_RESET);
                                                                                else {
                                                                                    port.addShip(city);
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Every boat cost's 100 $ ");
                                                                                if (city.price_getPrice() < 100)
                                                                                    System.out.println(ANSI_RED + "Your budget is less than 100 $ " + ANSI_RESET);
                                                                                else {
                                                                                    port.addNewBoat(city);
                                                                                }
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("What do you want to build ? ");
                                                                System.out.println("1.bus terminal");
                                                                System.out.println("2.railway station");
                                                                e = sc.nextInt();
                                                                switch (e) {
                                                                    case 1:
                                                                        System.out.println("Build your Bus terminal ! ");
                                                                        System.out.println("Every Bus terminal cost's 600 $ ");
                                                                        if (city.price_getPrice() < 600)
                                                                            System.out.println(ANSI_RED + "Your budget is less than 600 $ " + ANSI_RESET);
                                                                        else {
                                                                            terminalFlag = 2;
                                                                            BusTerminal busTerminal;
                                                                            busTerminal = (BusTerminal) city.addBusTerminals(city);
                                                                            busTerminal.addNewEmployee(city, terminalFlag);
                                                                            int busTurn = 0;
                                                                            while (busTurn != busTerminal.get_Number_of_vehicles()) {
                                                                                busTurn++;
                                                                                System.out.println("Every Bus cost's 150 $ ");
                                                                                if (city.price_getPrice() < 150)
                                                                                    System.out.println(ANSI_RED + "Your budget is less than 150 $ " + ANSI_RESET);
                                                                                else {
                                                                                    busTerminal.addNewBus(city);
                                                                                }
                                                                            }
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        System.out.println("Build your Railway station ! ");
                                                                        System.out.println("Every Railway station cost's 900 $ ");
                                                                        if (city.price_getPrice() < 900)
                                                                            System.out.println(ANSI_RED + "Your budget is less than 900 $ " + ANSI_RESET);
                                                                        else {
                                                                            terminalFlag = 3;
                                                                            RailwayStation railway_station;
                                                                            railway_station = (RailwayStation) city.addTrainTerminals(city);
                                                                            railway_station.addNewEmployee(city, terminalFlag);
                                                                            int trainTurn = 0;
                                                                            while (trainTurn != railway_station.get_Number_of_vehicles()) {
                                                                                trainTurn++;
                                                                                System.out.println("Every Train cost's 600 $ ");
                                                                                if (city.price_getPrice() < 600)
                                                                                    System.out.println(ANSI_RED + "Your budget is less than 600 $ " + ANSI_RESET);
                                                                                else {
                                                                                    railway_station.addNewTrain(city);
                                                                                }
                                                                            }
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                            case 3:
                                                                System.out.println("Build your Air port ! ");
                                                                System.out.println("Every Air port cost's 1000 $ ");
                                                                if (city.price_getPrice() < 1000)
                                                                    System.out.println(ANSI_RED + "Your budget is less than 1000 $ " + ANSI_RESET);
                                                                else {
                                                                    terminalFlag = 4;
                                                                    Airport airport;
                                                                    airport = (Airport) city.addAirplaneTerminals(city);
                                                                    airport.addNewEmployee(city, terminalFlag);
                                                                    int planeTurn = 0;
                                                                    while (planeTurn != airport.get_Number_of_vehicles()) {
                                                                        planeTurn++;
                                                                        System.out.println("What do you want to buy ? ");
                                                                        System.out.println("1.Cargo_plane");
                                                                        System.out.println("2.Passenger_aircraft");
                                                                        f = sc.nextInt();
                                                                        switch (f) {
                                                                            case 1:
                                                                                System.out.println("Every Cargo_plane cost's 800 $ ");
                                                                                if (city.price_getPrice() < 800)
                                                                                    System.out.println(ANSI_RED + "Your budget is less than 800 $ " + ANSI_RESET);
                                                                                else {
                                                                                    airport.addNewCargoAirplane(city);
                                                                                }
                                                                                break;
                                                                            case 2:
                                                                                System.out.println("Every Passenger_aircraft cost's 700 $ ");
                                                                                if (city.price_getPrice() < 700)
                                                                                    System.out.println(ANSI_RED + "Your budget is less than 700 $ " + ANSI_RESET);
                                                                                else {
                                                                                    airport.addNewPassengerAirplane(city);
                                                                                }
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("Information about all terminals \n");
                                                        for (Terminal terminal_element : city.getTerminals()) {
                                                            System.out.println("terminal_name : " + ANSI_GREEN + terminal_element.get_terminal_name() + ANSI_RESET);
                                                            System.out.println("city_name : " + ANSI_GREEN + terminal_element.get_city_name() + ANSI_RESET);
                                                            System.out.println("cost_of_built : " + ANSI_GREEN + terminal_element.cost_of_built() + ANSI_RESET);
                                                            System.out.println("address : " + ANSI_GREEN + terminal_element.get_address() + ANSI_RESET);
                                                            System.out.println("get_Area : " + ANSI_GREEN + terminal_element.get_Area() + ANSI_RESET);
                                                            System.out.println("Number_of_vehicles : " + ANSI_GREEN + ((BusTerminal) terminal_element).getBus().size() + ANSI_RESET);
                                                        }
                                                        System.out.println("\n\n Information about all employees \n");
                                                        for (Terminal terminal_element : city.getTerminals()) {
                                                            for (Person employee_element : terminal_element.getEmployee()) {
                                                                System.out.println("Name : " + ANSI_YELLOW + employee_element.get_Name() + ANSI_RESET);
                                                                System.out.println("Last_name : " + ANSI_YELLOW + employee_element.get_Last_name() + ANSI_RESET);
                                                                System.out.println("Business : " + ANSI_YELLOW + employee_element.get_Business() + ANSI_RESET);
                                                                System.out.println("birth_place : " + ANSI_YELLOW + employee_element.get_birth_place().getName() + ANSI_RESET);
                                                                System.out.println("Gender : " + ANSI_YELLOW + employee_element.get_Gender() + ANSI_RESET);
                                                                System.out.println("basic_salary : " + ANSI_YELLOW + employee_element.basic_salary() + ANSI_RESET);
                                                                System.out.println("birth_year : " + ANSI_YELLOW + employee_element.get_birth_year() + ANSI_RESET);
                                                            }
                                                        }
                                                }
                                            } catch (InvalidInput ex) {
                                                ex.printStackTrace();
                                            }
                                            writeInFile(country);
                                            break;
                                        case 2:
                                            try {
                                                System.out.println("1.Build your Hotel ! ");
                                                System.out.println("2.information about all Hotels");
                                                g = sc.nextInt();
                                                switch (g) {
                                                    case 1:
                                                        System.out.println("Every Hotel cost's 400 $ ");
                                                        if (city.price_getPrice() < 400) {
                                                            System.out.println(ANSI_RED + "Your budget is less than 400 $ my lord !" + ANSI_RESET);
                                                        } else {
                                                            Hotel hotel = city.addHotels();
                                                            myPrice = city.price_getPrice();
                                                            city.price_setPrice((myPrice - 400));
                                                            System.out.println("Your price : " + ANSI_RED + city.price_getPrice() + ANSI_RESET);
                                                            System.out.println("Build one room for your hotel my lord !");
                                                            hotel.addRooms(city);

                                                            int room_loop = 1;
                                                            while (room_loop == 1) {
                                                                System.out.println("Do you want to build more rooms my lord ?");
                                                                System.out.println("for every room you should pay 50$ !");
                                                                System.out.println("1.Yes");
                                                                System.out.println("2.No");
                                                                pasokh = sc.nextInt();
                                                                switch (pasokh) {
                                                                    case 1:
                                                                        if (city.price_getPrice() < 50) {
                                                                            System.out.println(ANSI_RED + "Your budget is less than 50$ my lord !" + ANSI_RESET);
                                                                        } else {
                                                                            hotel.addRooms(city);
                                                                        }
                                                                        break;
                                                                    case 2:
                                                                        room_loop = 0;
                                                                        break;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        System.out.println("Information about all Hotels \n");
                                                        for (Hotel hotel_element : city.getHotels()) {
                                                            System.out.println("hotel_name : " + ANSI_GREEN + hotel_element.get_hotel_name() + ANSI_RESET);
                                                            System.out.println("hotel_address : " + ANSI_GREEN + hotel_element.get_hotel_address() + ANSI_RESET);
                                                            System.out.println("hotel_stars : " + ANSI_GREEN + hotel_element.get_hotel_stars() + ANSI_RESET);
                                                            System.out.println("number_of_rooms : " + ANSI_GREEN + hotel_element.get_number_of_rooms() + ANSI_RESET);
                                                            for (Room rooms_element : hotel_element.getRooms()) {
                                                                System.out.println("room_number : " + ANSI_YELLOW + rooms_element.get_room_number() + ANSI_RESET);
                                                                System.out.println("number_of_beds : " + ANSI_YELLOW + rooms_element.get_number_of_beds() + ANSI_RESET);
                                                                System.out.println("area_of_room : " + ANSI_YELLOW + rooms_element.get_area_of_room() + ANSI_RESET);
                                                                System.out.println("cost_of_booking_per_night : " + ANSI_YELLOW + rooms_element.get_cost_of_booking_per_night() + ANSI_RESET);
                                                            }
                                                        }
                                                        break;
                                                }
                                            } catch (InvalidInput ex) {
                                                ex.printStackTrace();
                                            }
                                            writeInFile(country);
                                            break;
                                        case 3:
                                            int travelCycle=1;
                                            while (travelCycle==1)
                                            {
                                                System.out.println("To make a travel first you should choose the city where you wish to go !");
                                                System.out.println("Your city :" + ANSI_YELLOW + city.getName() + ANSI_RESET);
                                                try {
                                                    System.out.println(ANSI_GREEN + "List of all cities in your country :" + ANSI_RESET);
                                                    country.citiesInfo();
                                                    System.out.println("write the number of city to select it : ");
                                                    h = sc.nextInt();
                                                    City selectedCity = country.returnSelectedCity(h);
                                                    System.out.println("Which terminal do you want to choose for your travel ?");
                                                    System.out.println(ANSI_GREEN + "List of all terminals in your city :" + ANSI_RESET);
                                                    city.terminalsInfo();
                                                    System.out.println("write the number of selected terminal : ");
                                                    h = sc.nextInt();
                                                    Terminal initialTerminal = city.returnDestinationTerminal(h);
                                                    Vehicle travelVehicle = city.returnVehicleForTravel(initialTerminal);
                                                    Person driver = city.returnDriverForTravel(initialTerminal, travelVehicle);
                                                    ArrayList<Person> passenger = new ArrayList<>(city.choosePassenger(travelVehicle));

                                                    System.out.println(ANSI_GREEN + "List of all terminals in selected city :" + ANSI_RESET);
                                                    ArrayList<Terminal> temp = new ArrayList<>(selectedCity.terminalsInfo(initialTerminal));
                                                    System.out.println("write the number of selected terminal : ");
                                                    h = sc.nextInt();
                                                    Terminal destinationTerminal = city.returnDestinationTerminal(temp, h);
                                                    Terminal.checkTerminalsForTravel(initialTerminal, destinationTerminal);
                                                    System.out.println("Please fill the form as in order :");
                                                    System.out.println(ANSI_GREEN + "ID of travel");
                                                    System.out.println("Date of travel" + ANSI_RESET);
                                                    Travel travel = new Travel(selectedCity, city, initialTerminal, destinationTerminal, travelVehicle, driver, passenger, sc.nextInt(), sc.next());
                                                    travel.newTravel();
                                                    System.out.println(ANSI_PURPLE + "Your travel is registered !" + ANSI_RESET);
                                                    System.out.println("Your price : " + ANSI_RED + city.price_getPrice() + ANSI_RESET);
                                                    System.out.println("Do you want make another travel ?");
                                                    System.out.println("1.yes");
                                                    System.out.println("2.no");
                                                    System.out.print("write your selected option here : ");
                                                    m=sc.nextInt();
                                                    if(m != 1)
                                                    {
                                                        travelCycle=0;
                                                    }
                                                } catch (InvalidInput | InvalidTrip | CancelTravel ex) {
                                                    ex.printStackTrace();
                                                }
                                                writeInFile(country);
                                            }
                                            break;
                                        case 4:
                                            boolean test;
                                            Travel t = new Travel();
                                            test = t.checkNumberOfTravels(city);
                                            System.out.println(ANSI_PURPLE + "History of travels :" + ANSI_RESET);
                                            if (test) {
                                                t.sortTravels(city);
                                            } else {
                                                t.HistoryOfTravels(city);
                                            }
                                            break;
                                        case 5:
                                            int bankCycle=1;
                                            while (bankCycle==1)
                                            {
                                                try {
                                                    System.out.println(ANSI_PURPLE + "1.Add Bank to city");
                                                    System.out.println("2.Enter to the considered Bank" + ANSI_RESET);
                                                    System.out.println(ANSI_RED + "3.Exit"+ANSI_RESET);

                                                    System.out.print("Write the number of option :");
                                                    n = sc.nextInt();
                                                    if (n == 1) {
                                                        System.out.println("Write the name of bank :");
                                                        Bank newBank = new Bank(sc.next());
                                                        city.addToBankList(newBank);
                                                        System.out.println("Bank created !");
                                                        writeInFile(country);
                                                    } else if (n == 2) {
                                                        Bank bank;
                                                        System.out.println("List of all banks in your city :");
                                                        int bankCounter = 0;
                                                        for (Bank banks : city.getBanks()) {
                                                            bankCounter++;
                                                            System.out.println(bankCounter + ". " + ANSI_GREEN + banks.getBankName() + ANSI_RESET);
                                                        }
                                                        System.out.print("Write the number of selected Bank :");
                                                        n = sc.nextInt();
                                                        bank = city.getBanks().get(n - 1);
                                                        System.out.println("1.Create Account ");
                                                        System.out.println("2.Enter to Account ");
                                                        System.out.println("3.Information of Bank ");
                                                        System.out.print("Write the number of selected option :");
                                                        n = sc.nextInt();
                                                        if (n == 1) {
                                                            int personCounter = 0;
                                                            Person personForAccount = null;
                                                            for (Person p1 : city.getPeople()) {
                                                                personCounter++;
                                                                System.out.println(personCounter + ". " + p1.get_Name());
                                                            }
                                                            System.out.print("Write the number of person who you want to create his account :");
                                                            n = sc.nextInt();
                                                            personForAccount = city.getPeople().get(n-1);

                                                            System.out.println("please write your first accountBalance :");
                                                            BankAccount bankAccount = new BankAccount(personForAccount, sc.nextInt(),personForAccount.get_Name(),"123");
                                                            bank.addAccountToBank(bankAccount);
                                                            runTransActions(bankAccount);
                                                        } else if (n == 2) {
                                                            BankAccount ba;
                                                            String username;
                                                            String password;
                                                            System.out.print("please write your username :");
                                                            username = sc.next();
                                                            System.out.print("please write your password :");
                                                            password = sc.next();
                                                            ba = bank.checkUserNameAndPassword(username, password);
                                                            runTransActions(ba);
                                                            BankAccount.menuOfBankAccount(ba);
                                                        } else if (n == 3) {
                                                            bank.bankInfo();
                                                        }
                                                    }
                                                    else if(n==3)
                                                    {
                                                        bankCycle=0;
                                                    }
                                                    writeInFile(country);
                                                }catch (NullPointerException e2x)
                                                {
                                                    e2x.printStackTrace();
                                                }
                                            }
                                            break;
                                        case 6:
                                            turn2 = 0;
                                            break;
                                    }
                                }
                            }
                        }
                        if (cityExistFlag == 0) {
                            throw new CityExistingException("the entered city doesn't exist !");
                        }
                    } catch (CityExistingException ex) {
                        ex.printStackTrace();
                    }
                    writeInFile(country);
                    break;
                case 3:
                    try {
                        country.citiesInfo();
                    } catch (InvalidInput ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 4:
                    double allMoneys;
                    allMoneys = country.calculateSumOfMoneysInBanks();
                    System.out.println(ANSI_PURPLE+"All Money in circulation of your Banks are : "+ANSI_GREEN+allMoneys+ANSI_RESET);
                    break;
                case 5:
                    int exit =1;
                    System.out.println(ANSI_RED+"Financial Management :"+ANSI_RESET);
                    while (exit != 0)
                    {
                        for(City city : country.getCities())
                        {
                            for (Bank bank233 : city.getBanks())
                            {
                                for (BankAccount bankAccount233 : bank233.getAccounts())
                                {
                                    for (TransAction transAction : bankAccount233.getTransActions())
                                    {
                                        Bank banking = null;
                                        banking = findMyBank(country,bankAccount233);
                                        System.out.println("City name : "+city.getName());
                                        System.out.println("Bank name : "+banking.getBankName());
                                        System.out.println(ANSI_CYAN+transAction.toString()+ANSI_RESET+"\n");
                                    }
                                }
                            }
                        }
                        System.out.println("Do you want to see more transactions ? ");
                        System.out.println("1.yes ");
                        System.out.println("2.no ");
                        m=sc.nextInt();
                        if(m != 1)
                        {
                            exit=0;
                        }
                    }
                    break;
                case 6:
                    Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
                    for (Thread threads : threadSet)
                    {
                        System.out.println(threads.getName());
                        threads.stop();
                    }
                    turn =0;
                    break;
            }

        }
        sc.close();
    }

    public static void startAllThreads(Country country)
    {
        for(City city : country.getCities())
        {
            for (Bank bank233 : city.getBanks())
            {
                for (BankAccount bankAccount233 : bank233.getAccounts())
                {
                    runTransActions(bankAccount233);
                }
            }
        }
    }

    public static Bank findMyBank(Country country, BankAccount bankAccount)
    {
        for(City city : country.getCities())
        {
            for (Bank bank233 : city.getBanks())
            {
                for (BankAccount bankAccount1 : bank233.getAccounts())
                {
                    if(bankAccount==bankAccount1)
                    {
                      return bank233;
                    }
                }
            }
        }
        return null;
    }

    public static void createPeople(City c) {
        int a;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("There is 10 people in your city at first Do you want to invite more people to the city ? (enter 1 or 2)");
        System.out.println("1.Yes ");
        System.out.println("2.No ");
        a = sc2.nextInt();
        if (a == 1) {
            c.addPeople(c);
        } else {
            System.out.println(" No one added ! ");
        }

    }

    public static void addExistingPeople(City c) {
        Person person1 = new Person("ali", "nikaein", c, "sailor", "man", 1367, 500);
        Person person2 = new Person("ahmad", "rezaee", c, "pilot", "man", 1360, 700);
        Person person3 = new Person("reza", "amini", c, "Bus driver", "man", 1378, 100);
        Person person4 = new Person("amin", "mohammadi", c, "Train driver", "man", 1377, 400);
        Person person5 = new Person("Abbass", "Booazar", c, "crew", "women", 1370, 60);
        Person person6 = new Person("Ahmad", "Bazargan", c, "sailor", "man", 1380, 500);
        Person person7 = new Person("Sumy", "nejaty", c, "pilot", "man", 1382, 700);
        Person person8 = new Person("Sasan", "Sepasgozar", c, "Bus driver", "man", 1381, 100);
        Person person9 = new Person("Fateme", "Rezvani", c, "Train driver", "woman", 1380, 400);
        Person person10 = new Person("Mahdi", "Qaemi", c, "crew", "man", 1370, 60);
        c.addPeople(person1);
        c.addPeople(person2);
        c.addPeople(person3);
        c.addPeople(person4);
        c.addPeople(person5);
        c.addPeople(person6);
        c.addPeople(person7);
        c.addPeople(person8);
        c.addPeople(person9);
        c.addPeople(person10);
    }

    public static void writeInFile(Country country) {
        FileOutputStream fOut;
        {
            try {
                fOut = new FileOutputStream("Country.txt", false);
                ObjectOutputStream oOut = new ObjectOutputStream(fOut);
                oOut.writeObject(country);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Country readFromFile() {
        Country country = null;
        try {
            FileInputStream fIn = new FileInputStream("Country.txt");
            ObjectInputStream oIn = new ObjectInputStream(fIn);
            country = (Country) oIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return country;
    }

    public static Country checkFileExist() {
        File file = new File("Country.txt");
        Country country;
        if (file.exists()) {
            country = readFromFile();
        } else {
            country = new Country();
        }
        return country;
    }

    public static void runTransActions(BankAccount bankAccount) {
        if (bankAccount.getAccountBalance() != 0) {
            Thread t = new Thread(bankAccount);
            t.start();
        }
    }

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    //color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}