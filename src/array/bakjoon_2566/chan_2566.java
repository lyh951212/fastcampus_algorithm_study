package array.bakjoon2566;

import java.io.*;
import java.util.StringTokenizer;

public class chan_2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int n = 9;
        int row = 1;
        int col = 1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int number = Integer.parseInt(st.nextToken());
                if (number > max) {
                    max = number;
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(row + " " + col);

        bw.flush();
        br.close();
        bw.close();
    }
}

// 15936 KB	144 ms
