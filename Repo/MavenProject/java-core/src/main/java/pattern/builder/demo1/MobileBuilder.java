package pattern.builder.demo1;

public class MobileBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("xxx");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("yyy");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
