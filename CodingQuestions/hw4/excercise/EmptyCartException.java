package hw4.excercise;

/**
 * @program: CodingQuestions
 * @ClassName EmptyCartException
 * @description:
 * @author: Zhenwei Dai
 **/
public class EmptyCartException extends RuntimeException{
    public EmptyCartException(String message) {
        super(message);
    }
}