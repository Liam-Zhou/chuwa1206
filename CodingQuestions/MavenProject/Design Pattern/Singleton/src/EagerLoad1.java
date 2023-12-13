/**
 * @Description: 静态成员变量
 */
public class EagerLoad1 {
    //1. make constructor be private
    private EagerLoad1() {

    }
    //2. private static variable
    private static EagerLoad1 instance = new EagerLoad1();

    //3. static getInstance method
    public static EagerLoad1 getInstance() {
        return instance;
    }
}
