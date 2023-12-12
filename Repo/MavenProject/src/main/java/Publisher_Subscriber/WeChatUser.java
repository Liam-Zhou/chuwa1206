package Publisher_Subscriber;

public class WeChatUser implements Observer {

    private final String name;

    WeChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
