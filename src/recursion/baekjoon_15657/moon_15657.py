import sys

# 재귀 함수
def recur(depth):
    # m개를 선택했으면
    if len(temp) == m:
        # 저장된 원소 출력
        print(*temp)
        return

    # depth ~ n 까지 반복
    for i in range(depth, n):
        temp.append(arr[i])
        recur(i)
        temp.pop()

# N과 M 입력
n, m = map(int, sys.stdin.readline().split())

# ex ) 9 8 7 1
arr = list(map(int, sys.stdin.readline().split()))

# 리스트 오름차순 정렬 (1 7 8 9)
arr.sort()

temp = []

recur(0)

"""
    문제 : 15657번 - N과 M (8)
    메모리 : 30616 KB
    시간 : 56 ms
"""
