package Coding;

import java.util.concurrent.Callable;

public class CalllableTest {


    public static void main(String[] args) {

        Callable<Integer>myCallble = new Callable() {
            @Override
            public Integer call() throws Exception {

                int sum = 0;
                for(int i =0;i<10;i++){

                    sum+=i;
                }

                return sum;
            }
        };

        try{

            System.out.println(myCallble.call());
        }catch (Exception e){

            e.printStackTrace();
        }



    }




}
