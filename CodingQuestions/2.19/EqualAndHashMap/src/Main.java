public class Main {
    public static void main(String[] args) {
        User user1 = new User("frank", 24);
        User user2 = new User("frank", 24);
        System.out.println(user1.equals(user2));



        Customer c1 = new Customer("Frank", 12, new Account(2000));
        Customer c2 = new Customer("Frank", 12, new Account(2000));
        System.out.println(c1.equals(c2));

        Order o1 = new Order(1001, "OrderAA");
        Order o2 = new Order(1001, "OrderAA");
        System.out.println(o1.equals(o2));

        MyDate m1 = new MyDate(1,1,2024);
        MyDate m2 = new MyDate(1,1,2024);
        System.out.println(m1.equals(m2));

        MyDate m3 = new MyDate(1,1,2022);
        MyDate m4 = new MyDate(1,1,2024);
        System.out.println(m3.equals(m4));
    }
}