import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PaymentTreckerDemo {

    public static void main(String[] args) {

        System.out.println("\nПожалуйста, введите ниже код валюты и желаемую сумму. " +
                "Для выхода из программы введите \"quit\" \n");

        ThreadOfReadFromFile threadOfReadFromFile = new ThreadOfReadFromFile("Поток чтения из файла", args[0]);
        threadOfReadFromFile.run();

        ScheduledExecutorService scheduledExecutorServiceOfOutputOC = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorServiceOfOutputOC.scheduleWithFixedDelay(ThreadOfOutputOnConsole.createAndStart(
                "Поток вывода на косоль"), 60, 60, TimeUnit.SECONDS);

        synchronized (new PaymentTracker()) {
            ReadFromConsole.readFromConsole();
            try {
                threadOfReadFromFile.wait();
            } catch (InterruptedException ie) {
                System.out.println("упс");
            }
        }
    }
}