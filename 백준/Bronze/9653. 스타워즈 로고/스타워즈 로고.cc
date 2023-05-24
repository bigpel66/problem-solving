#include <iostream>

using namespace std;

class sol {
private:
    static const string& logo;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void solve(void) {
        cout << logo;
    }

public:
    sol(void) {
        stream();
        solve();
    }
};

const string& sol::logo = R"(    8888888888  888    88888
   88     88   88 88   88  88
    8888  88  88   88  88888
       88 88 888888888 88   88
88888888  88 88     88 88    888888

88  88  88   888    88888    888888
88  88  88  88 88   88  88  88
88 8888 88 88   88  88888    8888
 888  888 888888888 88  88      88
  88  88  88     88 88   88888888)";

int main(void) {
    sol ve;
    return 0;
}