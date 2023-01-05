import sys

# 계단의 개수
n = int(sys.stdin.readline())

score = []

# 각 계단에 쓰여 있는 점수 입력
# ex) 10 20 15 25 10 20
for i in range(n):
    score.append(int(sys.stdin.readline()))

# 0으로 초기화
answer = [0 for _ in range(n)]

if n == 1:
    print(score[0])
    exit()
elif n == 2:
    print(score[0] + score[1])
    exit()

answer[0] = score[0]
answer[1] = score[0] + score[1]

for i in range(2, len(score)):
    answer[i] = max(score[i-1]+score[i]+answer[i-3], score[i]+answer[i-2])

print(answer[n-1])
        
"""
    문제 : 2579번 - 계단 오르기
    메모리 : 30616 KB
    시간 : 36 ms
"""
