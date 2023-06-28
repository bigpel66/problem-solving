#include <iostream>

using namespace std;

class sol {
private:
    int year;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> year;
    }

    void solve(void) {
        cout << year - 1946;
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