package com.chuwa.learn.pubsub;

public class Subscriber implements Observer {

    private String name;
    private Subject topic;

    public Subscriber(String nm){
        this.name=nm;
    }
    @Override
    public void update() {
        String msg = (String) topic.getUpdate(this);
        if(msg == null){
            System.out.println(name+":: No new message");
        }else
            System.out.println(name+":: Consuming message::"+msg);
    }

    @Override
    public void setSubject(Subject sub) {
        this.topic=sub;
    }

    public static void main(String[] args) {
        //create subject
        MyTopic topic = new MyTopic();

        //create observers
        Observer obj1 = new Subscriber("Obj1");
        Observer obj2 = new Subscriber("Obj2");
        Observer obj3 = new Subscriber("Obj3");

        //register observers to the subject
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);


        //check if any update is available
        obj1.update();

        //now send message to subject
        topic.postMessage("New Message");
        topic.postMessage("another one");
    }

}
