import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromConsole {

    public static void readFromConsole()  {
        String stringFromConsole = "";

        BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                stringFromConsole = bufferedReaderFromConsole.readLine();

                if (!stringFromConsole.equals("quit")) {
                    PaymentTracker.addNewElement(PaymentParser.parsingTheString(stringFromConsole));
                    System.out.println();
                }
                else {
                    bufferedReaderFromConsole.close();
                    System.exit(0);
                }
            } catch (IOException e) {
                System.out.println("Простите, но Вы ввели что-то не то.");
            }
        }
    }
}