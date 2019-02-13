public class Account {

    private String currencyСode;
    private long balance;

    // Конструктор класса.
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
        this.currencyСode = currencyСode;
    }

    // Возварщение значения валюты.
    public long getBalance() {
        return balance;
    }

    // Установка значения валюты.
    public void setBalance(long account) {
        balance += account;
    }

    // Конвертация в доллары по курсу по умолчанию.
    public double converter(long balance) {
        double exchangeRate = 66.44;
        double result = (balance / exchangeRate);

        return result;
    }

    // Вывод объекта данного типа.
    @Override
    public String toString() {

        if (this.getCurrencyСode().compareTo("USD") == 0) {
            return this.getCurrencyСode() + " " + this.getBalance();
        } else
            return this.getCurrencyСode() + " " + this.getBalance() + " (USD "
                    + String.format("%1.2f", converter(balance)) + ")";
    }
}