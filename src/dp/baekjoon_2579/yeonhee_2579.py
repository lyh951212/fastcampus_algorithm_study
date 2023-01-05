import sys
input = sys.stdin.readline
# 30616kb,	36ms
n = int(input())
stair = [0 for i in range(300)]
for i in range(0,n):
    stair[i] = int(input().rstrip())

dp = [0 for i in range(300)]
# dp초기값 설정
dp[0] = stair[0]
dp[1] = stair[0] + stair[1]
dp[2] = max(stair[0] + stair[2], stair[1] + stair[2])

for i in range(3, n):
    dp[i] = max(dp[i-3] + stair[i-1] + stair[i], dp[i-2] + stair[i])

print(dp[n-1])