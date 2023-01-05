#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

int N;
int dp[3000001][3];
int stair[301];

int func() {
	dp[1][1] = stair[1];
	dp[2][1] = stair[2];
	dp[2][2] = stair[1] + stair[2];

	for (int i = 3; i <= N; i++) {
		dp[i][1] = max(dp[i - 2][1], dp[i - 2][2]) + stair[i];
		dp[i][2] = dp[i - 1][1] + stair[i];
	}
	return max(dp[N][1], dp[N][2]);
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	int input;
	for (int i = 1; i <= N; i++) {
		cin >> stair[i];
	}

	cout << func();
}
