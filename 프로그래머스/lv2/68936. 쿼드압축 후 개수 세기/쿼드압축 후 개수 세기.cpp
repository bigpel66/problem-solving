#include <vector>

using namespace std;

bool is_all_same(int x, int y, size_t size, vector<vector<int>>& arr) {
    for (int i = x ; i < x + size ; i++) {
        for (int j = y ; j < y + size ; j++) {
            if (arr.at(i).at(j) != arr.at(x).at(y)) {
                return false;
            }
        }
    }
    return true;
}

void div_and_conq(int x, int y, size_t size, vector<vector<int>>& arr, vector<int>& answer) {
    if (size == 1) {
        answer.push_back(arr.at(x).at(y));
        return;
    }
    if (is_all_same(x, y, size, arr)) {
        answer.push_back(arr.at(x).at(y));
    } else {
        size /= 2;
        div_and_conq(x, y, size, arr, answer); 
        div_and_conq(x, y + size, size, arr, answer); 
        div_and_conq(x + size, y, size, arr, answer); 
        div_and_conq(x + size, y + size, size, arr, answer); 
    }
}

vector<int> solution(vector<vector<int>> arr) {
    vector<int> answer;
    div_and_conq(0, 0, arr.size(), arr, answer);
    int zeros = 0;
    int ones = 0;
    for (auto&& i : answer) {
        if (i) {
            ones++;
        } else {
            zeros++;
        }
    }
    return vector{zeros, ones};
}