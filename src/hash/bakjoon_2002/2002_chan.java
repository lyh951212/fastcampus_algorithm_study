import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// 	20916	264
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Integer.parseInt(br.readLine());
        int count = 0;
        Map<String, Integer> in = new HashMap<>();
        Map<String, Integer> out = new HashMap<>();

        for (int i = 0; i < N; i++) {
            in.put(br.readLine(), i);
        }

        for (int i = 0; i < N; i++) {
            out.put(br.readLine(), i);
        }

        for (Map.Entry<String, Integer> outCar : out.entrySet()) {
            int inCarIndex = in.get(outCar.getKey());

            for (Map.Entry<String, Integer> inCar : in.entrySet()) {
                if (inCar.getValue() < inCarIndex) {
                    if (out.get(inCar.getKey()) > outCar.getValue()) {
                        count++;
                        break;
                    }
                }
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}