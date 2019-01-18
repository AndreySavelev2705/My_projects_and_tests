import com.sun.source.tree.IfTree;

import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PaymentTracker {

    private String nameOfFile; // Имя файла с платежами

    private ArrayList<Account> writeToFileList = new ArrayList<>();

    // Конструктор класса.
    PaymentTracker(String nameOfFile) {

        this.nameOfFile = nameOfFile;
    }

    // Метод чтения из файла.
    void readerFromFile() {

        String info = "";


        try (BufferedReader accountsReader = new BufferedReader(new FileReader(nameOfFile))) {

            while (((info = accountsReader.readLine())) != null) {
                if (!info.equals("")) {
                    splitString(info);
                    System.out.println(info);
                } else continue;
            }

            System.out.println();
            writeToFile(writeToFileList);


        } catch (IOException e) {
            System.out.println("Ошибка при попытке доступа к файлу");
        }

        System.out.println("\nВведите новые коды валют и их значения.");

       while (!readerFromConsole().equals("quit")) {
           readerFromConsole();
       }
    }

    private String readerFromConsole() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String stringFromConsole = null;

       try {
           stringFromConsole = bufferedReader.readLine();
           splitString(stringFromConsole);

       } catch (IOException ioe) {
           System.out.println("Вы ввели что-то не то.");
       }

       System.out.println("Идет обработка счета. Это займет минуту, пожалуйста дождитесь конца операции."
                + " Это может занять около 1-ой минуты." + " Для выхода из программы введите \"quit\" ");

       writeToFile(writeToFileList);
        return stringFromConsole;
    }

    // Метода записи в файл
    private void writeToFile(ArrayList<Account> arrayList) {

        // Таймер на 60 секунд
        try {
            // TimeUnit.SECONDS.sleep(10); // Лучше использовать для теста программы.
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();




        try {
            for (Account acco : arrayList) {
                // Вывод счета, если значение не равно нулю.
                if (acco.getBalance() != 0) System.out.println(acco.toString());
                else continue;
            }
        } catch (NullPointerException npe) {
            System.out.println("Валюта, которую вы пытались внести последний раз, не существует!");
            System.exit(0);
        }



        try (FileWriter fileWriter = new FileWriter(nameOfFile)) {

            for (Account accon : writeToFileList) {

                String str = accon.getCurrencyСode() + " " + accon.getBalance();
                if ((str != null) && (!str.isEmpty())) {
                    str = str + "\r\n";
                    fileWriter.write(str);
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при попытке доступа к файлу");
        }

    }


    private void splitString(String stringInListForSplit) {

        if (stringInListForSplit.equals("quit") == true) System.exit(0); // Условие завершения работы программы.

        String[] listWithStringForSplit = new String[1];

        listWithStringForSplit[0] = stringInListForSplit;

        for (int i = 0; i < listWithStringForSplit.length; i++) {

            if ((listWithStringForSplit[i] != null) && (!listWithStringForSplit[i].isEmpty())) {

                // Разбитие строки по символу переноса строки
                String[] str = listWithStringForSplit[i].split("\n");

                for (String s : str) {

                    // Разбитие строки по символу пробела
                    String[] t = s.split(" ");
                    filter(t[0], Integer.parseInt(t[1]));
                }
            }
        }
    }

    private void filter(String str, int arg) {

        boolean bool = false;
        int index = 0;

        if (writeToFileList.size() == 0) {
            writeToFileList.add(new Account(str, arg));
        } else {

            for (int i = 0; i < writeToFileList.size(); i++) {
                if (writeToFileList.get(i).getCurrencyСode().compareTo(str) == 0) {
                    bool = true;
                    index = i;
                }
            }

            if (bool == true) {
                writeToFileList.get(index).setBalance(arg);
            } else writeToFileList.add(new Account(str, arg));
        }
    }

}

