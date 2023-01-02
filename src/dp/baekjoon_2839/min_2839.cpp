/*
Date : 230102
Time : 19:58 ~ 20:16 (18분)
Comment :  
*/
#include <iostream>
#include <queue>

using namespace std;

int N;
int dp[5001], dx[2] = { 3, 5 };
queue<int> q;
void func() {
	q.push(N);
	dp[N] = 1;

	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int dir = 0; dir < 2; dir++) {
			int nx = cur - dx[dir];

			if (nx < 0)
				continue;

			if (dp[nx] < dp[cur]) {
				dp[nx] = dp[cur] + 1;
				q.push(nx);
			}

			if (nx == 0)
				return;
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	

	func();
	
	cout << (dp[0] == 0 ? -1 : dp[0] - 1);
}
