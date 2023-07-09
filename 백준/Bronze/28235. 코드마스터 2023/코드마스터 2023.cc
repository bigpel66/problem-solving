#include <iostream>
#include <string>

using namespace std;

class sol {
private:
    string s;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> s;
    }

    void solve(void) {
        if (s == "SONGDO") {
            cout << "HIGHSCHOOL";
        } else if (s == "CODE") {
            cout << "MASTER";
        } else if (s == "2023") {
            cout << "0611";
        } else if (s == "ALGORITHM") {
            cout << "CONTEST";
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