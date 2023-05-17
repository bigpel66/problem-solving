#include <climits>
#include <cmath>
#include <iostream>
#include <queue>
#include <tuple>

using namespace std;
using point = tuple<int, int, int, int>;

class sol {
    private:
        int x, y, z;
        int answer;
        vector<vector<vector<int>>> v;
        queue<point> q;
    
        static const vector<vector<int>>& displacement;

        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> z >> y >> x;
            answer = 0;
            v = vector<vector<vector<int>>>(x, vector<vector<int>>(y, vector<int>(z, 0)));
            for (int i = 0 ; i < x ; i++) {
                for (int j = 0 ; j < y ; j++) {
                    for (int k = 0 ; k < z ; k++) {
                        cin >> v[i][j][k];
                        if (v.at(i).at(j).at(k) == 1) {
                            q.push({0, i, j, k});
                        }
                    }
                }
            }
        }
    
        void bfs(void) {
            while (!q.empty()) {
                int cost, cx, cy, cz;
                tie(cost, cx, cy, cz) = q.front();
                q.pop();
                for (size_t i = 0 ; i < displacement.size() ; i++) {
                    int next_x = cx + displacement.at(i).at(0);
                    int next_y = cy + displacement.at(i).at(1);
                    int next_z = cz + displacement.at(i).at(2);
                    if (next_x < 0 || next_y < 0 || next_z < 0
                       || next_x >= x || next_y >= y || next_z >= z
                       || v.at(next_x).at(next_y).at(next_z) != 0) {
                        continue;
                    }
                    q.push({cost + 1, next_x, next_y, next_z});
                    answer = max(answer, cost + 1);
                    v[next_x][next_y][next_z] = 1;
                }
            }
        }
    
        bool is_all_rotten(void) {
            for (int i = 0 ; i < x ; i++) {
                for (int j = 0 ; j < y ; j++) {
                    for (int k = 0 ; k < z ; k++) {
                        if (!v.at(i).at(j).at(k)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        
        void solve(void) {
            bfs();
            cout << (is_all_rotten() ? answer : -1);
        }

    public:
        sol(void) {
            stream();
            get_input();
            solve();
        }
};

const vector<vector<int>>& sol::displacement{
    {1, 0, 0},
    {-1, 0, 0},
    {0, 1, 0},
    {0, -1, 0},
    {0, 0, 1},
    {0, 0, -1}
};

int main(void) {
    sol ve;
    return 0;
}