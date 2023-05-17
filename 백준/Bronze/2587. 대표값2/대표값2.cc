#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        vector<int> vec;
        double avg;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            int temp;
            for (int i = 0 ; i < 5 ; i++) {
                cin >> temp;
                avg += static_cast<double>(temp);
                vec.push_back(temp);
            }
            avg /= 5;
            sort(vec.begin(), vec.end(), less<int>());
        }
        
        void solve(void) {
            cout << avg << '\n' << vec.at(2);
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