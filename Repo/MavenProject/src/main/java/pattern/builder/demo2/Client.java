package pattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("Intel")
                .memory("Kingston")
                .motherBoard("ASUS")
                .screen("Samsung")
                .build();
        System.out.println(phone);
    }
}
