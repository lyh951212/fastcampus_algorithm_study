from typing import List


def maxProduct(self, nums: List[int]) -> int:
    res = nums[0]
    cur_min, cur_max = 1, 1

    for n in nums:
        tmp = cur_max * n
        cur_max = max(n * cur_max, n * cur_min, n)
        cur_min = min(tmp, n * cur_min, n)
        res = max(res, cur_max)

    return res
