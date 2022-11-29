package array.bakjoon2566;

import java.io.*;
import java.util.StringTokenizer;

/*
    메모리 : 16204 KB
    시간 : 156 ms
*/
public class moon_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));

        // 9 * 9 배열 생성
        int[][] arr = new int[9][9];

        // 배열 값 입력
        for(int i=0; i<9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 최댓값, 행과 열의 위치
        int max = 0; int row = 0; int col = 0;

        // 배열에서 최댓값 탐색
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                // max 값보다 크다면
                if(max < arr[i][j]){
                    // 최댓값 갱신
                    max = arr[i][j];
                    // 행 위치 갱신
                    row = i;
                    // 열 위치 갱신
                    col = j;
                }
            }
        }

        // 최댓값과 행과 열의 위치 출력
        bw.write(max+"\n");
        bw.write((row+1)+" "+(col+1));
        bw.flush();

        bw.close();
        br.close();
    }
}
