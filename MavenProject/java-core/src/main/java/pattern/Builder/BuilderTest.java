package pattern.Builder;

public class BuilderTest {
    public static void main(String[] args) {
        Builder builder = new MobileBuilder();
        Director director = new Director(builder);
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
        System.out.println(bike.getTire());
    }
}
