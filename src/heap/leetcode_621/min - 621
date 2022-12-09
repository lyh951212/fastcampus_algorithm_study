/*
Date : 22.12.08
Time : 00:57
Comment : 
	line 27~28 의 배열을 사용했을 때 : Runtime 17.35% Memory 6.3%
	line 30  의 unordered_map을 사용했을 때 : Runtime 73.75% Memory 6.3%
*/

#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <unordered_map>

using namespace std;

class Solution {
public:
	struct cmp {
		bool operator()(pair<char, int> x, pair<char, int> y) {
			return x.second < y.second;//오름차순, less
		}
	};

	int answer = 0;
	int leastInterval(vector<char>& tasks, int n) {
		priority_queue<pair<char, int>, vector<pair<char, int>>, cmp> pq;
		//int alphabet[26];
		//memset(alphabet, 0, sizeof(alphabet));
		unordered_map<char, int> alphabet;
		for (int i = 0; i < tasks.size(); i++)
			alphabet[tasks[i]]++;

		for (pair<char, int> alp : alphabet)
			pq.push({ alp.first, alp.second });

		while (!pq.empty()) {
			queue<pair<char, int>> pqBuf;
			int innerCnt = 0;
			for (int i = 0; i < n + 1; i++) {
				if (!pq.empty()) {
					innerCnt++;
					pair<char, int> buf = pq.top(); pq.pop();
					if (--buf.second)
						pqBuf.push(buf);
				}
			}
			while (!pqBuf.empty()) {
				pq.push(pqBuf.front()); pqBuf.pop();
			}
			answer += pq.empty() ? innerCnt : n + 1;
		}
		return answer;
	}
};
