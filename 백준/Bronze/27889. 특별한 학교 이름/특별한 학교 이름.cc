#include <iostream>

using namespace std;

class sol {
private:
    string school;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> school;
    }

    void solve(void) {
        if (school == "NLCS") {
            cout << "North London Collegiate School";
        } else if (school == "BHA") {
            cout << "Branksome Hall Asia";
        } else if (school == "KIS") {
            cout << "Korea International School";
        } else if (school == "SJA") {
            cout << "St. Johnsbury Academy";
        }
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