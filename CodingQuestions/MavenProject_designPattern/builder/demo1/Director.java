package MavenProject_designPattern.builder.demo1;


public class Director {

    //声明builder类型的变量
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //组装自行车的功能
    public Bike construct() {
        //注意这里是bike每次build都是不同的bike, 因为每次client都是newDirector newXXBuilder
        builder.getBikeReference();
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
