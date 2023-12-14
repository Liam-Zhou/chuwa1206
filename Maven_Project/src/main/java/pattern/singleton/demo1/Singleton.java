package pattern.singleton.demo1;

/**
 * @program: Maven_Project
 * @ClassName Singleton
 * @description:eagerload: static instance variables
 * @author: Zhenwei Dai
 * @Version 1.0
 **/
public class Singleton {
    //1.private constructor
    private Singleton(){}

    //2. create Singleton obj in this class
    private static Singleton instance = new Singleton();

    //3. provide a public access method, let user get the object
    public static Singleton getInstance(){
        return instance;
    }

}