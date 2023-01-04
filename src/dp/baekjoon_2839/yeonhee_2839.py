import sys
input = sys.stdin.readline

# 53796kb	528ms
N = int(input())

# 5a + 3b = N
# a가 row b가 col, 5a + 3b 결과를 검사
max_idx = N // 3 + 1

result = list()
for r in range(max_idx):
    for c in range(max_idx):
        if N == 5*r + 3*c:
            result.append(r+c)

if len(result) == 0:
    print(-1)
else:
    print(min(result))