package heap.bakjoon_13549;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class chan_13549 {


    static class Pair {
        int position;
        int time;

        public Pair(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        Scanner scanner = new Scanner(System.in);
        boolean[] visited = new boolean[100001];

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        queue.add(new Pair(n, 0));

        while (true) {
            Pair pair = queue.poll();
            visited[pair.position] = true;

            if (pair.position == k) {
                System.out.println(pair.time);
                break;
            }

            if (pair.position * 2 <= 100000 && !visited[pair.position * 2]) {
                queue.add(new Pair(pair.position * 2, pair.time));
            }

            if (pair.position + 1 <= 100000 && !visited[pair.position + 1]) {
                queue.add(new Pair(pair.position + 1, pair.time + 1));
            }

            if (pair.position - 1 >= 0 && !visited[pair.position - 1]) {
                queue.add(new Pair(pair.position - 1, pair.time + 1));
            }

        }
    }
}

