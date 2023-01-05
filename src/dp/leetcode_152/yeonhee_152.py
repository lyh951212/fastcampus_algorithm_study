from functools import reduce

# class Solution(object):
#     def maxProduct(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         dp = [0 for i in range(len(nums))]
#         dp[0] = nums[0]
        
#         tmp = []
#         for i in range(1, len(dp)):
#             for j in range(i,-1, -1):
#                tmp.append(reduce(lambda x, y: x * y, nums[j:i+1])) 
#             dp[i] = max(dp[i-1], max(tmp))

#         return dp.pop()


class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_prod, min_prod, ans = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            x = max(nums[i], max_prod * nums[i], min_prod * nums[i])
            y = min(nums[i], max_prod * nums[i], min_prod * nums[i])
            max_prod, min_prod = x, y
            ans = max(max_prod, ans)
        return ans

s = Solution()
print(s.maxProduct([2,3,-2,4]))
print(s.maxProduct([-2,0,-1]))
print(s.maxProduct([2,-5,-2,-4,3]))
print(s.maxProduct([3,-2,-3,-3,1,3,0]))