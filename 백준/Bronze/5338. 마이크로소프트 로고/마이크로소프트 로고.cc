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

const string& sol::logo = R"(       _.-;;-._
'-..-'|   ||   |
'-..-'|_.-;;-._|
'-..-'|   ||   |
'-..-'|_.-''-._|)";

int main(void) {
    sol ve;
    return 0;
}