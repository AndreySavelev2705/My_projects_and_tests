import com.sun.source.tree.IfTree;

import java.lang.*;
import java.util.ArrayList;

public class PaymentTracker {

    private String nameOfFile; // Имя файла с платежами

    public static ArrayList<Account> writeToFileList = new ArrayList<>();

    // Конструктор класса.
    PaymentTracker(String nameOfFile) {

        this.nameOfFile = nameOfFile;
    }

    // Метод разбиения строки счета на код валюты и сумму.
    public static void splitString(String stringInListForSplit) {

        String[] listWithStringForSplit = new String[1];
        listWithStringForSplit[0] = stringInListForSplit;

        for (int i = 0; i < listWithStringForSplit.length; i++) {

            if ((listWithStringForSplit[i] != null) && (!listWithStringForSplit[i].isEmpty())) {

                // Разбитие строки по символу переноса строки.
                String[] str = listWithStringForSplit[i].split("\n");

                for (String s : str) {

                    // Разбитие строки по символу пробела.
                    String[] t = s.split(" ");
                    filter(t[0], Integer.parseInt(t[1]));
                }
            }
        }
    }

    private static void filter(String currencyСode, int balance) {

        if (currencyСode.length() != 3) {

            System.out.println("Неверный формат валюты!");
            return;
        }

        for (Account accountList : writeToFileList) {

            if (accountList.getCurrencyСode().equals(currencyСode)) {

                accountList.setBalance(balance);
                return;
            }
        }

        writeToFileList.add(new Account(currencyСode, balance));
    }
}