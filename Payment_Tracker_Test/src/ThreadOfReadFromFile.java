import java.lang.*;
import java.io.*;

public class ThreadOfReadFromFile implements Runnable {

    Thread thrd;

    String nameOfFile;

    // Конструктор класса потока.
    ThreadOfReadFromFile(String nameOfThread, String nameOfFile) {

        thrd = new Thread(this, nameOfThread);

        this.nameOfFile = nameOfFile;
    }

    // Метод создания и запуска потока.
    public static ThreadOfReadFromFile createAndStart(String nameOfThread, String nameOfFile) {

        ThreadOfReadFromFile threadOfReadFromFile = new ThreadOfReadFromFile(nameOfThread, nameOfFile);
        threadOfReadFromFile.thrd.start();

        return threadOfReadFromFile;
    }

    public void readFromFile() {
        String stringFromFile = "";

        try (BufferedReader bufferedReaderFromFile = new BufferedReader(new FileReader(nameOfFile))) {

            PaymentTracker.writeToFileList.clear();

            while ((stringFromFile = bufferedReaderFromFile.readLine()) != null) {

                if (!stringFromFile.equals("")) {

                    PaymentTracker.splitString(stringFromFile);

                } else continue;
            }

            for (Account accountList : PaymentTracker.writeToFileList) {

                if (accountList.getBalance() != 0) System.out.println(accountList.toString());
            }

        } catch (IOException ioe) {

            System.out.println("Ошибка при попытке доступа к файлу ");
        }
    }

    @Override
    public void run() {

        while (true) {

            readFromFile();

            System.out.println();
            System.out.println("Пожалуйста, введите ниже код валюты и желаемую сумму. Для выхода из программы введите \"quit\"");

            try {
                Thread.sleep(60000);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}