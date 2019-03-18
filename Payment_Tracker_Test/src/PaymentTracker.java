import java.util.ArrayList;

public class PaymentTracker {

    private static ArrayList<Account> writeToFileList = new ArrayList<>();

    public static ArrayList<Account> getWriteToFileList() {
        return writeToFileList;
    }

    public static void setWriteToFileList(String currencyСode, int balance) {

        writeToFileList.add(new Account(currencyСode, balance));
    }

    public static void addNewElement(String[] str) {

        String currencyСode = str[0];

        if (currencyСode.length() != 3) {
            System.out.println("Неверный формат валюты!");
            return;
        }

        int balance = 0;

        try {
            balance = Integer.parseInt(str[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("Неверный формат числа!");
        }

        for (Account accountList : getWriteToFileList()) {

            if (accountList.getCurrencyСode().equals(currencyСode)) {
                accountList.setBalance(balance);
                return;
            }
        }

        PaymentTracker.setWriteToFileList(currencyСode, balance);
    }
}