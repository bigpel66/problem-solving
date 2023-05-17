#include <climits>
#include <cmath>
#include <string>
#include <vector>

using namespace std;

vector<int> convert_minerals_to_stresses(const vector<string>& minerals) {
    static const int start_index = 0;
    vector<int> stresses;
    for (auto&& i : minerals) {
        if (i.find("d") == start_index) {
            stresses.push_back(25);
        } else if (i.find("i") == start_index) {
            stresses.push_back(5);
        } else {
            stresses.push_back(1);
        }
    }
    return stresses;
}

bool is_out_of_stock(vector<int>& picks) {
    return !picks.at(0) && !picks.at(1) && !picks.at(2);
}

bool is_all_collected(int count, size_t size) {
    return static_cast<size_t>(count) * 5 >= size;
}

int calc_stress(int index, int count, const vector<int>& stresses) {
    int sum = 0;
    int div = pow(5, 2 - index);
    for (int i = 5 * count; i < 5 * (count + 1) && i < stresses.size() ; i++) {
        int cur = stresses.at(i) / div;
        sum += cur == 0 ? 1 : cur;
    }
    return sum;
}

void dfs(int count, int acc, int& answer, const vector<int>& stresses, vector<int>& picks) {
    if (is_out_of_stock(picks) || is_all_collected(count, stresses.size())) {
        answer = min(answer, acc);
        return;
    }
    for (int i = 0 ; i < 3 ; i++) {
        if (picks[i]) {
            int consumption = calc_stress(i, count, stresses);
            picks[i]--;
            dfs(count + 1, acc + consumption, answer, stresses, picks);
            picks[i]++;
        }
    }
}

int solution(vector<int> picks, vector<string> minerals) {
    int answer = INT_MAX;
    vector<int>&& stresses = convert_minerals_to_stresses(minerals);
    dfs(0, 0, answer, stresses, picks);
    return answer;
}