public class PaymentTreckerDemo {

    public static void main(String[] args) {

        CreateThreads.createThrd(args[0]);

        while (true) {
            ReadFromConsole.readFromConsole();
        }
    }
}