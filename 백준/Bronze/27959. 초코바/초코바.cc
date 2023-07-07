#include <iostream>

using namespace std;

class sol {
private:
    int n, m;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> n >> m;
    }

    void solve(void) {
        cout << (n * 100 >= m ? "Yes" : "No");
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