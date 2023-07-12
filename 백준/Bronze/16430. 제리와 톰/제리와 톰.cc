#include <iostream>

using namespace std;

class sol {
private:
    int p, q;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> p >> q;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    void solve(void) {
        p = q - p;
        int common = gcd(p, q);
        p /= common;
        q /= common;
        cout << p << ' ' << q;
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