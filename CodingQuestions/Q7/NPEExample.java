package CodingQuestions.Q7;

public class NPEExample {
    public String s;
    public static void main(String[] args) {
        NPEExample npeExample = new NPEExample();
        try {
            System.out.println(npeExample.s.length());
        } catch (NullPointerException e) {
            System.out.println("NPE caught");
        }

    }
}
