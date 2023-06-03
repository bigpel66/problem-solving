#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int target_number, answer;
    vector<bool> is_prime;
    vector<int> prime_sequence;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> target_number;
        answer = 0;
    }

    void generate_prime_map(void) {
        is_prime = vector<bool>(target_number + 1 , true);
        is_prime[0] = is_prime[1] = false;
        for (int i = 4 ; i <= target_number ; i += 2) {
            is_prime[i] = false;
        }
        for (int i = 3 ; i <= sqrt(target_number) ; i += 2) {
            for (int j = i * 3 ; j <= target_number ; j += 2 * i) {
                is_prime[j] = false;
            }
        }
        for (size_t i = 0 ; i <= target_number ; i++) {
            if (is_prime.at(i)) {
                prime_sequence.push_back(i);
            }
        }
    }

    void solve(void) {
        generate_prime_map();
        int begin, end, sum;
        begin = end = sum = 0;
        while (begin <= end) {
            if (target_number <= sum) {
                sum -= prime_sequence.at(begin++);
            } else if (end == prime_sequence.size()) {
                break;
            } else {
                sum += prime_sequence.at(end++);
            }
            if (sum == target_number) {
                answer++;
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