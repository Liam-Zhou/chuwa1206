package PublishSubscriber;

public class userObserver implements Observer{

    private String username;

    public userObserver(String name) {
        this.username = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println(username + " - " + message);
    }
}
