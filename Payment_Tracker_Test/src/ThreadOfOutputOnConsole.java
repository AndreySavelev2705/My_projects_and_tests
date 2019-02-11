import java.util.concurrent.TimeUnit;

public class ThreadOfOutputOnConsole implements Runnable {

    Thread thrd;
    ThreadOfReadFromFile threadOfReadFromFile;

    // Конструктор класса потока.
    ThreadOfOutputOnConsole(String nameOfThread, ThreadOfReadFromFile threadOfReadFromFile) {
        thrd = new Thread(this, nameOfThread);
        this.threadOfReadFromFile = threadOfReadFromFile;
    }

    // Метод создания и запуска потока.
    public static ThreadOfOutputOnConsole createAndStart(String nameOfThread, ThreadOfReadFromFile threadOfReadFromFile) {

        ThreadOfOutputOnConsole threadOfOutputOnConsole = new ThreadOfOutputOnConsole(nameOfThread, threadOfReadFromFile);
        threadOfOutputOnConsole.thrd.start();

        return threadOfOutputOnConsole;
    }

    public void outputOnConsole() {
        for (Account accountList : PaymentTracker.getWriteToFileList()) {

            if (accountList.getBalance() != 0) System.out.println(accountList.toString() + "*");
        }
    }

    @Override
    public void run() {

        if (!threadOfReadFromFile.thrd.isAlive()) {

            while (true) {

                outputOnConsole();
                System.out.println("\nПожалуйста, введите ниже код валюты и желаемую сумму. Для выхода из программы введите \"quit\" \n");
                try {
                    TimeUnit.SECONDS.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}