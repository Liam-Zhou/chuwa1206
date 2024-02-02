package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.sql.Array;
import java.util.*;

class Node{
    String word;
    int dis;

    public Node(String word, int dis) {
        this.word = word;
        this.dis = dis;
    }
}

public class Main {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> lst = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));

        System.out.println(solution(start,end,lst));
    }

    public static int solution(String start, String end, List<String> list) {
        Map<String, List<String>> map = new HashMap<>();
        list.add(end);

        for(int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            for(int j = 0 ;j < word.length(); j++) {
                String newWord = word.substring(0, j) + "*" + word.substring(j + 1);
                List<String> neighbors = map.getOrDefault(newWord, new ArrayList<>());
                neighbors.add(word);
                map.put(newWord, neighbors);
                System.out.println(newWord);
            }
        }


        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 1));
        Set<String> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            String word = node.word;
            int dis = node.dis;


            for(int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);

                for (String neighbor: map.getOrDefault(newWord, new ArrayList<>())) {
//                    System.out.println(neighbor);
                    if(neighbor.equals(end)) {
                        return dis + 1;
                    }
                    if(visited.contains(neighbor)) {
                        continue;
                    }

                    visited.add(neighbor);
                    queue.offer(new Node(neighbor, dis + 1));

                }
            }
        }

        return -1;
}
}
