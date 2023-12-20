package Repo.MavenProject.NewMavenModule.src.main.java.com.chuwa.learn.deignPattern.builder;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
