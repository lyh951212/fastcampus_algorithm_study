"""
    Runtime : 1656 ms
    Memory : 23.1 MB
"""
class Solution(object):
    def sortArray(self, nums):
        if len(nums) < 2:
                return nums

        mid = len(nums) / 2
        pivot_left = nums[:mid]
        pivot_right = nums[mid:]

        left = self.sortArray(pivot_left)
        right = self.sortArray(pivot_right)
        
        return self.mergeSort(left, right)
        
    # 병합 정렬
    def mergeSort(self, left, right):
        sorted_list = []
        i, j = 0, 0

        while i < len(left) and j < len(right):
            if left[i] <= right[j]:
                sorted_list.append(left[i])
                i += 1
            else:
                sorted_list.append(right[j])
                j += 1
        
        while i < len(left):
            sorted_list.append(left[i])
            i += 1
        
        while j < len(right):
            sorted_list.append(right[j])
            j += 1
        
        return sorted_list




    
