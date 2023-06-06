#include <algorithm>
#include <climits>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class sol {
private:
    int number_of_test;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> number_of_test;
    }

    int get_psycological_distance(vector<string>& candidates) {
        int count = 0;
        for (int i = 0 ; i < 4 ; i++) {
            if (candidates.at(0).at(i) != candidates.at(1).at(i)) {
                count++;
            }
            if (candidates.at(0).at(i) != candidates.at(2).at(i)) {
                count++;
            }
            if (candidates.at(1).at(i) != candidates.at(2).at(i)) {
                count++;
            }
        }
        return count;
    }

    void solve(void) {
        int number_of_person;
        cin >> number_of_person;
        vector<string> mbti;
        for (int i = 0 ; i < number_of_person ; i++) {
            string temp;
            cin >> temp;
            mbti.push_back(temp);
        }
        if (number_of_person > 32) {
            cout << 0 << '\n';
            return;
        }
        int count = INT_MAX;
        for (int i = 0 ; i < number_of_person - 2 ; i++) {
            for (int j = i + 1 ; j < number_of_person - 1 ; j++) {
                for (int k = j + 1 ; k < number_of_person ; k++) {
                    vector<string> candidates;
                    candidates.push_back(mbti.at(i));
                    candidates.push_back(mbti.at(j));
                    candidates.push_back(mbti.at(k));
                    count = min(count, get_psycological_distance(candidates));
                }
            }
        }
        cout << count << '\n';
    }

public:
    sol(void) {
        stream();
        get_input();
        while (number_of_test--) {
            solve();
        }
    }
};

int main(void) {
    sol ve;
    return 0;
}