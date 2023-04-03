package Main;

import Main.Buildings.Bank;

import java.io.Serializable;
import java.sql.Time;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static Main.Main.*;
public class BankAccount implements Runnable , Serializable {

    private final ArrayList<TransAction> transActions = new ArrayList<>();
    private final Person owner;
    private double accountBalance=0;
    private final String userName;
    private final String password;
    private Time remainedTimeToNextBankInterest;
    static boolean seeTransActionList=false;

    public TransAction calculateBankInterest() {
        accountBalance = accountBalance * 1.18;

        TransAction tr = new TransAction();

        tr.price = accountBalance;
        LocalDateTime myObj = LocalDateTime.now();
        LocalDate myObj2 = LocalDate.now();
        tr.time = myObj;
        tr.date = myObj2;
        tr.kind = TransAction.kindOfTransAction.BankInterest;
        transActions.add(tr);
        return tr;
    }

    public double getAccountBalance()
    {
        return accountBalance;
    }

    public Person getOwner()
    {
        return owner;
    }

    public BankAccount(Person owner,double accountBalance,String userName,String password)
    {
        this.owner=owner;
        this.accountBalance=accountBalance;
        this.userName=userName;
        this.password=password;
    }

    public static void menuOfBankAccount(BankAccount bankAccount)
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.println("what do you prefer to do ?");
        System.out.println("1.deposit ");
        System.out.println("2.withdraw");
        System.out.println("3.see all transActions");
        a=sc.nextInt();
        if(a==1)
        {
            double value=0;
            System.out.println("How much money do you want to deposit ?");
            System.out.print("Write the price here : ");
            value=sc.nextInt();
            TransAction tr = new TransAction();
            tr.price = value;
            LocalDateTime myObj = LocalDateTime.now();
            LocalDate myObj2 = LocalDate.now();
            tr.time = myObj;
            tr.date = myObj2;
            tr.kind = TransAction.kindOfTransAction.Deposit;
            bankAccount.transActions.add(tr);
            System.out.println(ANSI_YELLOW+"deposited successfully !"+ANSI_RESET);
        }
        else if(a==2)
        {
            double value=0;
            System.out.println("How much money do you want to withdraw ?");
            System.out.print("Write the price here : ");
            value=sc.nextInt();
            TransAction tr = new TransAction();
            tr.price = value;
            LocalDateTime myObj = LocalDateTime.now();
            LocalDate myObj2 = LocalDate.now();
            tr.time = myObj;
            tr.date = myObj2;
            tr.kind = TransAction.kindOfTransAction.withdraw;
            bankAccount.transActions.add(tr);
            System.out.println(ANSI_BLUE+"withdraw successfully !"+ANSI_RESET);
        }
        else if(a==3)
        {
            for (TransAction tr1 : bankAccount.transActions)
            {
                System.out.println(ANSI_CYAN+tr1.toString()+ANSI_RESET);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                TransAction tra;
                tra=calculateBankInterest();
                if(seeTransActionList == true)
                {
                    System.out.println(ANSI_CYAN + tra.toString() + ANSI_RESET + "\n");
                }
                //System.out.println(toString());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "transActions=" + transActions +
                ", owner=" + owner +
                ", accountBalance=" + accountBalance +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", remainedTimeToNextBankInterest=" + remainedTimeToNextBankInterest +
                '}';
    }

    public ArrayList<TransAction> getTransActions() {
        return transActions;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
