package Repo.MavenProject.NewMavenModule.src.main.java.com.chuwa.learn.deignPattern.observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message);
}
