#include <iostream>

using namespace std;

class sol {
private:

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void solve(void) {
        int a, b;
        while (true) {
            cin >> a >> b;
            if (a == 0 && b == 0) {
                break;
            }
            cout << (a > b ? "Yes" : "No") << '\n';
        }
    }

public:
    sol(void) {
        stream();
        solve();
    }
};

int main(void) {
    sol ve;
    return 0;
}