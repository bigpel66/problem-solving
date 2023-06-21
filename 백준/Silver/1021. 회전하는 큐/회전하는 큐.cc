#include <algorithm>
#include <cmath>
#include <iostream>
#include <deque>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_size;
    int number_of_pick;
    int answer;
    vector<int> sequence;
    deque<int> dq;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_size >> number_of_pick;
        answer = 0;
        sequence = vector<int>(number_of_pick);
        for (int i = 0 ; i < number_of_pick ; i++) {
            cin >> sequence[i];
        }
        for (int i = 1 ; i <= number_of_size ; i++) {
            dq.push_back(i);
        }
    }

    void solve(void) {
        for (int i = 0 ;  i < sequence.size() ; i++) {
            int target = sequence.at(i);
            int index = find(dq.begin(), dq.end(), target) - dq.begin();
            int limit = round(static_cast<double>(dq.size()) / 2);
            if (limit <= index) {
                for (int j = dq.size() - 1 ; j >= index ; j--) {
                    dq.push_front(dq.back());
                    dq.pop_back();
                    answer++;
                }
            } else {
                for (int j = 0 ; j < index ; j++) {
                    dq.push_back(dq.front());
                    dq.pop_front();
                    answer++;
                }
            }
            dq.pop_front();
        }
        cout << answer;
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