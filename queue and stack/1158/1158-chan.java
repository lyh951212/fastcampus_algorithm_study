import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> people = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            people.add(i + 1);
        }

        while (people.size() != 0) {
            for (int i = 0; i < K - 1; i++) {
                people.addLast(people.pop());
            }
            result.add(people.pop());
        }

        bw.write("<");
        for (int i = 0; i < result.size(); i++) {
            if (i != result.size() - 1) {
                bw.write(result.get(i) + ", ");
            } else {
                bw.write(String.valueOf(result.get(i)));
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();
    }
}