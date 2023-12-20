package hw4.generic;

import hw4.generic.GenericClass;

/**
 * @program: CodingQuestions
 * @ClassName GenericClassTest
 * @description:
 * @author: Zhenwei Dai
 * @create: 2023-12-18 15:08
 * @Version 1.0
 **/
public class GenericClassTest {
    public static void main(String[] args) {
        GenericClass<Integer> obj1 = new GenericClass<>(5);
        System.out.println(obj1.getObj());

        GenericClass<Double> obj2 = new GenericClass<>(15.777755);
        System.out.println(obj2.getObj());

        GenericClass<String> obj3 = new GenericClass<>("Generic");
        System.out.println(obj3.getObj());
    }
}