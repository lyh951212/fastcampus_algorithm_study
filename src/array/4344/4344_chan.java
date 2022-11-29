// memory: 15732KB time: 184 ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // total test case
        int n = Integer.parseInt(br.readLine());

        // initialize result array
        double[] result = new double[n];

        // loop for total case
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int length = Integer.parseInt(st.nextToken());
            int [] temp = new int[length];

            // save grades of each case
            for (int j = 0; j < length; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            // find average of each case
            double sum = 0;
            for(int arg : temp){
                sum += arg;
            }
            double average = sum/length;
            int count = 0;
            for (int arg : temp) {
                if (arg > average) {
                    count++;
                }
            }
            // save the average of each case
            result[i] = (double) count / length * 100;
        }

        // output the result
        for (double res : result) {
            bw.write(String.format("%.3f%%\n", res));
        }
        bw.flush();
        br.close();
        bw.close();

    }
}