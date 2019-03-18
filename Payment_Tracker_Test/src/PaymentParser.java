import java.lang.*;

public class PaymentParser {

    // Метод разбиения строки счета на код валюты и сумму.
    public static String[] parsingTheString(String stringForSplitting) {
        String[] str = null;

        if ((stringForSplitting != null) && (!stringForSplitting.isEmpty())) {
            str = stringForSplitting.split(" ");
        }
        return str;
    }
}