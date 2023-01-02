class Solution {
public:
    int rob(vector<int>& nums) {
        int answer = 0;
        for (int i = 0; i < nums.size(); i++){
            int max = 0;
            for (int j = 0; j < i - 1; j++){
                if (nums[j] > max){
                    max = nums[j];
                }
            }
            nums[i] += max;
            if (nums[i] > answer)
            answer = nums[i];
        }
        return answer;
    }
    
};
