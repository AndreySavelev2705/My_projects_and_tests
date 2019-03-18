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

    // Вывод объекта данного типа.
    @Override
    public String toString() {
            return this.getCurrencyСode() + " " + this.getBalance();
    }
}