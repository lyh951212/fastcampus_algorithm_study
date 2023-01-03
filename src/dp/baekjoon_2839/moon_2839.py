import sys

n = int(sys.stdin.readline())

count = 0

# 먼저 n이 5로 나누어 떨어지면 그 몫을 출력
if n%5 == 0:
    print(n//5)
    exit()

# 5로 딱 나누어 떨어지지 않는다면 5로 나눈 몫부터 -1씩 감소하면서 확인
for i in range(n//5, 0, -1):
    value = n - (i*5)  # 5로 나눈 나머지
    if value%3 == 0: # 5로 나눈 나머지가 3으로 나누어 떨어진다면
        answer = i + (value//3) # (5로 나눈 몫) + (3으로 나눈 몫)
        print(answer)
        exit()

# 만약, 여태까지 프로그램 종료가 안되었다면 3으로 나누어 떨어지는 경우가 있기 때문에 3으로 나누어 떨어지는지 확인
if n%3 == 0:
    print(n//3)
    exit()

# 정확하게 n 킬로그램을 만들 수 없다면 -1 출력
print(-1)

"""
    문제 : 2839번 - 설탕 배달
    메모리 : 30616 KB
    시간 : 36 ms
"""

