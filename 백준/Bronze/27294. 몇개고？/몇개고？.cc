#include <iostream>

using namespace std;

class sol {
private:
    int eating_time, is_with_drink;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> eating_time >> is_with_drink;
    }

    void solve(void) {
        cout << ((is_with_drink || !(eating_time >= 12 && eating_time <= 16)) ? 280 : 320);
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