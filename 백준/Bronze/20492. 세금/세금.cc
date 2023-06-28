#include <iostream>

using namespace std;

class sol {
private:
    int prize;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> prize;
    }

    void solve(void) {
        cout << prize / 100 * 78 << ' ' << prize - prize / 100 * 20 / 100 * 22;
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