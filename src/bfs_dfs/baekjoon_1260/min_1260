/*
Date : 22.12.27
Time : 14:10
Comment : 
*/

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;

int N, M, V;
vector<vector<int>> v;
int vis[1001];
int visM[1001][1001];

void dfs(int cur, int cnt) {
	vis[cur] = 1;
	for (int i = 0; i < v[cur].size(); i++) {
		if (vis[v[cur][i]] == 0) {
			cout << v[cur][i] << ' ';
			dfs(v[cur][i], cnt + 1);
		}
	}
}

void bfs() {
	queue<int> q;
	q.push(V);
	vis[V] = 1;
	cout << V << ' ';
	while (!q.empty()) {
		int cur = q.front();
		q.pop();

		for (int i = 0; i < v[cur].size(); i++) {
			if (vis[v[cur][i]] == 0) {
				vis[v[cur][i]] = 1;
				q.push(v[cur][i]);
				cout << v[cur][i] << ' ';
			}
		}
	}
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M >> V;

	v = vector<vector<int>>(N + 1, vector<int>());

	int st, en;
	for (int i = 0; i < M; i++) {
		cin >> st >> en;
		if (visM[st][en] == 0 && visM[en][st] == 0) {
			v[st].push_back(en);
			v[en].push_back(st);
			visM[st][en] = 1;
			visM[en][st] = 1;
		}
		
	}

	for (int i = 1; i <= N; i++) {
		sort(v[i].begin(), v[i].end(), less<>());
	}
	cout << V << ' ';
	dfs(V, 1);
	cout << '\n';

	memset(vis, 0, sizeof(vis)); // N * sizeof(int);
	bfs();
}
