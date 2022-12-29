# https://www.acmicpc.net/problem/11403
# memory usage: 34120 KB, time usage: 136 ms
import sys
from collections import deque


def bfs(node, target, adjList):
    visit = set()
    visit.add(node)
    queue = deque()
    queue.append(node)

    while queue:
        for i in range(len(queue)):
            curr = queue.popleft()

            for neighbor in adjList[curr]:
                if target == neighbor:
                    return 1
                if neighbor not in visit:
                    visit.add(neighbor)
                    queue.append(neighbor)
    return 0


if __name__ == "__main__":
    n = int(input())

    adjList = {}
    for i in range(n):
        if i not in adjList:
            adjList[i] = []
            temp = list(map(int, sys.stdin.readline().split(" ")))
        for j in range(n):
            if temp[j] == 1:
                adjList[i].append(j)

    for i in range(n):
        for j in range(n):
            print(bfs(i, j, adjList), end=" ")
        print()
