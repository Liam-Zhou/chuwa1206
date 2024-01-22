package builder;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("1")
                .screen("2")
                .memory("3")
                .mainboard("4")
                .build();
    }
}
