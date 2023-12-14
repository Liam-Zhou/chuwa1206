package MavenProject_designPattern.builder.demo1;


public class Client {
    public static void main(String[] args) {
        //创建指挥者对象
        Director director1 = new Director(new MobileBuilder());
        Director director2 = new Director(new MobileBuilder());
        //让指挥者只会组装自行车
        Bike bike1 = director1.construct();
        Bike bike2 = director2.construct();

        System.out.println(bike1.getFrame());
        System.out.println(bike1.getSeat());


        System.out.println(bike1 == bike2);
        System.out.println(bike2.getFrame());
        System.out.println(bike2.getSeat());
    }
}
