import sys
import itertools

n, m = map(int, sys.stdin.readline().split())
num_list = sorted(list(map(int, sys.stdin.readline().split())))

visited = set()

for result in itertools.permutations(num_list, m):
    if result not in visited:
        visited.add(result)
        print(' '.join(map(str, result)))


