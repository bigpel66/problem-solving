#include <iostream>

using namespace std;

class sol {
private:
    int row, col, seat;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> row >> col >> seat;
    }

    void solve(void) {
        cout << seat / col << ' ' << seat % col;
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