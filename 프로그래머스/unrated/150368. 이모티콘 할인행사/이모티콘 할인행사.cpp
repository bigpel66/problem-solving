#include <climits>
#include <cmath>
#include <vector>

using namespace std;

pair<int, int> estimate_selling(const vector<vector<int>>& users, const vector<int>& emoticons, const vector<int>& discounts) {
    int new_subscribers = 0;
    int new_income = 0;
    vector<double> acc(users.size(), 0);
    for (int i = 0 ; i < users.size() ; i++) {
        for (int j = 0 ; j < discounts.size() ; j++) {
            if (discounts.at(j) >= users.at(i).at(0)) {
                acc[i] += static_cast<double>(emoticons.at(j)) * (100 - discounts.at(j)) / 100;
            }
        }
    }
    for (int i = 0 ; i < users.size() ; i++) {
        if (users.at(i).at(1) <= acc.at(i)) {
            new_subscribers++;
            acc[i] = 0;
        }
        new_income += acc.at(i);
    }
    return pair<int, int>(new_subscribers, new_income);
}

void update_goal(const vector<vector<int>>& users, const vector<int>& emoticons, const vector<int>& discounts, vector<int>& answer) {
    pair<int, int> estimate = estimate_selling(users, emoticons, discounts);
    if (answer.at(0) == estimate.first) {
        answer[1] = max(answer.at(1), estimate.second);
    } else if (answer.at(0) < estimate.first) {
        answer[0] = estimate.first;
        answer[1] = estimate.second;
    }
}

void dfs(int count, const vector<vector<int>>& users, const vector<int>& emoticons, vector<int>& discounts, vector<int>& answer) {
    static vector<int> candidates{10, 20, 30, 40};
    if (count == emoticons.size()) {
        update_goal(users, emoticons, discounts, answer);
        return;
    }
    for (int i = 0 ; i < 4 ; i++) {
        discounts.push_back(candidates.at(i));
        dfs(count + 1, users, emoticons, discounts, answer);
        discounts.pop_back();
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> discounts;
    vector<int> answer{INT_MIN, INT_MIN};
    dfs(0, users, emoticons, discounts, answer);
    return answer;
}