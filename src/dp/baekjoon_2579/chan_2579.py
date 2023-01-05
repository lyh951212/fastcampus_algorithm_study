from typing import List


def find_max_points(points: List[int], n) -> int:
    dp = [0 for _ in range(301)]
    dp[0] = points[0]
    dp[1] = points[0] + points[1]
    dp[2] = max(points[0] + points[2], points[1] + points[2])
    for i in range(3, n):
        dp[i] = max(dp[i - 2] + points[i], dp[i - 3] + points[i - 1] + points[i])

    return dp[n - 1]


if __name__ == "__main__":
    n = int(input())
    points = [0 for i in range(301)]
    for i in range(n):
        points[i] = int(input())
    print(find_max_points(points, n))
