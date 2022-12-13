from typing import List

# 2079 ms 22,2 MB
class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return merge_sort(nums, 0, len(nums))


def merge_sort(arr, start, end):
    if end - start + 1 <= 1:
        return arr

    # 중간에 있는 인덱스 받기
    mid = (start + end) // 2

    # 중간 기준으로 왼쪽에 있는 거 정렬
    merge_sort(arr, start, mid)

    # 중간을 기준으로 오른쪽에 있는 거 정렬
    merge_sort(arr, mid + 1, end)

    # 정렬된 왼쪽거 오른쪽 거 병합
    merge(arr, start, mid, end)

    return arr


def merge(arr, start, mid, end):
    # 정렬된 왼쪽 오른쪽 거 복사
    left = arr[start: mid + 1]
    right = arr[mid + 1: end + 1]

    i = 0  # 왼쪽 거 인덱스
    j = 0  # 오른쪽 거 인덱스
    k = start  # 전체 배열 인덱스

    # 정렬된 왼쪽 오른쪽 배열을 원래 배열에 삽입
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            arr[k] = left[i]
            i += 1
        else:
            arr[k] = right[j]
            j += 1
        k += 1

    # 남은 원소들 삽입
    while i < len(left):
        arr[k] = left[i]
        i += 1
        k += 1

    while j < len(right):
        arr[k] = right[j]
        j += 1
        k += 1