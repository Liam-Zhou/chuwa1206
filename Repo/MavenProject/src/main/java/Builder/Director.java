package Builder;

public class Director {
    Builder builder;
    Director(Builder builder) {
        this.builder = builder;
    }

    public Bike buildBike() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
