#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
vector<int> answer;
int arr[8];

void recur(int cur, int cnt) {
	if (cnt == M) {
		for (auto v : answer)
			cout << v << ' ';
		cout << '\n';
		return;
	}

	for (int i = cur; i < N; i++) {
		answer.push_back(arr[i]);
		recur(i, cnt + 1);
		answer.pop_back();
	}
}

int main(void) {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + N);

	recur(0, 0);
}
