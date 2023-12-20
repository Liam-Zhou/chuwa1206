package Builder;

// https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
public abstract class Builder {
    protected Bike bike = new Bike();
    public abstract void buildSeat();
    public abstract void buildFrame();
    public abstract Bike createBike();
}
