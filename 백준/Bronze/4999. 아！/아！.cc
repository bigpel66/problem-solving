#include <iostream>

using namespace std;

class sol {
private:
    string s1, s2;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> s1 >> s2;
    }

    void solve(void) {
        cout << (s1.length() >= s2.length() ? "go" : "no");
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