import sys
# 152884kb	1952ms
n = int(sys.stdin.readline())
num_list = list(map(int, sys.stdin.readline().split()))
num_set = sorted(set(num_list))
# 중복을 없애기 위해 set에 넣어주고
# set은 순서가 없으니까 sort를 해준다
# dict에 key: 입력받은 숫자값, value: index
map_num = dict()
for i, n in enumerate(num_set):
    if None == map_num.get(n, None):
        map_num[n] = i

for n in num_list:
    index = map_num.get(n)
    print(index , end=" ")
