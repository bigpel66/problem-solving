#include <iostream>
#include <set>
#include <string>

using namespace std;

class sol {
private:
    int number_of_test, number_of_command;
    int value;
    string command;
    multiset<int> ms;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_test ; i++) {
            cin >> number_of_command;
            for (int j = 0 ; j < number_of_command ; j++) {
                cin >> command >> value;
                if (command == "I") {
                    ms.insert(value);
                    continue;
                }
                if (ms.empty()) {
                    continue;
                }
                if (value == 1) {
                    ms.erase(--ms.rbegin().base());
                } else {
                    ms.erase(ms.begin());
                }
            }
            if (ms.empty()) {
                cout << "EMPTY\n";
            }  else {
                cout << *ms.rbegin() << ' ' << *ms.begin() << '\n';
            }
            ms.clear();
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