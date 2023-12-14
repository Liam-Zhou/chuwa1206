package pattern.singleton.demo5;

/**
 * @program: Maven_Project
 * @ClassName Singleton
 * @description: Lazy Load : static inner class
 * @author: Zhenwei Dai
 * @create: 2023-12-13 17:35
 * @Version 1.0
 **/
public class Singleton {
    private Singleton(){}

    //declare static inner class
    private static class SingletonHolder{
        //declare and initialize Singleton obj
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

}