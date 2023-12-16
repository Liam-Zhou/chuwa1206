public class Main {

    public static void testSingleton(){
        System.out.println("---------------------");
        System.out.println("Testing Singleton");
        Singleton s1=Singleton.getSingleton();
        System.out.println("Singleton name: "+s1.name);
        Singleton s2=Singleton.getSingleton();
        System.out.println("Singleton name: "+s2.name);
    }
    public static void testFactory(){
        System.out.println("---------------------");
        System.out.println("Testing Factory");
        AbstractProduct pA=new FactoryA().produceProduct();
        pA.produce();
        AbstractProduct pB=new FactoryB().produceProduct();
        pB.produce();
    }

    public static void testBuilder(){
        System.out.println("---------------------");
        System.out.println("Testing Builder");
        Job greatJob=new GreatJobBuilder().setName("Apple SDE").setSalary(100000).build();
        Job rubbishJob=new RubbishJobBuilder().setName("Amazon SDET").setSalary(80000).build();
        System.out.println(greatJob.getName()+"  "+greatJob.getSalary());
        System.out.println(rubbishJob.getName()+"  "+rubbishJob.getSalary());
    }

    public static void testPublished_Subscriber(){
        System.out.println("---------------------");
        System.out.println("Testing Published_Subscriber");
        NewsPublisher publisher=new NewsPublisher();
        UserSubscriber s1=new UserSubscriber("User1");
        UserSubscriber s2=new UserSubscriber("User2");
        publisher.subscribe(s1);
        publisher.subscribe(s2);
        publisher.publishNews("News 1");
        publisher.unsubscribe(s1);
        publisher.publishNews("News 2");
    }
    public static void main(String[] args) {
        testSingleton();
        testFactory();
        testBuilder();
        testPublished_Subscriber();
    }
}