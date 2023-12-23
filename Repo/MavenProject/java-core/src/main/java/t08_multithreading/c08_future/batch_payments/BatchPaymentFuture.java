package t08_multithreading.c08_future.batch_payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static t08_multithreading.c08_future.batch_payments.OrderProcessUtil.*;

public class BatchPaymentFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> orderIds = Arrays.asList("order1", "order2", "order3");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<Order>> orderFutures = new ArrayList<>();
        for (String orderId : orderIds) {
            Future<Order> future = executorService.submit(() -> queryOrder(orderId));
            orderFutures.add(future);
        }

        List<Future<Boolean>> paymentFutures = new ArrayList<>();
        for (Future<Order> orderFuture : orderFutures) {
            Order order = orderFuture.get();
            Future<Boolean> future = executorService.submit(() -> makePayment(order));
            paymentFutures.add(future);
        }
        for (int i = 0; i < paymentFutures.size(); i++) {
            boolean paymentResult = paymentFutures.get(i).get();
            sendEmail(orderFutures.get(i).get(), paymentResult);
        }

        executorService.shutdown();

    }

}
