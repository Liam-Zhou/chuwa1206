public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobikeBuilder());

        //让指挥者指挥
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
