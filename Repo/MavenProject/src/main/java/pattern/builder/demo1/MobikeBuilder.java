package pattern.builder.demo1;

public class MobikeBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("carbon fiber");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("leather");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
