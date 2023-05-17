#include <algorithm>
#include <iostream>
#include <set>

using namespace std;

class sol {
    private:
        int l_count, d_count;
        set<string> l;
        set<string> d;
        vector<string> answer;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> l_count >> d_count;
            answer = vector<string>(l_count + d_count);
        }
        
        void solve(void) {
            string temp;
            for (int i = 0 ; i < l_count ; i++) {
                cin >> temp;
                l.insert(temp);
            }
            for (int i = 0 ; i < d_count ; i++) {
                cin >> temp;
                d.insert(temp);
            }
            auto&& iter = set_intersection(l.begin(), l.end(), d.begin(), d.end(), answer.begin());
            answer.resize(iter - answer.begin());
            sort(answer.begin(), answer.end(), less<string>());
            cout << answer.size() << '\n';
            for (auto&& i : answer) {
                cout << i << '\n';
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