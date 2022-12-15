/*
Date :
Time : 01:30 ~
Comment :

*/

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;


int N;
vector<int> v;
vector<int> sortedV;
int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N;
	int order = 0;
	int input;
	for (int i = 0; i < N; i++) {
		cin >> input;
		v.push_back(input);
		sortedV.push_back(input);
	}

	sort(sortedV.begin(), sortedV.end(), greater<>());

	////중복제거 (O(N^2)
	//vector<int>::iterator it = sortedV.begin();
	//while (it != sortedV.end()) {
	//	if (next(it, 1) != sortedV.end() && *it == *next(it, 1)) {
	//		it = sortedV.erase(it);
	//		continue;
	//	}
	//	it++;
	//}
	//중복제거2 (O(N))
	sortedV.resize(unique(sortedV.begin(), sortedV.end()) - sortedV.begin());

	for (int i = 0; i < N; i++) {
		int target = v[i];
		int st = 0, en = sortedV.size() - 1;
		int mid;
		//cout << "target : " << target << '\n';
		while (st <= en) {
			mid = (st + en) / 2;
			if (sortedV[mid] < target)
				en = mid - 1;
			else if (sortedV[mid] > target)
				st = mid + 1;
			else {
				break;
			}
		}
		cout << sortedV.size() - (mid + 1) << ' ';
	}
}
