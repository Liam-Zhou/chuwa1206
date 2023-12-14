package MavenProject_designPattern.builder.demo1;


public class OfoBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("Aluminum alloy frame");
    }

    public void buildSeat() {
        bike.setSeat("Rubber saddle");
    }

    public Bike createBike() {
        return bike;
    }
}
