package Builder;

public class OfoBuilder extends Builder {
    @Override
    public void buildSeat() {
        bike.setSeat("ofo seat");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("ofo frame");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
