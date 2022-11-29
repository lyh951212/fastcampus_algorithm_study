package array.bakjoon_10818;

import java.io.*;
import java.util.StringTokenizer;

/*
    메모리 : 92108 KB
    시간 : 536 ms
*/
public class moon_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정수의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // N 크기의 배열 생성
        int[] arr = new int[N];

        // N개의 정수 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 최댓값과 최솟값
        int max = arr[0];
        int min = arr[0];

        for(int i=0; i<N; i++){
            // 최댓값 갱신
            if(max < arr[i]) max = arr[i];
            // 최솟값 갱신
            if(min > arr[i]) min = arr[i];
        }

        // 최댓값과 최솟값 출력
        bw.write(min + " " + max);
        bw.flush();

        bw.close();
        br.close();
    }
}
