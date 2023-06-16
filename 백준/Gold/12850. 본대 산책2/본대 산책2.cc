#include <iostream>
#include <vector>

using namespace std;
using ll = long long;
using record = vector<ll>;
using matrix = vector<record>;

matrix operator*(const matrix& m1, const matrix& m2) {
    matrix result(m1.size(), record(m2.at(0).size(), 0));
    for (size_t i = 0 ; i < m1.size() ; i++) {
        for (size_t j = 0 ; j < m2.at(0).size() ; j++) {
            ll temp = 0;
            for (size_t k = 0 ; k < m2.size() ; k++) {
                temp += m1.at(i).at(k) * m2.at(k).at(j);
                temp %= 1'000'000'007;
            }
            result[i][j] = temp % 1'000'000'007;
        }
    }
    return result;
}

class sol {
private:
    ll time_to_walk;
    matrix answer;
    matrix factor;

    static const matrix& identity;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> time_to_walk;
        answer = matrix(8, record(8, 0));
        for (size_t i = 0 ; i < 8 ; i++) {
            answer[i][i] = 1;
        }
        factor = identity;
    }

    void solve(void) {
        while (time_to_walk) {
            if (time_to_walk & 1) {
                answer = answer * factor;
            }
            factor = factor * factor;
            time_to_walk /= 2;
        }
        cout << answer.at(0).at(0);
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

const matrix& sol::identity{
        {0, 1, 1, 0, 0, 0, 0, 0},
        {1, 0, 1, 1, 0, 0, 0, 0},
        {1, 1, 0, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 1, 0, 0},
        {0, 0, 1, 1, 0, 1, 0, 1},
        {0, 0, 0, 1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 1, 0, 1, 0}
};

int main(void) {
    sol ve;
    return 0;
}