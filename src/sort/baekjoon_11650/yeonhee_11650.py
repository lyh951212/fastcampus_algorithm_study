import sys
import queue

# 53276kb,	908ms
class Data:
    def __init__(self, _x, _y):
        self.x = _x
        self.y = _y

    def __lt__(self, other):
        if self.x == other.x:
            return self.y < other.y
        return self.x < other.x

n = int(sys.stdin.readline())
q = queue.PriorityQueue()

for _ in range(n):
    list_input = list(map(int, sys.stdin.readline().split()))
    q.put(Data(list_input[0], list_input[1]))

while not q.empty():
    _data = q.get()
    print(_data.x, _data.y)