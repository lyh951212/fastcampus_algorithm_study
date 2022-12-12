import sys
from queue import PriorityQueue


class Pair:

    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __lt__(self, other):
        if self.x == other.x:
            return self.y < other.y
        else:
            return self.x < other.x


## 53448 KB / 840 ms
def pq_version():
    num = int(sys.stdin.readline())
    que = PriorityQueue()

    for i in range(num):
        a, b = map(int, sys.stdin.readline().split())
        que.put(Pair(a, b))

    for i in range(num):
        pair = que.get()
        print(pair.x, pair.y)


# 	50064 KB / 364 ms
def list_comprehension_version():
    num = int(sys.stdin.readline())

    pos = [list(map(int, sys.stdin.readline().split())) for i in range(num)]
    pos.sort()

    for i in pos:
        print(*i)


list_comprehension_version()
