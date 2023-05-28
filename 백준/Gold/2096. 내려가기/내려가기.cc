#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int n;
    int cur[3], mini[3], maxi[3];

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> n;
        fill(begin(cur), end(cur), 0);
        fill(begin(mini), end(mini), 0);
        fill(begin(maxi), end(maxi), 0);
    }

    void get_cur(void) {
        for (int i = 0 ; i < 3 ; i++) {
            cin >> cur[i];
        }
    }

    void calc_maxi(void) {
        int temp[3];
        copy(begin(maxi), end(maxi), begin(temp));
        maxi[0] = max(temp[0], temp[1]) + cur[0];
        maxi[1] = max({temp[0], temp[1], temp[2]}) + cur[1];
        maxi[2] = max(temp[1], temp[2]) + cur[2];
    }

    void calc_mini(void) {
        int temp[3];
        copy(begin(mini), end(mini), begin(temp));
        mini[0] = min(temp[0], temp[1])+ cur[0];
        mini[1] = min({temp[0], temp[1], temp[2]}) + cur[1];
        mini[2] = min(temp[1], temp[2]) + cur[2];
    }

    void solve(void) {
        for (int i = 1 ; i <= n ; i++) {
            get_cur();
            calc_maxi();
            calc_mini();
        }
        cout << max({maxi[0], maxi[1], maxi[2]}) << ' ' << min({mini[0], mini[1], mini[2]});
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