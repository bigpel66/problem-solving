#include <iostream>

using namespace std;

class sol {
private:
    string id;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> id;
    }

    void solve(void) {
        cout << R"(:fan::fan::fan:
:fan::)" << id << R"(::fan:
:fan::fan::fan:)";
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