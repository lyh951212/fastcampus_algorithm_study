# https://www.acmicpc.net/problem/2206
# memory usage: 302224 KB, time usage: 6504 ms
import sys
from collections import deque


def bfs(grid):
    ROWS, COLS = len(grid), len(grid[0])
    visit = set()
    queue = deque()
    queue.append((0, 0, 1))
    visit.add((0, 0, 1))

    length = 0

    while len(queue) != 0:
        for i in range(len(queue)):
            r, c, one_chance = queue.popleft()
            if r == ROWS - 1 and c == COLS - 1:
                return length + 1

            neighbors = [[0, 1], [0, -1], [1, 0], [-1, 0]]
            for dr, dc in neighbors:
                if (min(r + dr, c + dc) < 0 or
                        r + dr == ROWS or c + dc == COLS or
                        (r + dr, c + dc, one_chance) in visit):
                    continue
                elif grid[r + dr][c + dc] == 1 and one_chance == 0:
                    continue

                if grid[r + dr][c + dc] == 1 and one_chance == 1:
                    queue.append((r + dr, c + dc, 0))
                    visit.add((r + dr, c + dc, 0))
                    continue

                queue.append((r + dr, c + dc, one_chance))
                visit.add((r + dr, c + dc, one_chance))
        length += 1
    return -1


if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())

    grid = []
    for _ in range(n):
        grid.append(list(map(int, sys.stdin.readline().strip())))

    print(bfs(grid))
