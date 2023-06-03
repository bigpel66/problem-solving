#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
    int target_sum;
    long long answer;
    int vec_1_size, vec_2_size;
    vector<int> v1, v2;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> target_sum;
        answer = 0;
        cin >> vec_1_size;
        v1 = vector<int>(vec_1_size);
        for (int i = 0 ; i < vec_1_size ; i++) {
            cin >> v1[i];
        }
        cin >> vec_2_size;
        v2 = vector<int>(vec_2_size);
        for (int i = 0 ; i < vec_2_size ; i++) {
            cin >> v2[i];
        }
    }

    void generate_sequence_subset(int vec_size, vector<int>& vec) {
        for (int i = 0 ; i < vec_size ; i++) {
            int sum = vec.at(i);
            for (int j = i + 1 ; j < vec_size ; j++) {
                sum += vec.at(j);
                vec.push_back(sum);
            }
        }
        sort(vec.begin(), vec.end(), less<int>());
    }

    void solve(void) {
        generate_sequence_subset(vec_1_size, v1);
        generate_sequence_subset(vec_2_size, v2);
        for (int i = 0 ; i < v1.size() ; i++) {
            int diff = target_sum - v1.at(i);
            answer += upper_bound(v2.begin(), v2.end(), diff) - lower_bound(v2.begin(), v2.end(), diff);
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