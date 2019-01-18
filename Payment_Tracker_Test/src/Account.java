import java.io.Serializable;
import java.text.DecimalFormat;

public class Account implements Serializable {

    private String currencyСode;
    private long balance;

    // Конструктор класса
    public Account(String currencyСode, long balance) {
        setCurrencyСode(currencyСode);
        setBalance(balance);
    }

    // Возвращение значения кода валюты.
    public String getCurrencyСode() {

        return currencyСode;
    }

    // Установка значения кода валюты.
    public void setCurrencyСode(String currencyСode) {
        if (currencyСode.length() <= 3)
            this.currencyСode = currencyСode;
        else
            System.out.println("Неверный формат валюты!");
    }

    // Возварщение значения валюты.
    public long getBalance() {

        return balance / 100;
    }


    // Установка значения валюты.
    public void setBalance(long account) {

        balance += (account * 100);
    }

    // Конвертация в доллары по курсу по умолчанию
    public double converter(long balance) {
        double exchangeRate = 66.44;
        double result = (balance / exchangeRate) / 100;

        return result;
    }

    // Вывод объекта данного типа.
    @Override
    public String toString() {

        if (this.getCurrencyСode().compareTo("USD") == 0)

            return this.getCurrencyСode() + " " + this.getBalance();
        else
            return this.getCurrencyСode() + " " + this.getBalance() + " (USD "
                    + String.format("%1.2f", converter(balance)) + ")";
    }
}
