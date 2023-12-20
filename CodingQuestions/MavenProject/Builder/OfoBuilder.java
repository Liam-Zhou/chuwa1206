package MavenProject.Builder;

public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("wood");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("wood seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
