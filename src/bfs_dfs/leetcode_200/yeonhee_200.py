# https://leetcode.com/problems/number-of-islands/
# Runtime 307 ms
# Memory 30.2 MB

import sys
from collections import deque 
# 위 오 아래 왼
dr = [-1,0,1,0]
dc = [0,1,0,-1]
class Solution(object):
    def bfs(self, ridx, cidx):
        queue = deque()
        queue.append((ridx, cidx))
        self.visited[ridx][cidx] = True
        while len(queue) > 0:
            poped_pos = queue.popleft()
            for i in range(0, 4):
                tmp_r = poped_pos[0] + dr[i]
                tmp_c = poped_pos[1] + dc[i]

                if tmp_r < 0 or tmp_r >= self.r_length:
                    continue

                if tmp_c < 0 or tmp_c >= self.c_length:
                    continue

                if self.visited[tmp_r][tmp_c] == True:
                    continue

                if self.grid[tmp_r][tmp_c] == "0":
                    continue
                
                self.visited[tmp_r][tmp_c] = True
                queue.append((tmp_r, tmp_c))

    def numIslands(self, grid):
        self.grid = grid
        self.r_length = len(grid)
        self.c_length = len(grid[0])

        self.visited = [[False for j in range(self.c_length)] for i in range(self.r_length)]
        # self.visited = [[False] * self.c_length]* self.r_length
        # https://qkqhxla1.tistory.com/768
        """
        :type grid: List[List[str]]
        :rtype: int
        """

        count = 0

        for r in range(0, self.r_length):
            for c in range(0, len(grid[r])):
                if self.visited[r][c] == True:
                    continue

                if grid[r][c] == "0":
                    continue
                        
                count+=1
                self.bfs(r,c)
                
        return count

s2 = Solution()
grid = [
    ["0","1","0"],
    ["1","0","1"],
    ["0","1","0"]
    ]

print(s2.numIslands(grid))