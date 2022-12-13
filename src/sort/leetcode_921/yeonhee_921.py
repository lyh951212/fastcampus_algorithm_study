# Runtime
# 4555 ms
# Memory
# 22.4 MB

class Solution(object):
    def __init__(self):
        self.sorted = []

    def merge(self, nums, left, mid, right):
        a = left
        b = mid+1
        i = left

        while a<= mid and b <= right:
            if nums[a] <= nums[b]:
                self.sorted[i] = nums[a]
                i+=1
                a+=1
            else:
                self.sorted[i] = nums[b]
                i+=1
                b+=1

        if a > mid:
            for k in range(b, right + 1):
                self.sorted[i] = nums[k]
                i+=1

        else:
            for k in range(a, mid + 1):
                self.sorted[i] = nums[k]
                i+=1

        for k in range(left, right + 1):
            nums[k] = self.sorted[k]

        return nums

    def mergeSort(self, nums, left, right):
        mid = 0
        if left < right:
            mid  = (left+right)//2
            self.mergeSort(nums, left, mid)
            self.mergeSort(nums, mid+1, right)
            self.merge(nums, left, mid, right)

    def sortArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        self.sorted = [0 for i in range(len(nums))]
        self.mergeSort(nums, 0, len(nums)-1)
        return nums


s = Solution()
print(s.sortArray([5,1,1,2,0,0]))
print(s.sortArray([5,2,3,1]))