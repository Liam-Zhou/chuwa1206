package multithreading.Future.BatchPayments;

public class OrderProcessUtil {
    public static Order queryOrder(String orderId) {
        // Query order from database or other source
        return new Order(orderId, 100.0);
    }

    public static boolean makePayment(Order order) {
        // Process payment for the order
        return true;
    }

    public static void sendEmail(Order order, boolean paymentResult) {
        // Send email notification based on the payment result
    }
}
