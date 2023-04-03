package Main.Buildings;

import Main.BankAccount;

import java.io.Serializable;
import java.util.ArrayList;

public class Bank implements Serializable {
    ArrayList<BankAccount> accounts = new ArrayList<>();
    String BankName;
    int AllMoneyInBank;
    int numberOfActiveAccounts;

    public BankAccount checkUserNameAndPassword(String userName, String password) {
        for (BankAccount bankAccount : accounts) {
            if (bankAccount.getOwner().get_Name().equals(userName)) {
                if (bankAccount.getPassword().equals(password)) {
                    return bankAccount;
                }
            }
        }
        return null;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public String getBankName() {
        return BankName;
    }

    public void bankInfo() {
        int counter = 0;
        System.out.println("Bank Name : " + BankName);
        for (BankAccount bankAccount : accounts) {
            counter++;
            AllMoneyInBank += bankAccount.getAccountBalance();
        }
        System.out.println("All Money in this bank is : " + AllMoneyInBank);
        System.out.println("Number of Active Accounts : " + counter);
    }

    public int doesAccountExist(BankAccount bankAccount) {
        int flag = 0;
        for (BankAccount Account : this.getAccounts()) {
            if (bankAccount.getOwner() == Account.getOwner()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void addAccountToBank(BankAccount bankAccount)
    {
        accounts.add(bankAccount);
    }
    public Bank(String bankName) {
        this.BankName = bankName;
    }
}
