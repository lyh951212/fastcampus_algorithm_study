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

    left_index = 0  # 왼쪽 거 인덱스
    right_index = 0  # 오른쪽 거 인덱스
    arr_index = start  # 전체 배열 인덱스

    # 정렬된 왼쪽 오른쪽 배열을 원래 배열에 삽입
    while left_index < len(left) and right_index < len(right):
        if left[left_index] <= right[right_index]:
            arr[arr_index] = left[left_index]
            left_index += 1
        else:
            arr[arr_index] = right[right_index]
            right_index += 1
        arr_index += 1

    # 남은 원소들 삽입
    while left_index < len(left):
        arr[arr_index] = left[left_index]
        left_index += 1
        arr_index += 1

    while right_index < len(right):
        arr[arr_index] = right[right_index]
        right_index += 1
        arr_index += 1