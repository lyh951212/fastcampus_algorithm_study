package leetcode_703;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

//Runtime
//49 ms
//Memory
//52.7 MB
class KthLargest {
    PriorityQueue<Integer> pQueue;
    int k;
    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        pQueue = new PriorityQueue<>();
        for(int i = nums.length-1; i >= 0; i--)
        {
            if(pQueue.size() < k)
                pQueue.add(nums[i]);
        }

        this.k = k;
    }
    public int add(int val) {
        if(pQueue.size() < this.k)
            pQueue.add(val);
        else {
            if(pQueue.peek() <= val)
            {
                pQueue.poll();
                pQueue.add(val);
            }
        }

        return pQueue.peek();
    }
}

public class yeonhee_703 {
    public static void main(String[] args){
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
