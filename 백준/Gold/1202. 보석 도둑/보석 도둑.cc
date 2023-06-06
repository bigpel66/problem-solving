#include <algorithm>
#include <iostream>
#include <queue>
#include <utility>

using namespace std;
using jewelry = pair<int, int>;

class sol {
private:
    int number_of_jewelry;
    int number_of_bag;
    long long answer;
    vector<jewelry> item;
    vector<int> bag;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_jewelry >> number_of_bag;
        answer = 0;
        item = vector<jewelry>(number_of_jewelry);
        bag = vector<int>(number_of_bag);
        for (int i = 0 ; i < number_of_jewelry ; i++) {
            cin >> item[i].first >> item[i].second;
        }
        for (int i = 0 ; i < number_of_bag ; i++) {
            cin >> bag[i];
        }
        sort(item.begin(), item.end(), less<pair<int, int>>());
        sort(bag.begin(), bag.end(), less<int>());
    }

    void solve(void) {
        priority_queue<int> pq;
        int index = 0;
        for (int i = 0 ; i < number_of_bag ; i++) {
            int bag_weight = bag.at(i);
            while (index < number_of_jewelry && item.at(index).first <= bag_weight) {
                pq.push(item.at(index++).second);
            }
            if (!pq.empty()) {
                answer += pq.top();
                pq.pop();
            }
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