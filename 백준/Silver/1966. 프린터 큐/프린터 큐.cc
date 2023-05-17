#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;
using entry = pair<int, int>;

class sol {
    private:
        int number_of_test;
        int number_of_entry;
        int target;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> number_of_test;
        }
        
        void solve(void) {
            int temp;
            for (int i = 0 ; i < number_of_test ; i++) {
                queue<entry> q;
                priority_queue<int> order;
                cin >> number_of_entry >> target;
                for (int j = 0 ; j < number_of_entry ; j++) {
                    cin >> temp;
                    q.push({j, temp});
                    order.push(temp);
                }
                int index = 1;
                while (!q.empty()) {
                    entry cur_peek = q.front();
                    int order_peek = order.top();
                    q.pop();
                    order.pop();
                    if (cur_peek.second < order_peek) {
                        q.push(cur_peek);
                        order.push(order_peek);
                        continue;
                    }
                    if (cur_peek.first == target) {
                        cout << index << '\n';
                        break;
                    }
                    index++;
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