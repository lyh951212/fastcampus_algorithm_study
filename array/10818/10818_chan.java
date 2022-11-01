import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Integer max = list.stream()
                .max(Comparator.comparing(x -> x))
                .orElseThrow(NoSuchElementException::new);

        Integer min = list.stream()
                .min(Comparator.comparing(x -> x))
                .orElseThrow(NoSuchElementException::new);

        bw.write(min + " " + max);

        bw.flush();
        br.close();
        bw.close();

        System.exit(0);
    }
}

// 204208 KB 1252 ms
