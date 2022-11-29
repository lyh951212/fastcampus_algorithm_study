import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  메모리 : 16528 KB
 *  시간 : 156 ms
 * */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 주차 공간들의 단위 무게당 요금과 차량들의 무게를 나타내는 정수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 주차 공간들의 단위 무게당 요금 저장
        int[] fee = new int[N];
        // 차량들의 무게 저장
        int[] weight = new int[M];

        // 주차 공간
        int[] space = new int[N];

        // 공간이 없을 때, 대기할 큐
        Queue<Integer> waitingQueue = new ArrayDeque<>();

        // 주차 공간들의 단위 무게당 요금을 큐에 입력
        for(int i=0; i<N; i++) fee[i] = Integer.parseInt(br.readLine());

        // 차량들의 무게를 배열에 입력
        for(int i=0; i<M; i++) weight[i] = Integer.parseInt(br.readLine());

        // 총 수익
        int money = 0;

        // 차량들의 주차장 출입 순서 입력
        for(int m=0; m<M*2; m++){
            // 차량 번호
            int number = Integer.parseInt(br.readLine());

            boolean flag = false;

            // 주차장에 들어온다면
            if(number > 0){
                // 주차장에 공간이 있는지 탐색
                for(int i=0; i<N; i++){
                    // 공간이 존재하면
                    if(space[i] == 0) {
                        // 주차
                        space[i] = number;
                        flag = true;
                        break;
                    }
                }

            }
            // 주차장에 나간다면
            else {
                number = Math.abs(number);

                // 주차장에서 나갈 차량 번호 탐색
                for(int i=0; i<N; i++){
                    // 발견했다면
                    if(space[i] == number){
                        // 주차장에서 나간 후 계산
                        space[i] = 0;
                        money += (fee[i] * weight[number-1]);
                        flag = true;

                        // 만약, 대기 중인 차량이 존재하면
                        if(!waitingQueue.isEmpty())
                            // 주차
                            space[i] = waitingQueue.poll();
                        break;
                    }
                }
            }

            // 만약 주차장에 공간이 없다면 대기 큐에 저장
            if(!flag) waitingQueue.add(number);
        }

        bw.write(money+"");
        bw.flush();

        bw.close();
        br.close();
    }
}
