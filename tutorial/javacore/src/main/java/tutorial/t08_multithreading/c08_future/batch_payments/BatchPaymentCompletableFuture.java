package tutorial.t08_multithreading.c08_future.batch_payments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static tutorial.t08_multithreading.c08_future.batch_payments.OrderProcessUtil.*;

public class BatchPaymentCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> orderIds = Arrays.asList("order1", "order2", "order3");
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CompletableFuture<Order>> orderFutures = new ArrayList<>();
        for (String orderId : orderIds) {
            CompletableFuture<Order> future = CompletableFuture.supplyAsync(() -> queryOrder(orderId), executorService);
            orderFutures.add(future);
        }

        List<CompletableFuture<Void>> emailFutures = new ArrayList<>();
        for (CompletableFuture<Order> orderFuture : orderFutures) {

            CompletableFuture<Void> future = orderFuture
                    .thenApplyAsync(OrderProcessUtil::makePayment, executorService)
                    .thenAcceptAsync(paymentResult -> sendEmail(orderFuture.join(), paymentResult), executorService);
            emailFutures.add(future);
        }

        CompletableFuture.allOf(emailFutures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
    }

}
