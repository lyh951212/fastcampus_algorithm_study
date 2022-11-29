package bakjoon_2078;

import java.io.*;
import java.util.StringTokenizer;

/**
 *  메모리 : 18692 KB
 *  시간 : 1148 ms
 * */
public class moon_2078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        while(A!=1 || B!=1){
            if(A>B) {
                left++;
                A -= B;
            } else {
                right++;
                B -= A;
            }
        }

        bw.write(left+" "+right);
        bw.flush();

        bw.close();
        br.close();
    }
}
