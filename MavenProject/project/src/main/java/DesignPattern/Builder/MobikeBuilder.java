package DesignPattern.Builder;

public class MobikeBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("Mobike's frame");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Mobike's seat");

    }
}
