import sys
input = sys.stdin.readline

# 53796kb	528ms
N = int(input())

# 5a + 3b = N
# a가 row과 b가 col이 2차원 배열을 만들고 각 배열값에는 5a + 3b결과가 들어간다
max_idx = N // 3 + 1
arr = [[ 0 for c in range(max_idx)] for r in range(max_idx)]

result = list()
for r in range(max_idx):
    for c in range(max_idx):
        if N == 5*r + 3*c:
            result.append(r+c)

if len(result) == 0:
     print(-1)
else:
    print(min(result))