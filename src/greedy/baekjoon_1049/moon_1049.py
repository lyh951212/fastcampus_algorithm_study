import sys
import math

# 끊어진 기타줄 개수와 기타줄 브랜드 개수 입력
n, m = map(int, sys.stdin.readline().split())

answer = 0
min_package, min_single = sys.maxsize, sys.maxsize

# 각 브랜드 패키지 가격(6개)과 낱개 가격 입력
# 패키지 최소 가격과 낱개 최소 가격을 각각 저장
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    min_package, min_single = min(min_package, a), min(min_single, b)

# 먼저, 입력으로 주어진 n을 패키지 최소 가격으로 모두 구매했을 때 가격과 낱개로 모두 구매했을 때 가격 중 최솟값을 저장
answer = min(math.ceil(n/6)*min_package, n*min_single)

# 패키지와 낱개로 혼합해서 구매했을 때, 가격을 최소로 할 수 있기 때문에 탐색
# 패키지를 최대한 구매하고 낱개로 구매할 수 있을 때까지 반복
for i in range(1, math.ceil(n/6)):
    # 패키지와 낱개로 혼합해서 샀을 때의 가격과 비교하여 최솟값 저장
    answer = min(answer, (min_package*i)+(min_single*(n-(i*6))))

print(answer)

"""
    문제 : 1049번 - 기타줄
    메모리 : 32540 KB
    시간 : 36 ms
"""


