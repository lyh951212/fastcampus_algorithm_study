package heap.bakjoon_11286;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class moon_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연산의 개수
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                // 두 정수의 절댓값이 같을 때
                if(Math.abs(o1)==Math.abs(o2))
                    // 작은 값을 먼저 정렬
                    return o1.compareTo(o2);
                // 두 정수의 절댓값을 비교하여 오름차순 정렬
                return (int) (Math.abs(o1) - Math.abs(o2));
            }
        });

        for(int i=0; i<N; i++){
            long value = Integer.parseInt(br.readLine());

            // 우선순위 큐가 비어있고 value 값이 0이면 0출력
            if(priorityQueue.isEmpty() && value==0) bw.write(0+"\n");
                // 우선순위 큐가 비어있지 않고 value 값이 0이면 가장 작은 값 출력
            else if(value==0) bw.write(priorityQueue.poll()+"\n");
                // 그 외에는 값 저장
            else priorityQueue.add(value);
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
