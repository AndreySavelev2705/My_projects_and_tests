import java.lang.*;
import java.io.*;

public class ThreadOfReadFromFile implements Runnable {

    private Thread thrd;
    private String nameOfFile;

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

            while ((stringFromFile = bufferedReaderFromFile.readLine()) != null) {

                if (!stringFromFile.equals("")) {
                    PaymentTracker.addNewElement(PaymentParser.parsingTheString(stringFromFile));
                } else continue;
            }

        } catch (IOException ioe) {
            System.out.println("Ошибка при попытке доступа к файлу ");
        }
    }

    @Override
    public void run() { readFromFile(); }
}