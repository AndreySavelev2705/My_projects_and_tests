import java.lang.*;
import java.io.*;
import java.util.ArrayList;

public class ThreadOfWriteToFile implements Runnable {

    Thread thrd;
    ThreadOfReadFromFile threadOfReadFromFile;

    String nameOfThread;
    String nameOfFile;

    // Конструктор класса потока.
    ThreadOfWriteToFile(String nameOfThread, String nameOfFile, ThreadOfReadFromFile threadOfReadFromFile) {

        thrd = new Thread(this);

        this.nameOfThread = nameOfThread;
        this.nameOfFile = nameOfFile;
        this.threadOfReadFromFile = threadOfReadFromFile;
    }

    // Метод создания и запуска потока.
    public static ThreadOfWriteToFile createAndStart(String nameOfThread, String nameOfFile, ThreadOfReadFromFile threadOfReadFromFile) {

        ThreadOfWriteToFile threadOfWriteToFile = new ThreadOfWriteToFile(nameOfThread, nameOfFile, threadOfReadFromFile);
        threadOfWriteToFile.thrd.start();

        return threadOfWriteToFile;
    }

    public void writeToFile(String stringForWritingToFile) {

        try (FileWriter fileWriter = new FileWriter(nameOfFile, true)) {

            if ((stringForWritingToFile != null) && (!stringForWritingToFile.isEmpty())) {

                stringForWritingToFile = stringForWritingToFile + "\r\n";
                fileWriter.write(stringForWritingToFile);
            }

        } catch (IOException ioe) {

            System.out.println("Ошибка при попытке доступа к файлу");
        }
    }

    public void writeToFile(ArrayList<Account> listOfWriteToFile) {

        try (FileWriter fileWriter = new FileWriter(nameOfFile)) {

            for (Account newAccount : listOfWriteToFile) {
                String str = newAccount.getCurrencyСode() + " " + newAccount.getBalance();
                if ((str != null) && (!str.isEmpty())) {
                    str = str + "\r\n";
                    fileWriter.write(str);
                }
            }
        } catch (IOException ioe) {

            System.out.println("Ошибка при попытке доступа к файлу");
        }
    }

    @Override
    public void run() {

        while (true) {

            if (PaymentTracker.writeToFileList.size() != 0) {

                writeToFile(PaymentTracker.writeToFileList);
            }

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}