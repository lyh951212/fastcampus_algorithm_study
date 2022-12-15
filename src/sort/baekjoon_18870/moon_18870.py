import sys

# 좌표 개수 입력
n = int(sys.stdin.readline())

arr = []
# 좌표 입력 ( 2 4 -10 4 -9 )
arr = list(map(int, sys.stdin.readline().split()))

# -10 -9 2 4 4
sorted_arr = sorted(arr)

d = {}
answer = 0

for i in range(n):
    if sorted_arr[i] not in d : # d에 오름차순으로 정렬된 배열 원소가 없다면
        d[sorted_arr[i]] = answer # key 값을 원소로, value 값을 answer로 저장
        answer += 1

# d = [-10:0, -9:1, 2:2, 4:3]
for i in range(n):
    print(d.get(arr[i]), end=" ")


"""
    메모리 : 149792 KB
    시간 : 2088 ms
"""



