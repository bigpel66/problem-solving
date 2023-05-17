#include <climits>
#include <vector>

using namespace std;

bool is_valid(const vector<int>& vec, int n) {
    int acc = 0;
    for (auto&& i : vec) {
        acc += i;
    }
    return acc == n;
}

bool is_replaceable(int& diff, const vector<int>& answer, const vector<int>& ryan, const vector<int>& apeach) {
    int a_sum = 0;
    int r_sum = 0;
    for (int i = 0 ; i < apeach.size() ; i++) {
        if (apeach.at(i) < ryan.at(i)) {
            r_sum += (10 - i);
        }
        if (apeach.at(i) != 0 && apeach.at(i) >= ryan.at(i)) {
            a_sum += (10 - i);
        }
    }
    if (r_sum <= a_sum || r_sum - a_sum < diff) {
        return false;
    }
    if (r_sum - a_sum > diff) {
        diff = r_sum - a_sum;
        return true;
    }
    for (int i = answer.size() - 1 ; i >= 0 ; i--) {
        if (answer.at(i) == ryan.at(i)) {
            continue;
        } else if (answer.at(i) > ryan.at(i)) {
            return false;
        } else {
            return true;
        }
    }
    return false;
}

void dfs(int count, int consume, int n, int& diff, vector<int>& answer, vector<int>& ryan, const vector<int>& apeach) {
    if (count == 11) {
        if (is_valid(ryan, n) && is_replaceable(diff, answer, ryan, apeach)) {
            answer = ryan;
        }
        return;
    }
    for (int i = 0 ; i <= n ; i++) {
        if (consume + i > n) {
            return;
        }
        ryan.push_back(i);
        dfs(count + 1, consume + i, n, diff, answer, ryan, apeach);
        ryan.pop_back();
    }
}

vector<int> solution(int n, vector<int> info) {
    int diff = INT_MIN;
    vector<int> answer;
    vector<int> ryan;
    dfs(0, 0, n, diff, answer, ryan, info);
    return answer.size() == 0 ? vector<int>{-1} : answer;
}