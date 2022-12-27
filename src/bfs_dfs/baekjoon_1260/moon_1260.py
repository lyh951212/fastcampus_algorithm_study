import sys
from collections import deque

# DFS 방식
def dfs(start):
    visited[start] = True
    print(start, end=' ')

    for i in range(1, n+1):
        if not visited[i] and graph[start][i]==1:
            dfs(i)

# BFS 방식
def bfs(start):
    visited[start] = True

    queue = deque([start])

    while queue:
        node = queue.popleft()
        print(node, end=' ')

        for i in range(1, n+1):
            if not visited[i] and graph[node][i]==1:
                visited[i] = True
                queue.append(i)

# 정점과 간선의 개수, 탐색을 시작할 정점의 번호 입력
n, m, v = map(int, sys.stdin.readline().split())

graph = [[0]*(n+1) for i in range(n+1)]

# 두 정점 번호 입력
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a][b] = 1
    graph[b][a] = 1

visited = [False for i in range(n+1)]
dfs(v)

print()

visited = [False for i in range(n+1)]
bfs(v)

"""
    문제 : 1260번 - DFS와 BFS
    메모리 : 39568 KB
    시간 : 148 ms
"""
