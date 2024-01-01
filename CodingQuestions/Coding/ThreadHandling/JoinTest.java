package Coding.ThreadHandling;

public class JoinTest {
    public static void main(String[] args) {


        Thread t = new Thread(()->{
            try {
                System.out.println("T starts");
                Thread.sleep(5000);
                System.out.println("T end!");
            }
            catch (InterruptedException e){

                e.printStackTrace();
            }
        });

        t.start();


        try{

            System.out.println("Main start !");
            t.join();
            System.out.println("T ends right now");
            Thread.sleep(5000);
            System.out.println("Main end !");
        }
        catch (InterruptedException e){

            e.printStackTrace();
        }


    }
}