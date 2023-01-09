# memory usage: 27.5 MB, time usage: 769 ms
from typing import Optional, List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        max_area = 0
        left = 0
        right = len(height) - 1

        while left < right:
            width = right - left
            max_area = max(max_area, min(height[left], height[right]) * width)
            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1

        return max_area

    # brute force time exceed
    # def maxArea(self, height: List[int]) -> int:
    #     max_area = 0
    #
    #     for i in range(len(height)):
    #         for j in range(i + 1, len(height)):
    #             temp_area = (j - i) * min(height[i], height[j])
    #             if max_area < temp_area:
    #                 max_area = temp_area
    #     return max_area

if __name__ == "__main__":
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    solution = Solution()
    print(solution.maxArea(height))
