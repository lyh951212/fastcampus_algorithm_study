/*
Date : 20221213
Time : 00:10
Comment : 풀이가 기억이 나가지구;
*/
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N;
vector<pair<int, int>> v;

bool cmp(pair<int, int> v1, pair<int, int> v2) {
	if (v1.second == v2.second)
		return v1.first < v2.first;
	else
		return v1.second < v2.second;
}

int func() {
	int answer = 0;
	int end = 0;
	for (int i = 0; i < N; i++) {
		if (v[i].first >= end) {
			end = v[i].second;
			answer++;
		}
	}
	return answer;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;

	int start, end;
	for (int i = 0; i < N; i++) {
		cin >> start >> end;
		v.push_back({ start, end });
	}
	sort(v.begin(), v.end(), cmp);

	cout << func();
}
