#include <cmath>
#include <iostream>
#include <deque>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_balloon;
    vector<int> order;
    deque<int> dq;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_balloon;
        order = vector<int>(number_of_balloon, 0);
        for (int i = 0 ; i < number_of_balloon ; i++) {
            cin >> order[i];
            dq.push_back(i);
        }
    }

    void solve(void) {
        while (!dq.empty()) {
            int step = order.at(dq.front());
            cout << dq.front() + 1 << ' ';
            dq.pop_front();
            if (step > 0) {
                for (int i = 1 ; i < step ; i++) {
                    dq.push_back(dq.front());
                    dq.pop_front();
                }
            } else {
                for (int i = 0 ; i < step * -1 ; i++) {
                    dq.push_front(dq.back());
                    dq.pop_back();
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