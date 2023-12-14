package pattern.singleton.demo2;

/**
 * @program: Maven_Project
 * @ClassName Singleton
 * @description: eagerload: static block
 * @author: Zhenwei Dai
 * @create: 2023-12-13 16:38
 * @Version 1.0
 **/
public class Singleton {

    //private constructor
    private Singleton(){}

    //declare Singleton instance
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    //3. provide a public access method, let user get the object

    public static Singleton getInstance(){
        return instance;
    }
}