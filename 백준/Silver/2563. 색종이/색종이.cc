#include <iostream>
#include <vector>

using namespace std;

class t_sol {
    private:
        int n;
        int x, y;
        int area;
        vector<vector<bool>> paper;
    
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> n;
            area = 0;
            paper = vector<vector<bool>>(101, vector<bool>(101, true));
        }
    
        void solve(void) {
            for (int i = 0 ; i < n ; i++) {
                cin >> x >> y;
                for (int j = x ; j < x + 10 ; j++) {
                    for (int k = y ; k < y + 10 ; k++) {
                        paper[j][k] = false;
                    }
                }
            }
            for (int i = 1 ; i <= 100 ; i++) {
                for (int j = 1 ; j <= 100 ; j++) {
                    if (!paper[i][j]) {
                        area++;
                    }
                }
            }
            cout << area;
        }

    public:
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    t_sol s;
    return 0;
}