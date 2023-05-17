#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        vector<int> vec;
        vector<int> original;
        vector<int> st;
        string s;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            int temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                vec.push_back(temp);
            }
            vec = vector<int>(vec.rbegin(), vec.rend());
        }
    
        void solve(void) {
            for (size_t i = 0 ; i < vec.size() ; i++) {
                while (!st.empty() && st.at(st.size() - 1) > vec.at(i)) {
                    original.push_back(st.at(st.size() - 1));
                    st.pop_back();
                    s.push_back('+');
                }
                st.push_back(vec.at(i));
                s.push_back('-');
            }
            while (!st.empty()) {
                original.push_back(st.at(st.size() - 1));
                st.pop_back();
                s.push_back('+');
            }
            if (!is_sorted(original.rbegin(), original.rend())) {
                cout << "NO";
                return;
            }
            for (auto iter = s.rbegin() ; iter != s.rend() ; iter++) {
                cout << *iter << '\n';
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