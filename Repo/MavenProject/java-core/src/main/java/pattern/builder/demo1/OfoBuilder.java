package pattern.builder.demo1;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("aaa");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("bbb");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
