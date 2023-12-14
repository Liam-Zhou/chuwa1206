package CollectionPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice {
    public static void main(String[] args) {
        // 1.learn_Inserting_And_Retrieving
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list2.add(100);
        list.add(1);
        list.addFirst(1);
        list.add(3, 2);
        list.addAll(list2);
        list.addAll(10, list2);

        list.getFirst();
        list.getLast();
        list.get(2);

        // 2. learn_Inserting_And_Retrieving
        list.removeFirst();
        list.removeLast();
        list.remove(0);
        list.remove(new Integer(3));
        list.removeLastOccurrence(3);
    }
}
