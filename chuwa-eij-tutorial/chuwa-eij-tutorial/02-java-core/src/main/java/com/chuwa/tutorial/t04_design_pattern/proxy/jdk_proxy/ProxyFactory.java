package com.chuwa.tutorial.t04_design_pattern.proxy.jdk_proxy;

import java.lang.reflect.Proxy;

/**
 * @author ylyu
 * @version 1.0
 * @date 1/5/22 11:09 PM
 */
public class ProxyFactory {

    private final TrainStation station = new TrainStation();

    public SellTickets getProxyObject() {
        //使用Proxy获取代理对象
        /*
            newProxyInstance()方法参数说明：
            ClassLoader loader ： 类加载器，用于加载代理类，使用真实对象的类加载器即可
            Class<?>[] interfaces ： 真实对象所实现的接口，代理模式真实对象和代理对象实现相同的接口
            InvocationHandler h ： 代理对象的调用处理程序
        */
        return (SellTickets) Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("代理点收取一些服务费用(JDK动态代理方式)");
                    return method.invoke(station, args);

                }
//                new InvocationHandler() {
//                    /*
//                        InvocationHandler中invoke方法参数说明：
//                        proxy ： 代理对象
//                        method ： 对应于在代理对象上调用的接口方法的 Method 实例
//                        args ： 代理对象调用接口方法时传递的实际参数
//                    */
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("代理点收取一些服务费用(JDK动态代理方式)");
//                        return method.invoke(station, args);
//                    }
//                }
        );
    }
}
