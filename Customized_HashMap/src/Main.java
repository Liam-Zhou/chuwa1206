public class Main {

    public static void main(String[] args) {
	// write your code here
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println(map.get("a")); // 输出 1
        System.out.println(map.get("b")); // 输出 2
        System.out.println(map.get("c")); // 输出 3

        map.remove("b");
        System.out.println(map.get("b")); // 输出 null，因为已经移除了键 "b"

        Employee e1 = new Employee(1, "Mike", "IT", 1000);
        Employee e2 = new Employee(2, "Paul", "IT", 1200);
        Employee e3 = new Employee(3, "Peter", "IT", 1300);

        MyHashMap<Employee, Integer> map2 = new MyHashMap<>();

        map2.put(e1, 1);
        map2.put(e2, 2);
        map2.put(e3, 3);

        System.out.println(map2.get(e1)); // 输出 1
        System.out.println(map2.get(e2)); // 输出 2
        System.out.println(map2.get(e3)); // 输出 3

        map2.put(e1, 5);
        System.out.println(map2.get(e1)); // 输出 5
        map2.remove(e1);
        System.out.println(map2.get(e1)); // 输出 null
    }
}
