public class PaymentTreckerDemo {
    public static void main(String[] args) {

        PaymentTracker pt = new PaymentTracker(args[0]);

        pt.readerFromFile();
    }
}
