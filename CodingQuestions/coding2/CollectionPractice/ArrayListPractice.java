package CollectionPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ArrayListPractice {
    public static void main(String[] args) {
        // 1. learn_Inserting_And_Retrieving
        List<Integer> list = new ArrayList<>();
        List<Integer> addList = new ArrayList<>();
        list.add(1);
        addList.add(2);
        System.out.println(list);
        System.out.println(addList);

        System.out.println(list.get(0));

        System.out.println(list.size());

        list.addAll(addList);
        System.out.println(list);

        // 2. learn_Remove_Replacing_Updating
        // 2.1 create

        ArrayList<Integer> list2 = new ArrayList<>();
        List<Integer> removeList = new ArrayList<>();
        list2.add(1);list2.add(2);list2.add(30);list2.add(6);list2.add(7);list2.add(8);removeList.add(2);
        System.out.println(list2);

        list2.remove(new Integer(30));
        System.out.println(list2);

        // list2.removeRange(0, 1);
        list2.removeAll(removeList);
        System.out.println(list2);

        list2.clear();
        System.out.println(list2);

        // 2.1 Update
        list2.add(1);list2.add(2);list2.add(30);list2.add(6);list2.add(7);list2.add(8);list2.add(8);
        list2.set(0, 100);
        System.out.println(list2);
        list2.replaceAll(e -> e * 2);
        System.out.println(list2);

        // 2.3 check
        System.out.println(list2.contains(1));
        System.out.println(list2.indexOf(4));
        System.out.println(list2.lastIndexOf(16));

        // 3. learn_Iterator
        // sort in ascending order
        list2.sort((o1, o2) -> o1 - o2);
        System.out.println(list2);

        Collections.sort(list2);
        System.out.println(list2);

        list2.sort(Comparator.reverseOrder());
        System.out.println(list2);
    }
}
