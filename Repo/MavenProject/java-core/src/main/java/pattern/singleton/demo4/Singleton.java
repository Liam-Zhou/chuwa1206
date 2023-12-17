package pattern.singleton.demo4;

public class Singleton {

    private Singleton(){}

    private static volatile Singleton instance;

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
