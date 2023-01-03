# import copy

# class Solution(object):

#     def dfs(self, cur_idx_list, key):
#         not_adj_idxes = self.not_adj_idx_dict.get(key, None)

#         if None == not_adj_idxes or 0 == len(not_adj_idxes):
#             return

#         for v in not_adj_idxes:
#             cur_idx_list.append(v)
#             self.results.append(sum([self.nums[idx] for idx in cur_idx_list]))
#             self.dfs(cur_idx_list, v)
#             cur_idx_list.pop()
            

#     def rob(self, nums):
#         self.nums = nums
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         self.not_adj_idx_dict = dict()
#         for i in range(0, len(nums)):
#             self.not_adj_idx_dict[i] = []

#         for i in range(0, len(nums)-2):
#             for j in range(i+2, len(nums)):
#                 self.not_adj_idx_dict[i].append(j)

#         self.results = list()
#         for i in range(0, len(nums)):
#             self.results.append(nums[i])
#             self.dfs([i], i)

#         return max(self.results)

# 참고한 코드
class Solution:
    def rob(self, nums):
        #  nums의 인덱스인 i가 주어졌을 때의 이익의 최대값을 저장
        dp = [0 for _ in range(len(nums))]
        if not nums:
            return 0
        if len(nums)<=2 : 
            return max(nums)
        dp[0], dp[1]= nums[0], max(nums[0],nums[1])
        for i in range(2,len(nums)):
            # dp[i]는 이번 집을 털지 않는 것(=dp[i-1])과 이번 집을 터는 것(=dp[i-2]+nums[i])중 큰 값이다 
            dp[i] = max(dp[i-1], dp[i-2]+nums[i])
        return dp.pop()


s = Solution()
print(s.rob([2,7,9,3,1]))
s2 = Solution()
print(s2.rob([2,1,1,2]))

s3 = Solution()
print(s3.rob([183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211]))
