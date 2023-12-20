package pattern.singleton.demo3;

/**
 * @program: Maven_Project
 * @ClassName Singleton
 * @description: Lazyload : thread safe
 * @author: Zhenwei Dai
 * @create: 2023-12-13 16:43
 * @Version 1.0
 **/
public class Singleton {
    private Singleton(){};

    private static Singleton instance;
    public static synchronized Singleton getInstance(){
        //instance == null?
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}