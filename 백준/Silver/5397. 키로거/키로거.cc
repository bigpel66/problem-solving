#include <iostream>
#include <list>
#include <string>

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
        string cmd;
        list<char> answer;
        cin >> cmd;
        auto&& iter = answer.begin();
        for (auto&& i : cmd) {
            if (i == '<') {
                if (iter != answer.begin()) {
                    iter--;
                }
            } else if (i == '>') {
                if (iter != answer.end()) {
                    iter++;
                }
            } else if (i == '-') {
                if (iter != answer.begin()) {
                    iter = answer.erase(--iter);
                }
            } else {
                iter = answer.insert(iter, i);
                iter++;
            }
        }
        for (auto&& i : answer) {
            cout << i;
        }
        cout << '\n';
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