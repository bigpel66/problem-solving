#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_liquid;
    long long min_sum;
    vector<int> answer;
    vector<int> liquid;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_liquid;
        min_sum = LONG_MAX;
        answer = vector<int>(3);
        liquid = vector<int>(number_of_liquid);
        for (int i = 0 ; i < number_of_liquid ; i++) {
            cin >> liquid[i];
        }
        sort(liquid.begin(), liquid.end(), less<int>());
    }

    void solve(void) {
        for (int i = 0 ; i < number_of_liquid - 2 ; i++) {
            int left = i + 1;
            int right = number_of_liquid - 1;
            while (left < right) {
                long long sum = static_cast<long long>(liquid.at(i)) + liquid.at(left) + liquid.at(right);
                if (min_sum > abs(sum)) {
                    min_sum = abs(sum);
                    answer[0] = liquid.at(i);
                    answer[1] = liquid.at(left);
                    answer[2] = liquid.at(right);
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        for (auto&& i : answer) {
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