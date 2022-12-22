# https://www.acmicpc.net/problem/11729
# memory usage: 30616 KB, time usage: 876 ms
import sys


# step1) show f(1) works (basecase)
# step2) assume f(n-1) works
# step3) show f(n) works using f(n-1)
def find_fk_hanoi(n, start, end):
    if n == 1:
        print(start, end)
        return
    other = 6 - (start + end)
    find_fk_hanoi(n - 1, start, other)
    print(start, end)
    find_fk_hanoi(n - 1, other, end)


n = int(sys.stdin.readline())
print(2 ** n - 1)
find_fk_hanoi(n, 1, 3)