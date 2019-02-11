import java.lang.*;

public class PaymentParser {

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
                    String[] text = s.split(" ");
                    addNewElement(text[0], Integer.parseInt(text[1]));
                }
            }
        }
    }

    private static void addNewElement(String currencyСode, int balance) {

        if (currencyСode.length() != 3) {

            System.out.println("Неверный формат валюты!");
            return;
        }

        for (Account accountList : PaymentTracker.getWriteToFileList()) {

            if (accountList.getCurrencyСode().equals(currencyСode)) {

                accountList.setBalance(balance);
                return;
            }
        }

        PaymentTracker.setWriteToFileList(currencyСode, balance);
    }
}