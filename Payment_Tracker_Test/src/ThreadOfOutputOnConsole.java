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

    public void outputOnConsole() {
        for (Account accountList : PaymentTracker.getWriteToFileList()) {

            if (accountList.getBalance() != 0 && accountList.getCurrencyСode().equals("USD"))
                System.out.println(accountList.toString());
            else
            if (accountList.getBalance() != 0) System.out.println(accountList.toString() + " (USD "
                    + String.format("%1.2f", Converter.converter(accountList.getBalance(), 66.44)) + ")");
        }
        System.out.println();
    }

    @Override
    public void run() {
        synchronized (new PaymentTracker()) {
            outputOnConsole();
            thrd.notify();
        }
    }
}