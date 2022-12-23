import sys
input = sys.stdin.readline

n = int(input())

def hanoi(n, start, sub, end):
        
    # 1번째 칸에 있는 원판들 가장 큰 원판 빼고 2번째 칸으로 모두 옮긴다
    if 1 < n:
        hanoi(n-1, start, end, sub)

    # 1번째 칸에 있는 가장 큰 원판을 목표지점으로 이동
    print(start , end)

    # 가장 큰 원판은 목표에 있으니까 빼고 두번째칸에 있는 원판들을 목표지점으로 전부 옮긴다
    if 1 < n:
        hanoi(n-1, sub, start, end)
    
sum = 1
for i in range(n - 1):
    sum = sum * 2 + 1
print(sum)

hanoi(n, 1, 2, 3)