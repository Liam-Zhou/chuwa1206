package CollectionPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPractice {
    public static void main(String[] args) {
        // learn_Inserting_And_Retrieving_Removing
        TreeSet<Integer> set= new TreeSet<>();
        set.add(1);
        List<Integer> array = new ArrayList<>();
        array.add(1);array.add(2);array.add(3);
        set.addAll(array);

        System.out.println(set.contains(2));

        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.subSet(1, 3));
        System.out.println(set.headSet(2));
        System.out.println(set.tailSet(2));

        set.remove(2);

        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
