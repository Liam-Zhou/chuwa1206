package MavenProject_designPattern.builder.demo1;


public class MobileBuilder extends Builder {

    public void buildFrame() {
        bike.setFrame("carbone");
    }

    public void buildSeat() {
        bike.setSeat("leather");
    }

    public Bike createBike() {
        return bike;
    }
}
