public class Client {
    public static void main(String[] args) {
        DIMImpl dia = new DIMImpl();
        System.out.println("Override method: " + dia.add(1, 2));
        System.out.println("default method:" + dia.substract(1, 2));
        System.out.println("static metod: " + DIML.blogName());
    }
}
