package MavenProject.Builder;

public class MobileBuiler extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("carbon fiber frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("plastic seat");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
