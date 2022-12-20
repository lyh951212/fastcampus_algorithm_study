import sys
# 	35940kb,	144ms

res_list = set()
def recursion(nums, m, tmp_list, is_visited):
    if len(tmp_list) == m :
        res_list.add(tuple(tmp_list))
        return

    for idx in range(0, len(nums)):
        if True == is_visited[idx]:
            continue

        tmp_list.append(nums[idx])
        is_visited[idx] = True
        recursion(nums, m, tmp_list, is_visited)
        tmp_list.pop()
        is_visited[idx] = False

n, m = map(int, sys.stdin.readline().rstrip().split())
nums = list(map(int, sys.stdin.readline().split()))
nums.sort()

is_visited = [False for _ in range(10000)]
recursion(nums, m, [], is_visited)

for data in sorted(res_list):
    print(*data)

