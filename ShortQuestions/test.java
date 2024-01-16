import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] array = {0, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        var result = Arrays.stream(array).average().getAsDouble();
        System.out.println("Result: " + result);
    }
    
}
