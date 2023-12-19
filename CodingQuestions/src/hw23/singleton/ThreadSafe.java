package hw23.singleton;

public class ThreadSafe {
    private static volatile ThreadSafe instance;

    private ThreadSafe(){}

    public static ThreadSafe getInstance(){
        if(instance==null){
            synchronized (ThreadSafe.class){
                if(instance==null){
                    instance=new ThreadSafe();
                }
            }
        }
        return instance;
    }
    
    public void solve(){
        System.out.println("test");
    }
}
