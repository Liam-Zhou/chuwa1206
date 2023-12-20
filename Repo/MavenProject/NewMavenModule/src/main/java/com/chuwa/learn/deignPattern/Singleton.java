package com.chuwa.learn.deignPattern;


public class Singleton {
    //lazy init, static member
     static class EagerInit {
        private EagerInit() {

        }
        //保证线程安全
        private static EagerInit instance = new EagerInit();

        public static EagerInit getInstance() {
            return instance;
        }
    }

    //static block
    static class EagerInit1 {
         private EagerInit1() {

         }
         private static EagerInit1 instance;

         static {
             instance = new EagerInit1();
         }

        public static EagerInit1 getInstance() {
            return instance;
        }
    }

    //lazy
    static class LazyInit {
         private LazyInit() {

         }
         private static LazyInit instance;

         private static LazyInit getInstance() {
             if (instance == null) {
                 instance = new LazyInit();
             }
             return instance;
         }
    }

    //lazy double check
    static class A {
        private static volatile A instance;
        private A() {}
        public static A getInstance() {
            if (instance == null) {
                synchronized(A.class) {
                    if (instance == null) {
                        instance = new A();
                    }
                }
            }
            return instance;
        }
    }

    //static nested class, 静态内部类是不会提前被加载的， 之后被加载的时候才调用，静态属性被static 修饰，保证只被实例化一次，保证线程安全
    public static EagerInit getInstance() {
         return EagerInit.getInstance();
    }

}
