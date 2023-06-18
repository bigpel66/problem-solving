#include <iostream>
#include <queue>

using namespace std;

class sol {
private:
    size_t size;
    int round;
    queue<int> q;
    vector<int> answer;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> size >> round;
        for (size_t i = 1 ; i <= size ; i++) {
            q.push(i);
        }
    }

    void solve(void) {
        cout << '<';
        while(q.size() > 1) {
            for (int i = 1 ; i < round ; i++) {
                q.push(q.front());
                q.pop();
            }
            cout << q.front() << ", ";
            q.pop();
        }
        cout << q.front() << '>';
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