import sys

# 정점의 개수
n = int(sys.stdin.readline())

graph = []

# 인접 행렬 입력
for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

# 플로이드 와샬 알고리즘
for i in range(n):  # 거쳐가는 지점
    for j in range(n):  # 시작 지점
        for k in range(n):  # 도착 지점
            if graph[j][i]==1 and graph[i][k]==1:
                graph[j][k] = 1

# 결과 출력
for i in range(n):
    print(*graph[i])

"""
    문제 : 11403번 - 경로 찾기
    메모리 : 30616 KB
    시간 : 228 ms
"""
