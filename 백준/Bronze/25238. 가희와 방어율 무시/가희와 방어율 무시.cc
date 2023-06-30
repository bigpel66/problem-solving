#include <iostream>

using namespace std;

class sol {
private:
    double armor, ignore;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> armor >> ignore;
    }

    void solve(void) {
        cout << (armor * (100.0 - ignore) / 100.0 >= 100.0 ? 0 : 1);
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