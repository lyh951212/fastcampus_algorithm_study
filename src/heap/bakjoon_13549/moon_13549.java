package heap.bakjoon_13549;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/***
 * 메모리 : 22592 KB
 * 시간 : 228 ms
 */
class Node implements Comparable<Node>{
    int location, time;

    public Node(int location, int time){
        this.location = location;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}
public class moon_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈이의 현재 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(N, 0));

        // 이동한 위치 true, false 표시
        boolean[] flag = new boolean[100001];
        int count = Integer.MAX_VALUE;

        while(!pq.isEmpty()){
            Node node = pq.poll();

            // 동생을 발견했다면 최솟값 갱신
            if(node.location == K) count = Math.min(count, node.time);

            // 이동한 위치를 true로 표시 -> 다시 방문하지 않기 위해
            flag[node.location] = true;

            // 순간 이동
            if(node.location*2 <= 100000 && !flag[node.location*2]){
                pq.add(new Node(node.location*2, node.time));
            }

            // x+1
            if(node.location+1 <= 100000 && !flag[node.location+1]) {
                pq.add(new Node(node.location+1, node.time+1));
            }

            // x-1
            if(node.location-1 >= 0 && !flag[node.location-1]) {
                pq.add(new Node(node.location-1, node.time+1));
            }
        }

        bw.write(count+"");
        bw.flush();

        bw.close();
        br.close();

    }
}
