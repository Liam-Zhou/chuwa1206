package DesignPattern.Builder;

public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("Ofo's frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Ofo's seat");

    }
}
