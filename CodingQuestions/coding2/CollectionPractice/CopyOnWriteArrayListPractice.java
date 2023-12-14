package CollectionPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListPractice {
    public static void main(String[] args) {
        // 1. learn_Inserting_And_Retrieving
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
        List<Integer> list2 = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        list.add(0, 3);
        list.addAll(list2);
        list.addIfAbsent(5);
        list.addAllAbsent(list2);

        // 2. learn_Iterator
        List<String> array = new CopyOnWriteArrayList<>();
        array.add("Apple");
        array.add("Banana");
        array.add("Orange");
        Iterator<String> itr = array.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            itr.remove();
        }

    }
}
