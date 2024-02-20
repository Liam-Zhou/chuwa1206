package hashMap;

import java.util.HashMap;

/**
 * @author Alex D.
 */
public class MapExer {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(31, "张三");
        map.put(31, "李四");
        map.put(47, "王五");
        map.put(45, "赵六");
    }

}
