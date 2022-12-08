package heap.leetcode_703;

import java.util.PriorityQueue;

public class moon_703 {
    public static void main(String[] args) {

    }

}
class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;

        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if(pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);

        while(pq.size() > k) pq.poll();

        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
