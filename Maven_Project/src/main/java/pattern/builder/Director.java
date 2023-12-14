package pattern.builder;

/**
 * @program: Maven_Project
 * @ClassName Director
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:21
 * @Version 1.0
 **/
public class Director {
    private Builder builder;

    public Director(Builder builder){
        this.builder = builder;
    }

    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}