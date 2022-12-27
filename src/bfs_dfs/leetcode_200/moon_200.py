class Solution(object):
    def numIslands(self, grid):
        visited = [[False for _ in range(len(grid[0]))] for _ in range(len(grid))] # False로 초기화
        dx, dy = [0, 1, 0, -1], [-1, 0, 1, 0] # x, y축 
        answer = 0
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if not visited[i][j] and grid[i][j]=='1': # 방문하지 않았고 섬이면
                    self.bfs(grid, i, j, visited, dy, dx) # bfs 탐색
                    answer += 1 
    
        return answer

    def bfs(self, grid, row, col, visited, dy, dx):
        visited[row][col] = True    # 방문 표시
        queue = deque([])

        queue.append([row, col]) # 좌표 저장

        while queue:
            nodeY, nodeX = queue.popleft()
    
            for i in range(4): # 네 방향 탐색
                y, x = nodeY + dy[i], nodeX + dx[i] # 좌표 이동

                if x>=0 and y>=0 and x<len(grid[0]) and y<len(grid): # 이동한 좌표가 좌표 크기를 넘어서면 안됨
                    if not visited[y][x] and grid[y][x]=='1': # 방문하지 않았고 이동한 좌표가 섬이면
                        visited[y][x] = True # 방문 표시
                        queue.append([y, x]) # 좌표 저장
        
        



            

        
