import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();
        List<String> names = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 0; i < N + M ; i++) {
            String name = br.readLine();
            if (i < N) {
                map.put(name, 1);
            }

            if (i >= N) {
                if (map.containsKey(name)) {
                    ++count;
                    names.add(name);
                }
            }
        }

        Collections.sort(names);
        bw.write(count+"\n");
        for (String name : names) {
            bw.write(name+"\n");
        }

        bw.flush();
        bw.close();
        br.close();


    }


}