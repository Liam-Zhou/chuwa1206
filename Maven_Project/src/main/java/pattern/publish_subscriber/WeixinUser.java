package pattern.publish_subscriber;

/**
 * @program: Maven_Project
 * @ClassName WeixinUser
 * @description:concrete Observer
 * @author: Zhenwei Dai
 * @create: 2023-12-13 23:29
 * @Version 1.0
 **/
public class WeixinUser implements Observer{
    public WeixinUser(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}