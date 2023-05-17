#include <iostream>
#include <string>
#include <vector>

using namespace std;

class t_solution {
    private:
        int size;
        vector<string> vec;
    
        void get_input() {
            cin >> size;
            vec = vector<string>(size, "");
            for (int i = 0 ; i < size ; i++) {
                cin >> vec[i];
            }
        }
    
        void solve() {
            for(auto&& i : vec) {
                cout << i.at(0) << i.at(i.size() - 1) << '\n';
            }
        }
    
    public:
        t_solution() {
            get_input();
            solve();
        }
};

int main() {
    t_solution s;
    return 0;
}