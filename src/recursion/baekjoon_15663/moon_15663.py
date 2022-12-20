import sys

# 재귀 함수
def recur(depth):
    # m개를 선택했으면
    if depth == m:
        # set에 tuple로 변환하여 저장
        answer.add(tuple(temp))
        return

    for i in range(n):
        if not flag[i]:
            flag[i] = True
            temp.append(arr[i])
            recur(depth+1)
            temp.pop()
            flag[i] = False


# N과 M 입력
n, m = map(int, sys.stdin.readline().split())

# ex ) 9 7 9 1
arr = list(map(int, sys.stdin.readline().split()))

temp = []
# 모든 원소를 False로 초기화
flag = [False for i in range(n)]
# 중복되는 수열을 제거하기 위해 set 선언
answer = set()

recur(0)

# 정렬된 상태로 출력
for i in sorted(answer):
    print(*i)

"""
    문제 : 15663번 - N과 M (9)
    메모리 : 35032 KB
    시간 : 128 ms
"""
