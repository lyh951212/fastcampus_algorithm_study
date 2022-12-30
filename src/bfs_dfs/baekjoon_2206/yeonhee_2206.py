# import sys
# from collections import deque
# input = sys.stdin.readline

# def dfs(graph, r, c, crash_cnt , count):
#     # 목표 지점에 도착
#     if r == len(graph)-1 and c == len(graph[0])-1:
#         result.append(count)
#         return

#     if r < 0 or c < 0 or r >= len(graph) or c >= len(graph[0]):
#         return
        
#     if visited[r][c] == True:
#         return

#     # 벽을 부실 수 없고, 벽을 만났을 때
#     if crash_cnt <= 0 and graph[r][c] == 1:
#         return

#     if graph[r][c] == 1:
#         crash_cnt -= 1

#     count += 1
#     visited[r][c] = True
#     # 오 왼 위 아래
#     dfs(graph, r, c+1, crash_cnt, count)
#     dfs(graph, r, c-1, crash_cnt, count)
#     dfs(graph, r-1, c, crash_cnt, count)
#     dfs(graph, r+1, c, crash_cnt, count)


# if __name__ == "__main__":
#     n,m = map(int, input().split(" "))
#     graph = []
#     for _ in range(n):
#         graph.append(list(map(int, input().rstrip())))

#     visited = [[False for j in range(m)] for i in range(n)]
#     result = list()
#     dfs(graph, 0, 0, 1, 1)

#     if len(result) == 0:
#         print(-1)
#     else: 
#         print(min(result))
# =================================================================
import sys
from collections import deque
input = sys.stdin.readline
# 279432kb,	1604ms
def bfs():
    queue = deque()
    queue.append((0,0,0))
    visited[0][0][0] = 1

    while queue:
        poped_data = queue.popleft()
        (pop_r_idx, pop_c_idx, crash_cnt) = poped_data

        if pop_r_idx == n - 1 and pop_c_idx == m - 1:
            return visited[pop_r_idx][pop_c_idx][crash_cnt]

        for i in range(0, 4):
            tmp_r = pop_r_idx + dr[i]
            tmp_c = pop_c_idx + dc[i]

            if tmp_r < 0 or tmp_c < 0 or tmp_r >= n or tmp_c >= m:
                continue

            # 벽을 부순다
            if graph[tmp_r][tmp_c] == 1 and crash_cnt == 0:
                queue.append((tmp_r, tmp_c,crash_cnt+1))
                visited[tmp_r][tmp_c][crash_cnt+1] = visited[pop_r_idx][pop_c_idx][crash_cnt]+1
            # 벽 안부수고 이동
            elif graph[tmp_r][tmp_c] == 0 and visited[tmp_r][tmp_c][crash_cnt] == 0:
                queue.append((tmp_r, tmp_c,crash_cnt))
                visited[tmp_r][tmp_c][crash_cnt] = visited[pop_r_idx][pop_c_idx][crash_cnt]+1

    return -1


if __name__ == "__main__":
    n,m = map(int, input().split(" "))
    graph = []
    for _ in range(n):
        graph.append(list(map(int, input().rstrip())))

    # 오 왼 위 아래
    dr = [0, 0, -1, 1]
    dc = [1, -1, 0, 0]
    visited = [[[0]*2 for j in range(m)] for i in range(n)]
    print(bfs())