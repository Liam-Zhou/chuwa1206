package designPattern.builder;

public class CarbonBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Carbon");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("carbon seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
