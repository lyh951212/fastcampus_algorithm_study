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
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        Deque<Integer> numberQueue = new ArrayDeque();

        st = new StringTokenizer(br.readLine());

        List<Integer> TargetList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            TargetList.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            numberQueue.add(i);
        }

        while (!TargetList.isEmpty()) {
            int target = TargetList.get(0);
            boolean done = true;
            while (done) {
                if (target == numberQueue.peek()) {
                    TargetList.remove(0);
                    numberQueue.pop();
                    done = false;
                } else if (moreIntoLeft(numberQueue, target)) {
                    moveToLeft(numberQueue);
                    count++;
                } else {
                    moveToRight(numberQueue);
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }

    public static void moveToLeft(Deque deque) {
        deque.addLast(deque.pop());
    }

    public static void moveToRight(Deque deque) {
        deque.addFirst(deque.removeLast());
    }

    public static boolean moreIntoLeft(Deque deque, int num) {
        List<Integer> list = new ArrayList<>(deque);

        if (list.indexOf(num) < Math.ceil((double) list.size() / 2)) {
            return true;
        } else {
            return false;
        }
    }
}
