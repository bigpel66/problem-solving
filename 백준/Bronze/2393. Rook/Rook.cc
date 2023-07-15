#include <iostream>

using namespace std;

class sol {
private:

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void solve(void) {
        string s =
                "  ___  ___  ___\n"
                "  | |__| |__| |\n"
                "  |           |\n"
                "   \\_________/\n"
                "    \\_______/\n"
                "     |     |\n"
                "     |     |\n"
                "     |     |\n"
                "     |     |\n"
                "     |_____|\n"
                "  __/       \\__\n"
                " /             \\\n"
                "/_______________\\";
        cout << s;
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