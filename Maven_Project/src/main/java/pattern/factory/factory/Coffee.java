package pattern.factory.factory;

/**
 * @program: Maven_Project
 * @ClassName Coffee
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-13 19:47
 * @Version 1.0
 **/
public abstract class Coffee {
    public  abstract String getName();
    public void addSugar(){
        System.out.println("add sugar");
    }

    public void addMilk(){
        System.out.println("add milk");
    }

}