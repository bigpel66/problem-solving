#include <iostream>
#include <vector>

using namespace std;
using record = vector<long long>;
using matrix = vector<record>;

matrix operator*(const matrix& x, const matrix& y) {
    matrix temp(x.size(), record(y.at(0).size(), 0));
    for (int i = 0 ; i < temp.size() ; i++) {
        for (int j = 0 ; j < temp.at(0).size() ; j++) {
            for (int k = 0 ; k < y.size() ; k++) {
                temp[i][j] += x.at(i).at(k) * y.at(k).at(j);
            }
            temp[i][j] %= 1'000'000'007;
        }
    }
    return temp;
}

class sol {
private:
    long long n;
    matrix answer, recur;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> n;
    }

    void solve(void) {
        answer = matrix{{1, 0}, {0, 1}};
        recur = matrix{{1, 1}, {1, 0}};
        while (n > 0) {
            if (n % 2) {
                answer = answer * recur;
            }
            recur = recur * recur;
            n /= 2;
        }
        cout << answer.at(0).at(1);
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