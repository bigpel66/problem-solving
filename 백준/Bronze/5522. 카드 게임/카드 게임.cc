#include <iostream>

using namespace std;

class sol {
private:
    int sum;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        sum = 0;
    }

    void solve(void) {
        int in;
        for (int i = 0 ; i < 5 ; i++) {
            cin >> in;
            sum += in;
        }
        cout << sum;
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