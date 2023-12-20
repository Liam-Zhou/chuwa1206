package hw23.singleton;

public class ThreadSafeSingleton {
    private static final class ThreadSafeHolder{
        private static final ThreadSafeSingleton holder=new ThreadSafeSingleton();
    }

    private ThreadSafeSingleton(){}

    public ThreadSafeSingleton getInstance(){
        return ThreadSafeHolder.holder;
    }
}
