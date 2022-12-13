import sys
n = int(input())

arr = []
for i in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

arr.sort(key=lambda x:(x[0], x[1]))

for i, j in arr:
    print(i, j)

"""
  시간 : 388 ms
  메모리 : 58624 KB
"""
