package heap.leetcode_703;

import java.io.IOException;
import java.util.PriorityQueue;


public class chan_703 {
    public static void main(String[] args) throws IOException {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println( kthLargest.add(4)); // return 8
    }

    public static class KthLargest {

        private final int k;
        private final PriorityQueue<Integer> nums;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.nums = new PriorityQueue<>();

            for (int num : nums) {
                this.nums.offer(num);
            }
        }

        public int add(int val) {
            nums.offer(val);
            while (nums.size() > k) {
                nums.poll();
            }
            return nums.peek();
        }

    }
}