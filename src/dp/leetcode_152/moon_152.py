class Solution(object):
    def maxProduct(self, nums):
        # 초깃값
        answer = max_prod = min_prod = nums[0]

        for i in nums[1:]:
            candidates = [i, i*max_prod, i*min_prod]
            max_prod = max(candidates)
            min_prod = min(candidates)
            answer = max(answer, max_prod)
        
        return answer
