package array.bakjoon4344;

import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < c; ++i)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            // 배열에 성적 채워넣기
            int sum = 0;
            int[] arr = new int[n];
            for(int j = 0 ; j < n; ++j)
            {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            // 평균
            float avg = (float)sum / n;
            // 성적이 평균보다 높은 학생수
            int avgOverStudentCnt = 0;
            for(int p : arr) {
                if (avg < p)
                    avgOverStudentCnt++;
            }

            float ratio = (float)avgOverStudentCnt / n;
            bw.write(String.format("%.3f%%", ratio*100) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
// 	15604kb,	180ms
