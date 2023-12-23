import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class PrintSumProduct {

    public static void main(String[] args) throws Exception{
        CompletableFuture<String> c = CompletableFuture.supplyAsync(PrintSumProduct::getSumAndProduct);
        c.thenAccept((result) -> {
            System.out.println(result);
        });
        c.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        //主线程不能立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭
        Thread.sleep(1000);
    }

    static String getSumAndProduct() {
        int a = 2;
        int b = 6;
        return "sum is " + (a + b) + " and the product is " + (a * b);
    }
}
