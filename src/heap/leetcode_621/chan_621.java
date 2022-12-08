package heap.leetcode_621;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class chan_621 {

    public static void main(String[] args) throws IOException {
//        char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        System.out.println(leastInterval(tasks, 2));


    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        char maxKey = Collections.max(map.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)).getKey();
        int idleTimeNumber = (map.get(maxKey) - 1) * n;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getKey() != maxKey) {
                idleTimeNumber -= Math.min(entry.getValue(), map.get(maxKey) - 1);
            }
        }

        return idleTimeNumber > 0 ? idleTimeNumber + tasks.length : tasks.length;
    }
}

