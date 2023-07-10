#include <iostream>

using namespace std;

class sol {
private:
    int end;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> end;
    }

    void solve(void) {
        unsigned long long answer = 1;
        for (int begin = 2 ; begin <= end ; begin++) {
            answer = answer * begin;
        }
        cout << answer;
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