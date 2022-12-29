import sys
from collections import deque

# BFS 방식
def bfs():
    visited = [[[0, 0] for _ in range(m)] for _ in range(n)]
    queue = deque([(0, 0, 0)]) # y, x, wall

    visited[0][0][0] = 1

    while queue:
        nodeY, nodeX, wall = queue.popleft()

        # 목적지에 도착했으면
        if nodeX==m-1 and nodeY==n-1:
            return visited[nodeY][nodeX][wall]

        # 4방향 탐색
        for i in range(4):
            x, y = nodeX + dx[i], nodeY + dy[i]

            # 맵의 크기를 벗어나면 안됨
            if x>=0 and y>=0 and x<m and y<n:
                # 방문하지 않았으면서 벽을 부수고 이동하지 않았고, 이동할 수 있다면
                if visited[y][x][wall]==0 and graph[y][x]==0:
                    queue.append((y, x, wall))
                    visited[y][x][wall] = visited[nodeY][nodeX][wall] + 1
                # 벽을 부순적이 없고 벽이 있다면
                elif wall==0 and graph[y][x]==1:
                    queue.append((y, x, 1))
                    visited[y][x][1] = visited[nodeY][nodeX][wall] + 1

    return -1

# 행과 열 입력
n, m = map(int, sys.stdin.readline().split())

graph = []

# 맵 입력
for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().strip())))

# x, y축
dx, dy = [0, 1, 0, -1], [-1, 0, 1, 0]

print(bfs())

"""
    문제 : 2206번 - 벽 부수고 이동하기
    메모리 : 190980 KB
    시간 : 3936 ms
"""
