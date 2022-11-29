package array.leetcode_Remove_Duplicates;
import java.util.*;

class leet26_yeonhee {
    public int removeDuplicates(int[] nums) {
        int curValue = nums[0];
        int curIdx = 1;

        for(int i = 1; i < nums.length; ++i)
        {
            if(curValue != nums[i])
            {
                nums[curIdx++]  = nums[i];
                curValue        = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return curIdx;
    }
}
// 	13 ms,	48 MB
