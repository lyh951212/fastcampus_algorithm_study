import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  메모리 : 16188 KB
 *  시간 : 312 ms
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 사람 수 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 큐 선언
        Queue<Integer> queue = new ArrayDeque<>();

        // 1부터 N까지 큐에 저장
        for(int i=1; i<=N; i++) queue.add(i);

        bw.write("<");
        // queue가 하나만 남을 때까지 반복
        while(queue.size()>1){
            // K번째 전까지 큐에서 삭제 후 삽입
            for(int i=0; i<K-1; i++) queue.add(queue.poll());

            // K번째 출력
            bw.write(queue.poll()+", ");
        }

        // 큐에 남은 마지막 정수 출력
        bw.write(queue.poll()+">");
        bw.flush();

        bw.close();
        br.close();
    }
}
