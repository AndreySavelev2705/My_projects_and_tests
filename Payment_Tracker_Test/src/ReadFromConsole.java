import java.io.*;

public class ReadFromConsole {

    public static void readFromConsole() {
        String stringFromConsole = "";

        BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));

        try {
            stringFromConsole = bufferedReaderFromConsole.readLine();

            if (!stringFromConsole.equals("quit")) PaymentParser.splitString(stringFromConsole);
            else System.exit(0);

        } catch (IOException e) {
            System.out.println("Простите, но Вы ввели что-то не то.");
        }
    }
}