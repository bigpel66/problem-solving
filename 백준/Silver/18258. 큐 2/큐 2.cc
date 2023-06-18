#include <iostream>
#include <deque>

using namespace std;

class sol {
private:
    int number_of_command;
    deque<int> q;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_command;
    }

    void solve(void) {
        string cmd;
        for (int i = 0 ; i < number_of_command ; i++) {
            cin >> cmd;
            if (cmd == "push") {
                int value;
                cin >> value;
                q.push_back(value);
            } else if (cmd == "pop") {
                if (q.empty()) {
                    cout << -1 << '\n';
                } else {
                    cout << q.front() << '\n';
                    q.pop_front();
                }
            } else if (cmd == "size") {
                cout << q.size() << '\n';
            } else if (cmd == "empty") {
                cout << q.empty() << '\n';
            } else if (cmd == "front") {
                if (q.empty()) {
                    cout << -1 << '\n';
                } else {
                    cout << q.front() << '\n';
                }
            } else if (cmd == "back") {
                if (q.empty()) {
                    cout << -1 << '\n';
                } else {
                    cout << q.back() << '\n';
                }
            }
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