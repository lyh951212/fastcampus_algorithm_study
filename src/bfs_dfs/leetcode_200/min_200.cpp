class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        queue<pair<int, int>> q;
        int vis[300][300] = { 0, };
        int dx[4] = { 0, 0, 1, -1 };
        int dy[4] = { 1, -1, 0, 0 };
        int answer = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    vis[i][j] = 1;
                    answer++;
                    q.push({ i, j });
                    while (!q.empty()) {
                        pair<int, int> cur = q.front();
                        q.pop();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.first + dx[dir];
                            int ny = cur.second + dy[dir];

                            if (nx < 0 || ny < 0 || nx >= grid.size() || ny >= grid[0].size())
                                continue;

                            if (grid[nx][ny] == '1' && vis[nx][ny] == 0) {
                                vis[nx][ny] = 1;
                                q.push({ nx, ny });
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
};
