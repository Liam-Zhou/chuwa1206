package Builder;

// https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());
        Bike bike = director.buildBike();
        System.out.println(bike.getSeat());
        System.out.println(bike.getFrame());
    }
}
