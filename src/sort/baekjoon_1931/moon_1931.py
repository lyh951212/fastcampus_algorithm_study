import sys

# 회의의 수 입력
n = int(sys.stdin.readline())

arr = []

# 각 회의 정보 입력 (시작 시간, 끝나는 시간)
for i in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

# 끝나는 시간 기준으로 오름차순 정렬
arr.sort(key=lambda x:(x[1], x[0]))

answer = 1
# 첫 회의의 끝나는 시간을 저장
time = arr[0][1]

for i in range(1, n):
    # 현재 회의의 끝나는 시간보다 다음 회의의 시작 시간보다 크다면
    if time <= arr[i][0]:
        # 비교할 회의 시간 갱신
        time = arr[i][1]
        answer += 1

print(answer)

"""
    메모리 : 58416 KB
    시간 : 352 ms
"""





