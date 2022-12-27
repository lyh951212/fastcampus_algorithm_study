import sys
from collections import deque
# 34124 KB	300 ms

def dfs(node, visited):
    if node not in visited:
        print(node, end=" ")
        visited.append(node)
        for neighbor in sorted(adjList[node]):
            dfs(neighbor, visited)


def bfs(node, visited):
    queue = deque()
    queue.append(node)
    visited.append(node)
    while queue:
        curr = queue.popleft()
        print(curr, end=" ")
        for neighbor in sorted(adjList[curr]):
            if neighbor not in visited:
                visited.append(neighbor)
                queue.append(neighbor)


if __name__ == "__main__":
    n, m, v = map(int, sys.stdin.readline().split())
    adjList = {}

    for i in range(n):
        adjList[i] = []

    for _ in range(m):
        src, dst = map(int, sys.stdin.readline().split())
        if src not in adjList:
            adjList[src] = []
        if dst not in adjList:
            adjList[dst] = []
        adjList[src].append(dst)
        adjList[dst].append(src)

    visited = []
    dfs(v, visited)
    visited = []
    print()
    bfs(v, visited)
