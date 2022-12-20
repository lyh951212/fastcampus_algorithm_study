import sys
# 	30616kb,	56ms
def recursion(nums, m, tmp_list, cur_idx):
    if len(tmp_list) == m :
        print(*tmp_list)
        return

    for idx in range(cur_idx, len(nums)):
        tmp_list.append(nums[idx])
        recursion(nums, m, tmp_list, idx)
        tmp_list.pop(len(tmp_list)-1)


n, m = map(int, sys.stdin.readline().rstrip().split())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()
recursion(nums, m, list(), 0)

