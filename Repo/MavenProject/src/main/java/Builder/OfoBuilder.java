package Builder;

public class OfoBuilder extends Builder {
    @Override
    public void buildSeat() {
        bike.setSeat("OfoSeat");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("OfoFrame");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
