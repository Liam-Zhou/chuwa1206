package MavenProject_designPattern.builder.demo1;


public abstract class Builder {

    //声明Bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    public void getBikeReference () {
        System.out.println(bike);
    }

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();
}
