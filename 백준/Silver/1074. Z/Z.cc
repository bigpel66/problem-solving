#include <cmath>
#include <iostream>

using namespace std;

class sol {
private:
    int n;
    int row, col;
    int count;
    size_t size;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> n >> row >> col;
        count = 0;
        size = static_cast<size_t>(pow(2, n));
    }

    bool div_and_conq(int x, int y, size_t s) {
        if (x == row && y == col) {
            cout << count;
            return true;
        }
        if (x <= row && row < x + s && y <= col && col < y + s) {
            if (div_and_conq(x, y, s / 2)
                || div_and_conq(x, y + s / 2, s / 2)
                || div_and_conq(x + s / 2, y, s / 2)
                || div_and_conq(x + s / 2, y + s / 2, s / 2)) {
                return true;
            }
        } else {
            count += s * s;
        }
        return false;
    }

    void solve(void) {
        div_and_conq(0, 0, size);
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