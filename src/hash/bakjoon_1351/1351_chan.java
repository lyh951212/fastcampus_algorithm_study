import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 14276	132

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong((st.nextToken()));
        long Q = Long.parseLong((st.nextToken()));

        Map<Triplet, Long> map = new HashMap<>();
        System.out.println(calculate(N, P, Q, map));

    }

    public static class Triplet {
        long x;
        long y;
        long z;

        public Triplet(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triplet triplet = (Triplet) o;

            if (x != triplet.x) return false;
            if (y != triplet.y) return false;
            return z == triplet.z;
        }

        @Override
        public int hashCode() {
            int result = (int) (x ^ (x >>> 32));
            result = 31 * result + (int) (y ^ (y >>> 32));
            result = 31 * result + (int) (z ^ (z >>> 32));
            return result;
        }
    }

    public static long calculate(long N, long P, long Q, Map<Triplet, Long> map) {
        if (N == 0) {
            return 1;
        }

        Triplet input = new Triplet(N, P, Q);
        long first = (long) Math.floor((double) N / P);
        long second = (long) Math.floor((double) N / Q);

        long firstResult = 0;
        long secondResult = 0;

        Triplet firstKey = new Triplet(first, P, Q);
        Triplet secondKey = new Triplet(second, P, Q);

        if (map.containsKey(firstKey)) {
            firstResult = map.get(firstKey);
        } else {
            firstResult = calculate(first, P, Q, map);
        }

        if (map.containsKey(secondKey)) {
            secondResult = map.get(secondKey);
        } else {
            secondResult = calculate(second, P, Q, map);
        }
        map.put(input, firstResult + secondResult);
        return firstResult + secondResult;
    }

}


