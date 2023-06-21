#include <deque>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_card;
    vector<int> cmd;
    deque<int> init;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_card;
        cmd = vector<int>(number_of_card);
        for (int i = 0 ; i < number_of_card ; i++) {
            cin >> cmd[i];
        }
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_card ; i++) {
            int cur_cmd = cmd.at(number_of_card - 1 - i);
            if (cur_cmd == 1) {
                init.push_front(i + 1);
            } else if (cur_cmd == 2) {
                int temp = init.front();
                init.pop_front();
                init.push_front(i + 1);
                init.push_front(temp);
            } else {
                init.push_back(i + 1);
            }
        }
        for (auto&& i : init) {
            cout << i << ' ';
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