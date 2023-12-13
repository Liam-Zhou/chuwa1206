public class LazyLoad2 {
    private LazyLoad2() {

    }
    //声明变量,没有赋值,首次使用时才会创建
    private static LazyLoad2 instance;

    //提供访问方式
    public static LazyLoad2 getInstance() {
        //判断instance是否为null
        //如果是null，说明还没创建Singleton类对象
        if (instance == null) {
            instance = new LazyLoad2();
        }
        return instance;
    }
}
