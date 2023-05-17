#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class t_solution {
    public:
        int size;
        int temp;
        vector<bool> v;
    
        t_solution(int n) {
            size = n;
            v = vector<bool>(size, false);
            for (int i = 0 ; i < size - 2; i++) {
                cin >> temp;
                v[temp - 1] = true;
            }
        }
        
        void solve() {
            vector<int> answer;
            for (int i = 0 ; i < size ; i++) {
                if (!v.at(i)) {
                    answer.push_back(i + 1);
                }
            }
            sort(answer.begin(), answer.end(), less<int>());
            for (auto&& i : answer) {
                cout << i << '\n';
            }
        }
};

int main() {
    t_solution s(30);
    s.solve();
    return 0;
}