import java.lang.*;
import java.io.*;

public class ThreadOfReadFromConsole implements Runnable {

    Thread thrd;
    ThreadOfWriteToFile threadOfWriteToFile;

    String nameOfFile;

    // Конструктор класса потока.
    ThreadOfReadFromConsole(String nameOfThread, String nameOfFile, ThreadOfWriteToFile threadOfWriteToFile) {

        thrd = new Thread(this, nameOfThread);

        this.threadOfWriteToFile = threadOfWriteToFile;
        this.nameOfFile = nameOfFile;
    }

    // Метод создания и запуска потока.
    public static ThreadOfReadFromConsole createAndStart(String nameOfThread, String nameOfFile, ThreadOfWriteToFile threadOfWriteToFile) {

        ThreadOfReadFromConsole threadOfReadFromConsole = new ThreadOfReadFromConsole(nameOfThread, nameOfFile, threadOfWriteToFile);
        threadOfReadFromConsole.thrd.start();

        return threadOfReadFromConsole;
    }

    public String readFromConsole() {

        String stringFromConsole = "";

        BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));

        try {
            stringFromConsole = bufferedReaderFromConsole.readLine();

            if (stringFromConsole.equals("quit")) System.exit(0);

            PaymentTracker.splitString(stringFromConsole);

        } catch (IOException e) {

            System.out.println("Простите, но Вы ввели что-то не то.");
        }

        return stringFromConsole;
    }

    @Override
    public void run() {

        while (true) {

            threadOfWriteToFile.writeToFile(readFromConsole());
        }
    }
}