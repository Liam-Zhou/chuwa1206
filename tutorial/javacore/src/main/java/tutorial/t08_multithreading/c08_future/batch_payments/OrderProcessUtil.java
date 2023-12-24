package tutorial.t08_multithreading.c08_future.batch_payments;

public class OrderProcessUtil {
    public static Order queryOrder(String orderId) {
        return new Order(orderId, 100.0);
    }

    public static boolean makePayment(Order order) {
        return true;
    }

    public static void sendEmail(Order order, boolean paymentResult) {
    }
}
