public class SingletonEager {
    // 1. private static
    private static SingletonEager instance = new SingletonEager();

    // 2. make constructor be private

    private SingletonEager() {}


    //3. get instance(static)
    public static SingletonEager getInstance(){
        return instance;
    }
}
