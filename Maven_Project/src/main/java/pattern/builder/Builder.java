package pattern.builder;

/**
 * @program: Maven_Project
 * @ClassName Builder
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:14
 * @Version 1.0
 **/
public abstract class Builder {
    protected Bike bike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract Bike createBike();
}