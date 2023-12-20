package hw23.geneics;

public class GenericMultiArguments {
    public static <T1,T2,T3> void solve(T1 a, T2 b, T3 c){
        System.out.println("This is x = " + a);
        System.out.println("This is y = " + b);
        System.out.println("This is z = " + c);
    }

    public static void main(String[] args) {
        solve(1, "2", 'x');
    }
}
