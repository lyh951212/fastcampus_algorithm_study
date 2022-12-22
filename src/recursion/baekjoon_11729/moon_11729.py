import sys

# 재귀 함수
def recur(num, one, two, three):
    if num == 0:
        return

    recur(num-1, one, three, two)
    print(one, three)
    recur(num-1, two, one, three)

# 장대에 쌓인 원판의 개수
n = int(sys.stdin.readline())

# 옮긴 횟수
count = pow(2, n) -1

print(count)

# 재귀 함수 호출
recur(n, 1, 2, 3)

"""
    문제 : 11729번 - 하노이 탑 이동 순서
    메모리 : 30616 KB
    시간 : 960 ms
"""




