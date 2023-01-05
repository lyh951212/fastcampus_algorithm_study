class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int n = nums.size();

        int answer = INT_MIN;

        int min_prod = 1;
        int max_prod = 1;

        for (int i = 0; i < n; i++) {
            int cur1 = max_prod * nums[i];
            int cur2 = min_prod * nums[i];

            max_prod = max({ cur1, cur2, nums[i] });
            min_prod = min({ cur1, cur2, nums[i] });

            answer = max(answer, max_prod);
        }
        return answer;
    }
};
