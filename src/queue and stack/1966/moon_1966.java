import java.io.*;
import java.util.*;

/**
 *  메모리 : 15136 KB
 *  시간 : 168 ms
 * */
class Documents {
    // 문서 번호, 중요도
    int idx, importance;

    public Documents(int idx, int importance){
        this.idx = idx;
        this.importance = importance;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 문서의 개수 입력
            int N = Integer.parseInt(st.nextToken());
            // 현재 큐에서 몇 번째로 놓여있는지를 나타내는 정수 입력
            int M = Integer.parseInt(st.nextToken());

            // 큐 선언
            Queue<Documents> queue = new ArrayDeque<>();
            // 우선순위 큐로 입력받은 문서의 중요도를 내림차순으로 정렬
            PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            // N개 문서의 중요도 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                int imp = Integer.parseInt(st.nextToken());
                // 큐와 우선순위 큐에 각각 입력
                queue.add(new Documents(i, imp));
                pq.add(imp);
            }

            // 문서가 몇 번째로 인쇄되는지 count
            int count = 1;

            while(true){
                /* 중요도가 높은 순으로 정렬된 우선순위 큐와 입력받은 순서대로 저장된 큐의
                   중요도가 일치할 때까지 큐에서 데이터를 뺐다 넣었다를 반복
                */
                while(pq.peek() != queue.peek().importance) queue.add(queue.poll());

                // 큐에 있는 문서 번호와 찾으려고 하는 문서 번호와 일치하면 종료
                if(queue.peek().idx == M) break;

                // 찾으려고 하는 문서 번호를 발견하지 못했기 때문에 두 큐에서 데이터 삭제
                pq.poll(); queue.poll();
                
                count++;
            }
            bw.write(count+"\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
