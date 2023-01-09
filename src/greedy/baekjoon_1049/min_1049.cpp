#include <iostream>
#include <limits.h>

using namespace std;

int N, M, answer;
int min6 = INT_MAX, min1 = INT_MAX;
int func() {
	answer += (N / 6) * min6;
	answer += (N % 6) * min1 > min6 ? min6 : (N % 6) * min1;

	return answer;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	int x, y;
	for (int i = 0; i < M; i++) {
		cin >> x >> y;

		if (y * 6 < x)
			x = y * 6;

		if (x < min6)
			min6 = x;
		if (y < min1)
			min1 = y;
	}

	cout << func();
}
