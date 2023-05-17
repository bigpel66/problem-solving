#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

class t_sol {
    private:
        static const unordered_map<char, int>& ring;
        string s;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> s;
        }
    
        void solve(void) {
            int acc = 0;
            for (auto&& i : s) {
                acc += ring.at(i);
            }
            cout << acc << '\n';
        }
    
    public:
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

const unordered_map<char, int>& t_sol::ring = {
    {'A', 3},
    {'B', 3},
    {'C', 3},
    {'D', 4},
    {'E', 4},
    {'F', 4},
    {'G', 5},
    {'H', 5},
    {'I', 5},
    {'J', 6},
    {'K', 6},
    {'L', 6},
    {'M', 7},
    {'N', 7},
    {'O', 7},
    {'P', 8},
    {'Q', 8},
    {'R', 8},
    {'S', 8},
    {'T', 9},
    {'U', 9},
    {'V', 9},
    {'W', 10},
    {'X', 10},
    {'Y', 10},
    {'Z', 10},
};

int main(void) {
    t_sol s;
    return 0;
}