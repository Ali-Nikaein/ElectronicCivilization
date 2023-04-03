package Main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransAction implements Serializable {
    double price;
    LocalDate date;
    LocalDateTime time;
    kindOfTransAction kind;
    public enum kindOfTransAction {
        BankInterest,
        Deposit,
        withdraw
    }

    @Override
    public String toString() {
        return "TransAction{" +
                "price=" + price +
                ", date=" + date +
                ", time=" + time +
                ", kind=" + kind +
                '}';
    }
}
