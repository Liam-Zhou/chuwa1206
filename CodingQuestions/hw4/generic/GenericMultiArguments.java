package hw4.generic;

/**
 * @program: CodingQuestions
 * @ClassName GenericMultiArguments
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-18 15:15
 * @Version 1.0
 **/
public class GenericMultiArguments {
    public static <T1, T2, T3> void temp(T1 x, T2 y, T3 z){
        System.out.println("This is x = " + x);
        System.out.println("This is y = " + y);
        System.out.println("This is z = " + z);

    }

    public static void main(String[] args) {
        temp(1,"2",33333333333333333L);
    }

}