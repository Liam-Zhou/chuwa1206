package pattern.builder.demo1;

public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("Alloy");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Rubber");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
