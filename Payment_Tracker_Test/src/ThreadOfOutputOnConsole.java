public class ThreadOfOutputOnConsole implements Runnable {

    private Thread thrd;

    // Конструктор класса потока.
    ThreadOfOutputOnConsole(String nameOfThread) {
        thrd = new Thread(this, nameOfThread);
    }

    // Метод создания и запуска потока.
    public static ThreadOfOutputOnConsole createAndStart(String nameOfThread) {

        ThreadOfOutputOnConsole threadOfOutputOnConsole = new ThreadOfOutputOnConsole(nameOfThread);
        threadOfOutputOnConsole.thrd.start();

        return threadOfOutputOnConsole;
    }

    private void outputOnConsole() {

        for (Account accountList : PaymentTracker.getWriteToFileList()) {

            if (accountList.getBalance() != 0) System.out.println(accountList.toString());
        }
    }

    @Override
    public void run() {

        outputOnConsole();
        System.out.println("\nПожалуйста, введите ниже код валюты и желаемую сумму. " +
                "Для выхода из программы введите \"quit\" \n");
    }
}