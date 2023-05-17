#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class sol {
    private:
        int n, k;
        queue<int> q;
        vector<int> v;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n >> k;
            for (int i = 1 ; i <= n ; i++) {
                q.push(i);
            }
        }
     
        void solve(void) {
            int index = 1;
            while (!q.empty()) {
                int value = q.front();
                q.pop();
                if (!(index % k)) {
                    v.push_back(value);
                } else {
                    q.push(value);
                }
                index++;
            }
            cout << '<';
            for (size_t i = 0 ; i < v.size() ; i++) {
                cout << v.at(i);
                if (i != v.size() - 1) {
                    cout << ", ";
                } else {
                    cout << '>';
                }
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