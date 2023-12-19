public class SingletonLazy {
    private SingletonLazy(){}
    private SingletonLazy instance;

    // hold singleton instance
    private static class SingletonHolder {
        private static final SingletonLazy INSTANCE = new SingletonLazy();
    }
    public static SingletonLazy getInstance(){
        return SingletonHolder.INSTANCE;

    }
}
