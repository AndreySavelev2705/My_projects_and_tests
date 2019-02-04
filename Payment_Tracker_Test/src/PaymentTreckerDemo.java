public class PaymentTreckerDemo {

    public static void main(String[] args) {

        ThreadOfReadFromFile threadOfReadFromFile = ThreadOfReadFromFile.createAndStart("Поток чтения файла", args[0]);

        ThreadOfWriteToFile threadOfWriteToFile = ThreadOfWriteToFile.createAndStart("Поток записи в файл", args[0], threadOfReadFromFile);

        try {

            Thread.sleep(1000);

        } catch (InterruptedException ie) {

            ie.printStackTrace();
        }

        ThreadOfReadFromConsole threadOfReadFromConsole = ThreadOfReadFromConsole.createAndStart("Поток чтения из консоли", args[0], threadOfWriteToFile);
    }
}