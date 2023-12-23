package t08_multithreading.c08_future.batch_payments;

import java.util.Arrays;
import java.util.List;

import static t08_multithreading.c08_future.batch_payments.OrderProcessUtil.*;
public class BatchPayment {
    public static void main(String[] args) {
        List<String> orderIds = Arrays.asList("order1", "order2", "order3");

        for (String orderId : orderIds) {
            Order order = queryOrder(orderId);
            boolean paymentResult = makePayment(order);
            sendEmail(order, paymentResult);
        }
    }



}

