#define FOR(i, a, b) for (int i = a ; i < b ; i++)
#define REP(i, n) for (int i = 0 ; i < n ; i++)
#include <algorithm>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using point = pair<int, int>;

class sol {
    private:
        int n;
        int x, y;
        vector<point> vec;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            REP(i, n) {
                cin >> x >> y;
                vec.push_back({x, y});
            }
        }
        
        void solve(void) {
            sort(vec.begin(), vec.end(), [](auto&& i, auto&& j) -> bool {
                return i.second == j.second ? i.first < j.first : i.second < j.second;
            });
            REP(i, n) {
                cout << vec.at(i).first << ' ' << vec.at(i).second << '\n';
            }
        }

    public:
        sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    sol ve;
    return 0;
}