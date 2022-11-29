import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// 백준에서는 큰 값을 N으로 넣어주지 않아서 시간 차이는 크게 나지 않았음.
// 내 맥북에서 N 값을 10000000로 주고 돌려보니 LinkedList는 2452ms ArrayDeque는 284ms 
// 거의 8-9배의 성능차이를 보여줌

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        Queue<Integer> cards = new ArrayDeque<>(); // 29212KB 204 ms
        Queue<Integer> cards = new LinkedList<>(); // 45708KB 196 ms
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
