#include <deque>
#include <iostream>
#include <string>

using namespace std;

class sol {
    private:
        int number_of_command;
        int value;
        string command;
        deque<int> dq;
        
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
                if (command == "push_front") {
                    cin >> value;
                    dq.push_front(value);
                } else if (command == "push_back") {
                    cin >> value;
                    dq.push_back(value);
                } else if (command == "pop_front") {
                    if (dq.empty()) {
                        cout << -1 << '\n';
                    } else {
                        cout << dq.front() << '\n';
                        dq.pop_front();
                    }                    
                } else if (command == "pop_back") {
                    if (dq.empty()) {
                        cout << -1 << '\n';
                    } else {
                        cout << dq.back() << '\n';
                        dq.pop_back();
                    }
                } else if (command == "size") {
                    cout << dq.size() << '\n';
                } else if (command == "empty") {
                    cout << dq.empty() << '\n';
                } else if (command == "front") {
                    if (dq.empty()) {
                        cout << -1 << '\n';
                    } else {
                        cout << dq.front() << '\n';
                    }                    
                } else if (command == "back") {
                    if (dq.empty()) {
                        cout << -1 << '\n';
                    } else {
                        cout << dq.back() << '\n';
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