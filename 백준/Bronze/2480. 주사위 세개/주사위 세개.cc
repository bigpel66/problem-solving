#include <algorithm>
#include <iostream>
#include <map>

using namespace std;

class t_solution {
    private:
        struct map_comp {
            public:
                bool operator()(const int& lhs, const int& rhs) const {
                    return lhs > rhs;
                }
        };
    
        int temp;
        map<int, int, map_comp> m;
        
        void get_input(void) {
            for (int i = 0 ; i < 3 ; i++) {
                cin >> temp;
                m[temp]++;
            }
        }
    
        int get_win_price() {
            if (m.size() == 3) {
                return m.begin()->first * 100;
            } else if (m.size() == 1) {
                return m.begin()->first * 1'000 + 10'000;
            } else {
                for (auto&& i : m) {
                    if (i.second == 2) {
                        return i.first * 100 + 1'000;
                    }
                }
                return -1;
            }
        }
    
        void solve(void) {
            cout << get_win_price();
        }
    
    public:
        t_solution(void) {
            get_input();
            solve();
        }
};

int main(void) {
    t_solution s;
    return 0;
}