package CollectionPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetPractice {
    public static void main(String[] args) {
        // learn_Inserting_And_Retrieving_Removing
        Set<Integer> set = new HashSet<>();

        set.add(1);
        List<Integer> num = new ArrayList<>();
        num.add(2);num.add(3);
        set.addAll(num);

        System.out.println(set.contains(1));
        System.out.println(set.remove(2));

        set.clear();

        System.out.println(set.isEmpty());
    }
}
