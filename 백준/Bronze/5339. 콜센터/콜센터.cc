#include <iostream>

using namespace std;

class sol {
private:

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void solve(void) {
        cout << R"(     /~\
    ( oo|
    _\=/_
   /  _  \
  //|/.\|\\
 ||  \ /  ||
============
|          |
|          |
|          |)";
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