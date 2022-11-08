import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Deque<Integer> cards = new ArrayDeque<>(); // 236 ms
        Queue<Integer> cards = new LinkedList<>(); // 188 ms

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            cards.add(i+1);
        }

        while (cards.size() > 1) {
            cards.poll();
            cards.add(cards.poll());
        }

        bw.write(String.valueOf(cards.peek()));
        bw.flush();
        bw.close();
        br.close();

    }
}