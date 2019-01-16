import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.lang.Object;

public class PaymentTracker {

    private String nameOfFile; // Имя файла с платежами

    private ArrayList<Account> writeToFileList = new ArrayList<>();

    PaymentTracker(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    // Метод чтения из файла.
    String readerFromFile() {

        String info = "";


        try (BufferedReader accountsReader = new BufferedReader(new FileReader(nameOfFile))) {

            while (((info = accountsReader.readLine())) != null) {
                if (!info.equals("")) {
                    splitStringForMap(info);
                } else continue;
            }

            writeToFile(writeToFileList);

        } catch (IOException e) {
            System.out.println("Ошибка при попытке доступа к файлу");
        }

        return info;
    }

    // Метода записи в файл
    void writeToFile(ArrayList<Account> arrayList) {

        for (Account acco : arrayList) {

            System.out.println(acco.toString());
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


    private void splitStringForMap(String stringInListForSplit) {

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

