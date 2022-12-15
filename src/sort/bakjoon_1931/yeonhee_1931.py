import sys

# 46120kb	232ms
n = int(sys.stdin.readline())
time_list = list()

for _ in range(n):
    (a,b) = tuple(map(int, sys.stdin.readline().split()))
    time_list.append((a,b))

# 회의 시작 기준 정렬 -> 끝난 기준 정렬
time_list = sorted(time_list, key = lambda x: x[0])
time_list = sorted(time_list, key = lambda x: x[1])


prev_end_time = time_list[0][1]
count = 1
for idx in range(1, len(time_list)):
    (s,e) = time_list[idx]
    # 뒤에 있는 회의 시작시간보다 현재 회의의 끝나는 시간이 늦으면
    if prev_end_time > s:
        continue
    count+=1
    prev_end_time = e

print(count, end="")


