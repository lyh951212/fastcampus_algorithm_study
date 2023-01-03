from typing import List


def rob(nums: List[int]) -> int:
    rob1 = 0
    rob2 = 0

    for n in nums:
        temp = max(n + rob1, rob2)
        rob1 = rob2
        rob2 = temp
    return rob2


if __name__ == "__main__":
    print(rob([4, 1, 2, 7, 5, 3, 1]))
