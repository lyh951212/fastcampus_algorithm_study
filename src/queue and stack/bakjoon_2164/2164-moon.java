package bakjoon_2164;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 메모리 : 45724 KB
 * 시간 : 196 ms
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수 입력
        int N = Integer.parseInt(br.readLine());

        // 큐 선언
        Queue<Integer> queue = new LinkedList<>();

        // 1부터 N까지 큐에 저장
        for(int i=1; i<=N; i++) { queue.add(i); }

        // 큐에 정수가 1개 남아있을 때까지 반복
        while(queue.size() > 1) {
            // 먼저 가장 앞에 있는 정수 제거
            queue.poll();

            // 비어 있지 않다면, 앞에 있는 정수를 가장 끝으로 옮긴다.
            if(!queue.isEmpty()) queue.add(queue.poll());
        }

        // 마지막으로 남아있는 정수 출력
        bw.write(queue.peek() + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
