package array.bakjoon4344;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 메모리 : 15596 KB
 * 시간 : 176 ms
 */
public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 만큼 반복
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 학생의 수 입력
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];

            // 점수 총합
            int sum = 0;

            // N명의 점수 입력, 그리고 점수의 총합 계산
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }

            // 평균 값
            double avg = sum / N;

            // 평균을 넘는 학생들의 수
            int count = 0;

            // 평균을 넘는 학생들의 수 탐색
            for(int i=0; i<N; i++){
                if(arr[i] > avg) count++;
            }

            // 평균을 넘는 학생들의 비율 출력
            bw.write(String.format("%.3f", ((double) count/N)*100)+"%"+"\n");

        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
