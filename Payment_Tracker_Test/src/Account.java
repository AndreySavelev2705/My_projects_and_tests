import java.io.Serializable;
import java.text.DecimalFormat;

public class Account implements Serializable {

    private String currencyСode;
    private long balance;

    public Account(String currencyСode, long balance) {
        setCurrencyСode(currencyСode);
        setBalance(balance);
    }

    public String getCurrencyСode() {
        return currencyСode;
    }

    public void setCurrencyСode(String currencyСode) {
        if (currencyСode.length() <= 3)
            this.currencyСode = currencyСode;
        else
            System.out.println("Неверный формат валюты!");
    }

    public long getBalance() {
        return balance / 100;
    }

    public void setBalance(long account) {

        balance += (account * 100);
    }

    @Override
    public String toString() {

        if (this.getCurrencyСode().compareTo("USD") == 0)

            return this.getCurrencyСode() + " " + this.getBalance();
        else
            return this.getCurrencyСode() + " " + this.getBalance() + " (USD "
                    + String.format("%1.2f", converter(balance)) + ")";
    }

    public double converter(long balance) {
        double exchangeRate = 60;
        double result = (balance / exchangeRate) / 100;

        return result;
    }
}
