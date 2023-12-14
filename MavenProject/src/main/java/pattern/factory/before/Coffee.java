package pattern.factory.before;

public abstract class Coffee {

    public abstract String getName();
    // 加糖
    public void addSuger() {
        System.out.println("add Suger");
    }

    // 加奶
    public void addMilke() {
        System.out.println("add milk");
    }
}
