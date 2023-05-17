#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        int number_of_pair;
        vector<int> parent;
        vector<pair<int, int>> pairs;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n >> number_of_pair;
            parent = vector<int>(n + 1, 0);
            for (int i = 0 ; i <= n ; i++) {
                parent[i] = i;
            }
            int a, b;
            for (int i = 0 ; i < number_of_pair ; i++) {
                cin >> a >> b;
                pairs.push_back({a, b});
            }
        }
    
        int get_parent(int i) {
            if (parent.at(i) == i) {
                return i;
            }
            return parent[i] = get_parent(parent.at(i));
        }
    
        void union_parent(int i, int j) {
            int i_parent = get_parent(i);
            int j_parent = get_parent(j);
            if (i_parent == j_parent) {
                return;
            }
            if (i_parent < j_parent) {
                parent[j_parent] = i_parent;
            } else {
                parent[i_parent] = j_parent;
            }
        }
    
        void update_parent() {
            for (size_t i = 0 ; i < parent.size() ; i++) {
                parent[i] = get_parent(i);
            }
        }
        
        void solve(void) {
            for (auto&& i : pairs) {
                union_parent(i.first, i.second);
            }
            update_parent();
            int count = 0;
            for (auto&& i : parent) {
                if (get_parent(i) == get_parent(1)) {
                    count++;
                }
            }
            cout << count - 1;
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