#include <iostream>

using namespace std;

class sol {
private:
    bool is_slogan;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> is_slogan;
    }

    void solve(void) {
        cout << (is_slogan ? "Leading the Way to the Future" : "YONSEI");
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