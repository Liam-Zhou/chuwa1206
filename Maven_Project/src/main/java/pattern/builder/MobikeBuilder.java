package pattern.builder;

/**
 * @program: Maven_Project
 * @ClassName MobikeBuilder
 * @description: concrete constructor for Mobike
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:18
 * @Version 1.0
 **/
public class MobikeBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("Carbon");

    }

    @Override
    public void buildSeat() {
        bike.setSeat("Leather");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}