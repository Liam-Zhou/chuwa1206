package Singleton;

public class SingletonLazyImplement {
    public static void main(String[] args) {
        Singleton2 singleton2 = Singleton2.getSingleton();
        Singleton2 singleton2Test = Singleton2.getSingleton();
        System.out.println(singleton2 == singleton2Test);
    }
}


// lazy way
class Singleton2 {
    private static Singleton2 singleton;
    private Singleton2 (){}


    public static Singleton2 getSingleton() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
// Thread safety
//class Singleton2 {
//    private static Singleton2 singleton;
//    private Singleton2 (){}
//
//
//    public static synchronized Singleton2 getSingleton() {
//        if (singleton == null) {
//            singleton = new Singleton2();
//        }
//        return singleton;
//    }
//}

// double check Thread safety
//class Singleton2 {
//    private static Singleton2 singleton;
//    private Singleton2 (){}
//
//    public static volatile Singleton2 getSingleton() {
//        if (singleton == null) {
//            synchronized (Singleton2.class) {
//                if (singleton == null) {
//                    singleton = new Singleton2();
//                }
//            }
//        }
//        return singleton;
//    }
//}

// static inner class
//class Singleton2 {
//    private Singleton2 (){}
//
//    private static class SingletonHolder {
//        private static final Singleton2 INSTACNE = new Singleton2();
//    }
//
//    public static synchronized Singleton2 getSingleton() {
//        return SingletonHolder.INSTACNE;
//    }
//}

// Enum

