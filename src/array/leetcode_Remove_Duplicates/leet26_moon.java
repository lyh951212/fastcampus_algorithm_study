/**
* Memory : 47 MB
* Runtime : 2 ms
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        // 중복된 요소를 제외한 배열의 개수 및 위치
        int k = 0;
        
        // i와 j의 위치를 같이 옮겨가면서 탐색
        for(int i=0, j=1; i<nums.length-1; i++){
            // i 인덱스와 j 인덱스의 값들이 같지 않다면(중복이 아니면)
            if(nums[i] != nums[j]){
                // 중복된 요소를 제외한 배열 개수 count 
                k++;
                // k 인덱스에 j 인덱스의 값을 저장
                // 왜? k 인덱스에는 중복된 요소가 저장되어 있을 것이기 때문에,
                // 뒤에 있는 값을 앞으로 옮기기 위해
                nums[k] = nums[j];
               
            }
            j++;
        }
        
        return k+1;
    }
}
