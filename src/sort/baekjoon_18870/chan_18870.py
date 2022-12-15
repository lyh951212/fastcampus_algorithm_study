import sys

# 149744 KB // 1844 ms
if __name__ == "__main__":
    num = int(sys.stdin.readline())
    x_axis_list = list(map(int, sys.stdin.readline().split()))

    index_map = {value: index for index, value in enumerate(sorted(set(x_axis_list)))}

    for x in x_axis_list:
        print(index_map.get(x), end=" ")