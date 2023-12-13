public abstract class Builder {
    //声明bike类型的变量并赋值
    protected Bike bike = new Bike();
    public abstract void buildFrame();
    public abstract void buildSeat();

    //构建自行车的方法
    public abstract Bike createBike();
}
