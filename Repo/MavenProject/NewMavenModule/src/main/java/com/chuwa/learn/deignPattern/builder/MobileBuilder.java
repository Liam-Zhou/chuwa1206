package Repo.MavenProject.NewMavenModule.src.main.java.com.chuwa.learn.deignPattern.builder;

public class MobileBuilder extends Builder {
    public void buildFrame() {
        bike.setFrame("构建车框架");
    }

    public void buildSeat() {
        bike.setSeat("真皮车坐");
    }

    public Bike createBike() {
        return bike;
    }
}
