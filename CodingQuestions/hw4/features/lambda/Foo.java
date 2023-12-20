package hw4.features.lambda;

/**
 * @program: CodingQuestions
 * @ClassName Foo
 * @description:
 * @author: Zhenwei Dai
 **/
public interface Foo {
    String aMethod(String string);

    default String defaultBar(){
        String s = "default Bar method";
        System.out.println(s);
        return s;
    }
    default String defaultCommon(){
        String s =  "defaultCommon from Bar";
        System.out.println(s);
        return s;
    }
}