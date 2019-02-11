public class PaymentTreckerDemo {

    public static void main(String[] args) {

        ThreadOfReadFromFile threadOfReadFromFile = ThreadOfReadFromFile.createAndStart("Поток чтения файла", args[0]);

        try {
            threadOfReadFromFile.thrd.join();

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

        ThreadOfOutputOnConsole threadOfOutputOnConsole = ThreadOfOutputOnConsole.createAndStart("Поток вывода на косоль", threadOfReadFromFile);

        while (true) {
            ReadFromConsole.readFromConsole();
        }
    }
}