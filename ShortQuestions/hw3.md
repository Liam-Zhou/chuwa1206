# HW3

## Q1 

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
    	ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    	put(K key, V value);
    	putIfAbsent(K key, V value);
    	putAll(Map<? extends K, ? extends V> m);
    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
    	Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
    	put(K key, V value);
    	putIfAbsent(K key, V value);

    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
    	EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
    	put(K key, V value);
    	putIfAbsent(K key, V value);

    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
    	List<String> myList = new ArrayList<>();
    	myList.add("Apple");
    	myList.add("Banana");
    	String element = myList.get(1);
    	int size = myList.size();

    	List<String> anotherList = new ArrayList<>();
        anotherList.add("Date");
        anotherList.add("Elderberry");

        myList.addAll(anotherList);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
    	List<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Date");
        myList.add("Elderberry");

        // Removing elements
        myList.remove(2); // Removes "Cherry"
        myList.remove("Date");

        // Remove all elements in anotherList from myList
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Apple");
        anotherList.add("Elderberry");
        myList.removeAll(anotherList);

        // Clearing the list
        myList.clear();

        // Repopulating the list for further operations
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        // Update element at index
        myList.set(1, "Blueberry");

        // Replace all elements using UnaryOperator
        UnaryOperator<String> operator = String::toUpperCase;
        myList.replaceAll(operator);

        // Check operations
        boolean containsBanana = myList.contains("BANANA");
        int indexOfBanana = myList.indexOf("BANANA");
        int lastIndexOfBanana = myList.lastIndexOf("BANANA");
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
    	List<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        Iterator<String> iterator = myList.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);

            if ("Banana".equals(element)) {
                iterator.remove();
            }
        }
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
    	List<String> myList = new ArrayList<>();
        myList.add("Cherry");
        myList.add("Banana");
        myList.add("Apple");

        // Sorting the list in natural order
        Collections.sort(myList);

        // Sorting the list in reverse order
        Collections.sort(myList, Comparator.reverseOrder());

    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
    	int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    	numbers[9] = 100;
    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {
    	int[] numbers = { 3, 6, 1, 8, 2, 9, 4 };
        Arrays.sort(numbers); 
        int index = Arrays.binarySearch(numbers, 4);

        int[] numbers2 = { 3, 6, 1, 8, 2, 9, 4 };
        Arrays.sort(numbers2, 1, 5);

        int[] numbers = { 3, 6, 1, 8, 2, 9, 4 };
        Arrays.parallelSort(numbers);
    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {
    	int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Copying the entire array
        int[] copiedNumbers = Arrays.copyOf(numbers, numbers.length);

        // Copying a range of the array (first five elements)
        int[] rangeCopiedNumbers = Arrays.copyOfRange(numbers, 0, 5);
    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {
    	Integer[] numbers = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.asList(numbers);

        int[] numbers1 = { 1, 2, 3, 4, 5 };
        int[] numbers2 = { 5, 4, 3, 2, 1 };

        boolean isEqual = Arrays.equals(numbers1, numbers2);

        int[] numbers3 = new int[5];
        Arrays.fill(numbers3, 20);
    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
    	List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
    	int max = Collections.max(list);
        int freq = Collections.frequency(list, 3);

        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        String min = Collections.min(list, Comparator.comparing(String::length));

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
    	List<Integer> list = new ArrayList<>();

        // Adding elements to the list
        list.add(1);
        list.add(2);
        list.add(3);

        // Creating a synchronized list
        List<Integer> synchronizedList = Collections.synchronizedList(list);

    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
    	List<Integer> list = new CopyOnWriteArrayList<>();

        // add(E e)
        list.add(1); // Adds 1 at the end of the list
        list.add(2); // Adds 2 at the end of the list

        // add(int index, E element)
        list.add(1, 3); // Adds 3 at index 1

        // addAll(Collection c)
        list.addAll(Arrays.asList(4, 5)); // Adds 4 and 5 at the end of the list

        // addIfAbsent(E e)
        list.addIfAbsent(6); // Adds 6 only if it is not already in the list
        list.addIfAbsent(1); // Does not add 1 as it is already in the list

        // addAllAbsent(Collection c)
        list.addAllAbsent(Arrays.asList(7, 2)); // Adds 7 to the list, but not 2 as it's already there

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);

            // Remove "Cherry" from the list
            if ("Cherry".equals(fruit)) {
                iterator.remove(); // Using remove()
            }
        }

    }
}

```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
    	// put(K key, V value)
        map.put("Apple", 50);
        map.put("Banana", 30);

        // putIfAbsent(K key, V value)
        map.putIfAbsent("Cherry", 20);
        map.putIfAbsent("Apple", 60); // This will not change "Apple"'s value

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Date", 40);
        anotherMap.put("Elderberry", 70);
        map.putAll(anotherMap);

        int price = map.get("Apple");

        int defaultPrice = map.getOrDefault("Fig", 10);
       
        boolean hasBanana = map.containsKey("Banana");
        
        boolean hasPrice30 = map.containsValue(30);
       
        Set<String> keys = map.keySet();
       
        Collection<Integer> values = map.values();
  
        boolean isEmpty = map.isEmpty();
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
    	 Map<String, Integer> map = new HashMap<>();

        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Cherry", 20);

        // replace(K key, V oldValue, V newValue)
        boolean isReplaced = map.replace("Banana", 30, 35);

        map.replace("Cherry", 25);

        map.replaceAll((key, value) -> value + 10);

        map.remove("Apple");

        boolean isRemoved = map.remove("Banana", 45);
       
        map.compute("Date", (key, value) -> (value == null) ? 40 : value + 5);

        map.computeIfAbsent("Elderberry", k -> 60);

        map.computeIfPresent("Cherry", (key, value) -> value + 5);

    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
    	Set<Integer> set = new HashSet<>();

        // add(E e)
        set.add(1);
        set.add(2);
        set.add(3);

        // addAll(Collection<?> c)
        set.addAll(Arrays.asList(4, 5, 6));

        // get() - Not applicable for Set as it doesn't have a get method

        // contains(Object o)
        boolean containsTwo = set.contains(2);
        System.out.println("Set contains 2: " + containsTwo);

        // remove(Object o)
        set.remove(3);

        // clear()
        set.clear();

        // isEmpty()
        boolean isEmpty = set.isEmpty();

    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
    	Map<String, Integer> map = new LinkedHashMap<>();

        // put(K key, V value)
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Cherry", 20);

        // putIfAbsent(K key, V value)
        map.putIfAbsent("Date", 40);
        map.putIfAbsent("Apple", 60); // This won't override the existing value for "Apple"

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new LinkedHashMap<>();
        anotherMap.put("Elderberry", 70);
        anotherMap.put("Fig", 10);
        map.putAll(anotherMap);

        int applePrice = map.get("Apple");

        int defaultPrice = map.getOrDefault("Grape", 15);

        boolean hasBanana = map.containsKey("Banana");

        boolean hasPrice20 = map.containsValue(20);

        Set<String> keys = map.keySet();

        Collection<Integer> values = map.values();

        boolean isEmpty = map.isEmpty();

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
    	// Initial map setup
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Cherry", 20);

        // replace(K key, V oldValue, V newValue)
        map.replace("Banana", 30, 35);

        // replace(K key, V value)
        map.replace("Cherry", 25);

        // replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        map.replaceAll((key, value) -> value + 10);

        map.remove("Apple");

        map.remove("Banana", 45);

        // compute(Key, BiFunction)
        map.compute("Date", (key, value) -> (value == null) ? 40 : value + 5);

        // computeIfAbsent(Key, Function)
        map.computeIfAbsent("Elderberry", k -> 60);

        // computeIfPresent(Key, BiFunction)
        map.computeIfPresent("Cherry", (key, value) -> value + 5);

    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {

    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
    	List<Integer> list = new LinkedList<>();

        // add(E e) or addLast(E e)
        list.add(10); // Adds 10 at the end of the list
        ((LinkedList<Integer>) list).addLast(20); // Explicitly adds 20 at the end

        // addFirst(E e)
        ((LinkedList<Integer>) list).addFirst(5); // Adds 5 at the beginning

        // add(int index, E element)
        list.add(1, 15); // Adds 15 at index 1

        // addAll(Collection c)
        List<Integer> anotherList = new LinkedList<>();
        anotherList.add(30);
        anotherList.add(40);
        list.addAll(anotherList); // Adds 30, 40 at the end

        // addAll(int index, Collection c)
        List<Integer> yetAnotherList = new LinkedList<>();
        yetAnotherList.add(25);
        yetAnotherList.add(35);
        list.addAll(2, yetAnotherList); // Adds 25, 35 starting at index 2

        // The list now contains [5, 15, 25, 35, 10, 20, 30, 40]

        int firstElement = list.getFirst(); 
        int lastElement = list.getLast(); 
        int elementAtIndex1 = list.get(1);

    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
    	LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(40);

        // removeFirst()
        list.removeFirst(); // Removes 10

        // removeLast()
        list.removeLast(); // Removes 40

        // remove(int index)
        list.remove(1); // Removes the second element (30)

        // remove(Object o)
        list.remove((Integer) 20); // Removes the first occurrence of 20

        // removeLastOccurrence(Object o)
        list.add(20);
        list.removeLastOccurrence((Integer) 20); // Removes the last occurrence of 20

        // The list now contains [20]
        Collections.sort(list); 
    }

    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
    	TreeMap<String, Integer> map = new TreeMap<>();

        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Cherry", 20);

        // putIfAbsent(K key, V value)
        map.putIfAbsent("Date", 40);
        map.putIfAbsent("Apple", 60); // This will not override the existing value for "Apple"

        // putAll(Map<? extends K, ? extends V> m)
        Map<String, Integer> anotherMap = new TreeMap<>();
        anotherMap.put("Elderberry", 70);
        anotherMap.put("Fig", 10);
        map.putAll(anotherMap);

        int applePrice = map.get("Apple");

        String firstKey = map.firstKey();

        String lastKey = map.lastKey();

        boolean hasBanana = map.containsKey("Banana");

        boolean hasPrice20 = map.containsValue(20);

        var keys = map.keySet();

        var values = map.values();

        boolean isEmpty = map.isEmpty();

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
    	TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Apple", 50);
        map.put("Banana", 30);
        map.put("Cherry", 20);

        map.replace("Banana", 35);

        boolean isReplaced = map.replace("Cherry", 20, 25);
        // This will return true and replace the value if the key "Cherry" currently has the value 20

        map.remove("Apple");
    }
}
```

```
package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
    	TreeSet<Integer> set = new TreeSet<>();

        set.add(10);
        set.add(20);
        set.add(5);

        Set<Integer> anotherSet = new TreeSet<>();
        anotherSet.add(15);
        anotherSet.add(25);
        set.addAll(anotherSet);

        boolean containsTen = set.contains(10);

        int firstElement = set.first(); // Smallest element

        int lastElement = set.last(); // Largest element

        // subSet(E fromElement, E toElement)
        Set<Integer> subSet = set.subSet(10, 20); // Elements ranging from 10 (inclusive) to 20 (exclusive)

        // headSet(E toElement)
        Set<Integer> headSet = set.headSet(15); // Elements less than 15

        // tailSet(E fromElement)
        Set<Integer> tailSet = set.tailSet(15); // Elements greater than or equal to 15

        set.remove(25);

        int size = set.size();

        boolean isEmpty = set.isEmpty();

    }
}
```

## Q2  What is the checked exception and unchecked exception in Java, could you give one example.
- **Checked Exceptions**: All exceptions other than RuntimeException and Error are known as Checked exception. These exceptions are checked by the compiler at the compile time. E.g. `FileNotFoundException`, `SQLException`, `IOException`, etc.

- **Unchecked Exceptions**: Runtime Exceptions are known as Unchecked exceptions. Compiler does not force us to handle these exceptions. E.g. `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundException`, etc.


## Q3 Can there be multiple finally blocks?
You cannot have multiple `finally` blocks associated with a single `try` block, but you can have multiple `finally` blocks if they are associated with different `try` blocks.


## Q4 When both catch and finally return values, what will be the final result?
The return value in `finally` block will be the final result.


## Q5 What is Runtime/unchecked exception? what is Compile/Checked Exception?
- **Checked/Compile Exceptions**: All exceptions other than RuntimeException and Error are known as Checked exception. These exceptions are checked by the compiler at the compile time. E.g. `FileNotFoundException`, `SQLException`, `IOException`, etc.

- **Unchecked/Runtime Exceptions**: Runtime Exceptions are known as Unchecked exceptions. Compiler does not force us to handle these exceptions. E.g. `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundException`, etc.


## Q6 What is the difference between throw and throws?
- `throw` is a keyword which is used to explicitly throw an exception in the program, inside a function or inside a block of code, whereas `throws` is a keyword which is used with the method signature to declare an exception which might get thrown by the method while executing the code

- `throw` keyword is followed by an instance of an Exception class whereas `throws` is followed by Exception class names

- You can `throw` one exception at a time but you can declare multiple exceptions using `throws` keyword

- Using `throw` keyword, only unchecked exceptions are propagated, whereas using `throws` keyword both checked and unchecked exceptions can be propagated.


## Q7 Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception ?

Because `Exception` will catch all exceptions if it is before `Null/Runtime Exception`. In such case, the specific Null/Runtime exception handling code will never be executed and they will cause syntax error. 


## Q7 What is optional? why do you use it? write an optional example.
`Optional` is a container object introduced in Java 8, used to represent a value that is either present or absent. The primary purpose of `Optional` is to provide a type-level solution for representing optional values instead of using `null`. This can help in avoiding `NullPointerException` and improves the readability and maintainability of the code by providing a clear and explicit way to deal with the presence or absence of a value. Example:

```
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Create an Optional object from a non-null value
        Optional<String> optionalValue = Optional.of("Hello World");

        // Check if a value is present
        if (optionalValue.isPresent()) {
            // Get the value
            String value = optionalValue.get();
            System.out.println("Value: " + value);
        }

        // Create an Optional object that may be null
        Optional<String> emptyOptional = Optional.ofNullable(null);

        // Use orElse to provide a default value in case of null
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Default: " + defaultValue);

        // Using functional-style operations
        optionalValue.ifPresent(v -> System.out.println("Value is present: " + v));
    }
}

```

## Q8 Why finally always be executed ?
The `finally` block in Java is designed to be executed always, regardless of what happens in the `try` block or any `catch` blocks that may be associated with it. This consistent execution is guaranteed in several scenarios:

- **Normal Completion**: If the `try` block completes normally, without throwing any exceptions, the `finally` block will be executed after the `try` block.

- **Exception Handled**: If an exception is thrown in the `try` block and is caught in one of the `catch` blocks, the `finally` block will be executed after the corresponding `catch` block.

- **Exception Not Handled**: If an exception is thrown in the `try` block but is not caught (because there are no matching catch blocks or no catch blocks at all), the `finally` block will still be executed before the method exits.

- **Return Statement**: If a return statement is encountered in the `try` or `catch` block, the `finally` block will execute right before the method actually returns.

- **Break, Continue, or Throw**: If a `break`, `continue`, or `throw` statement is used within a `try` or `catch` block, the `finally` block will execute before those statements take effect.

## Q9 Practice Collection problems

## Q10 What are the types of design patterns in Java ?

- **Singleton Pattern**: Ensures that a class has only one instance and provides a global point of access to it.

- **Factory Method Pattern**: Defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.

- **Abstract Factory Pattern**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

- **Strategy Pattern**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

- **Builder Pattern**: Separates the construction of a complex object from its representation, allowing the same construction process to create various representations.

- **Observer Pattern**: Defines a dependency between objects so that when one object changes state, all its dependents are notified automatically.

## Q11 What are the SOLID Principles ?
1. Single Responsibility Principle (SRP)
	- Principle: A class should have one, and only one, reason to change. This means that a class should only have one job or responsibility.
	- Purpose: This principle aims to reduce the complexity of code by ensuring that a class is only focused on doing one thing and therefore has fewer reasons to change. It leads to better organization of code and easier maintenance.
2. Open/Closed Principle (OCP)
	- Principle: Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
	- Purpose: This means you should be able to add new functionality to an entity without changing its existing code. It encourages the use of interfaces or abstract classes to enable making changes without modifying existing code, leading to more robust and less error-prone software.
3. Liskov Substitution Principle (LSP)
	- Principle: Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.
	- Purpose: This principle ensures that a subclass can stand in for its parent class. It leads to correct hierarchy in the inheritance structure and ensures that inherited classes are not overriding the base class's behavior in unexpected ways.
4. Interface Segregation Principle (ISP)
	- Principle: Clients should not be forced to depend on interfaces they do not use.
	- Purpose: This principle encourages creating more specific interfaces rather than general-purpose ones, so clients only need to know about the methods that are of interest to them. It helps in reducing the side effects of changes in code and makes the software easier to refactor.
5. Dependency Inversion Principle (DIP)
	- Principle: High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions.
	- Purpose: This principle promotes the decoupling of software modules, allowing high-level modules to be isolated from the changes in low-level modules. It leads to a codebase that is more resilient to changes and easier to update or maintain.

## Q12 How can you achieve thread-safe singleton patterns in Java ?
- Eager Initialization
- Static Block Initialization
- Lazy Initialization with Synchronization
- Double-Checked Locking (DCL)
- Bill Pugh Singleton Implementation (Initialization-on-demand holder idiom)
- Enum Singleton

## Q13 What do you understand by the Open-Closed Principle (OCP) ?
OCP means that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means you should be able to add new functionality to an entity without changing its existing code. It encourages the use of interfaces or abstract classes to enable making changes without modifying existing code, leading to more robust and less error-prone software.

## Q14 Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.

## Q15 Watch the design pattern video, and type the code, submit it to MavenProject folder.