package hw23.geneics;

import java.util.Comparator;

public class GenericMethod {
    public static <T extends Comparable<T>> T maximum(T a1,T a2,T a3){
        T temp=a1.compareTo(a2)>0?a1:a2;
        return (temp).compareTo(a3)>0?temp:a3;
    }

    public static void main(String[] args) {
        System.out.println(maximum("3","2","1"));
        System.out.printf("Max of %.1f,%.1f and %.1f is %.1f\n\n", 6.6, 8.8, 7.7,
                maximum(6.6, 8.8, 7.7));
        System.out.printf("Max of %s, %s and %s is %s\n", "pear", "apple", "orange",
                maximum("pear", "apple", "orange"));
    }
}
