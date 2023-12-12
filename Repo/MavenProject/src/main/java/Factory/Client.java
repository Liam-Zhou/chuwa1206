package Factory;

// https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
public class Client {

    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop();
        Coffee coffee = coffeeShop.orderCoffee("Latte");
        System.out.println(coffee.getName());
    }



}
