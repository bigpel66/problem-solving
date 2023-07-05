#include <iostream>

using namespace std;

class sol {
private:
    int number_of_test;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    void solve(void) {
        string s;
        cin >> s;
        cout << (s.length() >= 6 && s.length() <= 9 ? "yes\n" : "no\n");
    }

public:
    sol(void) {
        stream();
        get_input();
        while (number_of_test--) {
            solve();
        }
    }
};

int main(void) {
    sol ve;
    return 0;
}