public class ofoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("LV");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("XI");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
