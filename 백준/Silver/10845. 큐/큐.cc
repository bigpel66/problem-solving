#include <iostream>
#include <queue>

using namespace std;

class sol {
    private:
        int number_of_command;
        int value;
        string command;
        queue<int> q;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> number_of_command;
        }
        
        void solve(void) {
            for (int i = 0 ; i < number_of_command ; i++) {
                cin >> command;
                if (command == "push") {
                    cin >> value;
                    q.push(value);
                } else if (command == "front") {
                    if (!q.empty()) {
                        cout << q.front() << '\n';
                    } else {
                        cout << -1 << '\n';
                    }
                } else if (command == "back") {
                    if (!q.empty()) {
                        cout << q.back() << '\n';
                    } else {
                        cout << -1 << '\n';
                    }
                } else if (command == "size") {
                    cout << q.size() << '\n';
                } else if (command == "empty") {
                    cout << q.empty() << '\n';
                } else if (command == "pop") {
                    if (!q.empty()) {
                        cout << q.front() << '\n';
                        q.pop();
                    } else {
                        cout << -1 << '\n';
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