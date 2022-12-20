#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
int arr[8], vis[8];
vector<int> answer;

void recur(int cur) {
	if (cur == M) {
		for (auto v : answer)
			cout << v << ' ';
		cout << '\n';
		return;
	}

	int exValue = 0;
	for (int i = 0; i < N; i++) {
		if (vis[i] == 0 && exValue != arr[i]) {
			answer.push_back(arr[i]);
			vis[i] = 1;
			exValue = arr[i];
			recur(cur + 1);
			answer.pop_back();
			vis[i] = 0;
		}
		
	}
}

int main(void) {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + N);

	recur(0);
}
