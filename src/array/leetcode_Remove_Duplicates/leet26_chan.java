package array.leetcode_Remove_Duplicates;
// Runtime: 2 ms Memory Usage: 47.6 MB

class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count] = nums[i+1];
                count++;
            }
        }
        return count;
    }
}
