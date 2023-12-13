public class MobikeBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Tan");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Pi");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
