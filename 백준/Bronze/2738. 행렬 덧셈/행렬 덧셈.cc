#include <iostream>
#include <vector>

using namespace std;

class t_solution {
    private:
        vector<vector<int>> init_matrix() {
            return vector<vector<int>>(row, vector<int>(col, 0));    
        }
    
        void alloc_matrix(vector<vector<int>>& v) {
            for (auto&& i : v) {
                for (auto&& j : i) {
                    cin >> j;
                }
            }
        }
    
    public:
        int row, col;
        vector<vector<int>> a, b;
    
        t_solution(int n, int m) {
            cin >> n >> m;
            row = n;
            col = m;
            a = init_matrix();
            b = init_matrix();
            alloc_matrix(a);
            alloc_matrix(b);
        }
    
        void solve() {
            for (int i = 0 ; i < row ; i++) {
                for (int j = 0 ; j < col ; j++) {
                    cout << a[i][j] + b[i][j] << ' ';
                }
                cout << '\n';
            }
        }
};

int main() {
    t_solution s(0, 0);
    s.solve();
    return 0;
}