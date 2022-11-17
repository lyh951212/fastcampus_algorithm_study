import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Memory usage : 17844 kB Time Usage : 192 ms
// 깔끔하게 고치고 싶은데 고치기 싫네요
class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        List<Pair> apples = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            apples.add(new Pair(row, col));
        }


        int L = Integer.parseInt(br.readLine());

        Map<Integer, String> history = new HashMap<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int timeStamp = Integer.parseInt(st.nextToken()) + 1;
            String direction = st.nextToken();
            history.put(timeStamp, direction);
        }

        Deque<Pair> snake = new ArrayDeque<>();
        int time = 0;
        int row = 1;
        int col = 1;

        snake.addFirst(new Pair(row, col));

        int headDirection = 0; // 0 right 1 down 2 left 3 up

        while (true) {
            ++time;
            if (history.containsKey(time)) {
                if (history.get(time).equals("D")) {
                    ++headDirection;
                    if (headDirection == 4) {
                        headDirection = 0;
                    }
                } else {
                    --headDirection;
                    if (headDirection < 0) {
                        headDirection = 3;
                    }
                }
            }

            if (headDirection == 0) {
                ++col;
            } else if (headDirection == 1) {
                ++row;
            } else if (headDirection == 2) {
                --col;
            } else {
                --row;
            }

            if (!checkApple(apples, snake, row, col)) {
                break;
            }

            if (hitTheWall(row, col, N)) {
                break;
            }

        }
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean checkApple(List<Pair> apples, Deque<Pair> snake, int row, int col) {
        boolean foundApple = false;

        for (Pair apple : apples) {
            if (apple.row == row && apple.col == col) {
                foundApple = true;
                apples.remove(apple);
                break;
            }
        }

        if (foundApple) {
            snake.addLast(new Pair(row, col));
        } else {
            snake.addLast(new Pair(row, col));
            if (hitTheSnake(snake)) {
                return false;
            } else {
                snake.pop();
            }
        }
        return true;
    }

    public static boolean hitTheSnake(Deque<Pair> snake) {
        int size = snake.size();
        int count = 0;
        Pair head = snake.getLast();
        for (Pair o : snake) {
            if (count < size - 2) {
                if (head.row == o.row && head.col == o.col) {
                    return true;
                }
            }
            ++count;
        }
        return false;
    }

    public static boolean hitTheWall(int x, int y, int N) {
        if (x > N || x < 1) {
            return true;
        } else if (y > N || y < 1) {
            return true;
        } else {
            return false;
        }
    }

}