import java.io.*;

public class ReadFromConsole {

    public static void readFromConsole() {

        String stringFromConsole = "";

        BufferedReader bufferedReaderFromConsole = new BufferedReader(new InputStreamReader(System.in));

        try {
            stringFromConsole = bufferedReaderFromConsole.readLine();

            //System.out.println("Пожалуйста, введите ниже код валюты и желаемую сумму. Для выхода из программы введите \"quit\"");

            if (!stringFromConsole.equals("quit")) PaymentParser.splitString(stringFromConsole);
            else System.exit(0);

        } catch (IOException e) {

            System.out.println("Простите, но Вы ввели что-то не то.");
        }
    }
}