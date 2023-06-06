#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_contribution, cutline;
    vector<int> rating;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_contribution;
        rating = vector<int>(number_of_contribution);
        for (int i = 0 ; i < number_of_contribution ; i++) {
            cin >> rating[i];
        }
        sort(rating.begin(), rating.end(), less<int>());
        cutline = round(static_cast<double>(number_of_contribution) * 15 / 100);
    }

    void solve(void) {
        if (!number_of_contribution) {
            cout << 0;
            return;
        }
        int sum = 0;
        for (auto&& iter = rating.begin() + cutline ; iter != rating.end() - cutline ; iter++) {
            sum += *iter;
        }
        cout << round(static_cast<double>(sum) / (number_of_contribution - cutline * 2));
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