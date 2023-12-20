package designPattern.builder;

public class MobileBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Carbon fiber");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
