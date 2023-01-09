# https://www.acmicpc.net/problem/1049
# memory usage: 30748 KB, time usage: 40 ms
import sys

if __name__ == "__main__":
    n, m = map(int, sys.stdin.readline().split())
    global_min = None

    min_six_price = None
    min_one_price = None

    for _ in range(m):
        six, one = map(int, sys.stdin.readline().split())
        if min_six_price is None or min_six_price > six:
            min_six_price = six
        if min_one_price is None or min_one_price > one:
            min_one_price = one

    total_by_one = min_one_price * n
    total_by_only_six = min_six_price * (n // 6) if n % 6 == 0 else min_six_price * (n // 6 + 1)
    total_by_six_and_one = min_six_price * (n // 6) + min_one_price * (n % 6)
    min_price = min(total_by_one, total_by_only_six, total_by_six_and_one)
    if global_min is None or global_min > min_price:
        global_min = min_price

    print(global_min)
