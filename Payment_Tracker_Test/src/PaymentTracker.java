import java.util.ArrayList;

public class PaymentTracker {

    private static ArrayList<Account> writeToFileList = new ArrayList<>();

    public static ArrayList<Account> getWriteToFileList() {
        return writeToFileList;
    }

    public static void setWriteToFileList(String currencyСode, int balance) {

        writeToFileList.add(new Account(currencyСode, balance));
    }

}