import sys
input = sys.stdin.readline
# 121144kb,	152ms

def dfs(cur_idx , idx):
    if visited[cur_idx][idx] == True:
        return

    values = graph.get(idx)
    for v in values:
        result[cur_idx][v] = 1
        visited[cur_idx][idx] = True
        dfs(cur_idx, v)

if __name__ == "__main__":
    n = int(input())
    result = [[0 for j in range(n)] for i in range(n)]
    visited = [[False for j in range(n)] for i in range(n)]
    graph = dict()
    for i in range(n):
        graph[i] = list()
    
    for i in range(0, n):
        values = list(map(int, input().rstrip().split(" ")))
        for j, val in enumerate(values):
            if val == 1:
                graph[i].append(j)
    
    for i in range(0, n):
        dfs(i, i)
    
    for i in range(0, n):
        print(" ".join(str(s) for s in result[i]))
