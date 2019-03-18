public class Converter {

    // Конвертация в доллары по курсу по умолчанию.
    public static double converter(long balance, double exchangeRate) {
        double result = (balance / exchangeRate);
        return result;
    }
}