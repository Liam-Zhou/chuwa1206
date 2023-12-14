package pattern.builder;

/**
 * @program: Maven_Project
 * @ClassName OfoBuilder
 * @description:Ofo Builder
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:20
 * @Version 1.0
 **/
public class OfoBuilder extends Builder{

    @Override
    public void buildFrame() {
        bike.setFrame("Aluminum");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("Rubber");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}