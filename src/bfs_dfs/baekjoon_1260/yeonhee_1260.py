# https://www.acmicpc.net/problem/1260
# 34156kb, 76ms
import sys
from collections import deque 
input = sys.stdin.readline

def dfs(graph, start_node):
    values = graph.get(start_node, None)
    if None == values:
        return
    values = sorted(values)
    for v in values:
        if True == visited[v]:
            continue
        visited[v] = True
        result.append(v)
        dfs(graph, v)


def bfs(graph, s):
    queue = deque()
    queue.append(s)
    result.append(s)
    visited[s] = True
    while len(queue) > 0:
        node = queue.popleft()

        values = graph.get(node, None)
        if None == values:
            return
        values = sorted(values)
        for v in values:
            if visited[v] == False:
                queue.append(v)
                result.append(v)
                visited[v] = True


graph = dict()
n,m,s = map(int, input().split(' '))
for _ in range(m):
    a,b = map(int, input().split(' '))
    tmp_dict = {a:b}
    if a not in graph.keys():
        graph[a] = list()

    if b not in graph.keys():
        graph[b]  = list()

    graph[a].append(b)
    graph[b].append(a)
    
#graph = dict(sorted(graph.items(), key = lambda item : item[1]))
visited = [False] * (n+1)
result = []
visited[s] = True
result.append(s)
dfs(graph, s)
print(' '.join(map(str, result)))


result = []
visited = [False,] * (n+1)
bfs(graph, s)
print(' '.join(map(str, result)))
