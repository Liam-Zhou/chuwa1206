/**
 * @Description: double-lock
 */
public class LazyLoad1 {
    //private constructor to prevent instantiation from outside the class
    private LazyLoad1() {
    }

    static{
        // do something
    }

    //static inner class to hold the Singleton instance
    private static class SingletonHolder {
        private static final LazyLoad1 INSTANCE = new LazyLoad1();
    }

    //public static method to get the Singleton instance
    public static LazyLoad1 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
