package Builder;

public class MobileBuilder extends Builder {

    @Override
    public void buildSeat() {
        bike.setSeat("Mobile Seat");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("Mobile Frame");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
