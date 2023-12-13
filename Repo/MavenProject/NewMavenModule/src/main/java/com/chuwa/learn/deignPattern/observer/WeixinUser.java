package Repo.MavenProject.NewMavenModule.src.main.java.com.chuwa.learn.deignPattern.observer;

public class WeixinUser implements Observer {
    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

