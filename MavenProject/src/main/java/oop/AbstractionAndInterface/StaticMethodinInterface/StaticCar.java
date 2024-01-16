package oop.AbstractionAndInterface.StaticMethodinInterface;

public class StaticCar implements StaticVehicle {
    /**
     * uncomment Override, will gave compile error.
     *
     * Question: if no Override, this cleanVehicle is same with the one in interface?
     * @Override是必须写的么？ if no, 不写的弊端是什么？
     */
//    @Override
    public void cleanVehicle() {
        System.out.println("Cleaning the vehicle");
    }

    public static void main(String args[]) {
        StaticCar car = new StaticCar();
        car.cleanVehicle();
    }
}
