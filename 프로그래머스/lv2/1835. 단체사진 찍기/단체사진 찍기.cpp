#include <algorithm>
#include <cmath>
#include <string>
#include <vector>

using namespace std;

bool is_valid(int diff, int comp, char op) {
    switch (op) {
        case '=':
            return diff == comp;
        case '<':
            return diff < comp;
        case '>':
            return diff > comp;
    }
    return false;
}

bool is_answer_incrementable(const vector<string>& data, const vector<string>& characters) {
    for (auto&& i : data) {
        string&& ch1 = string(1, i.at(0));
        string&& ch2 = string(1, i.at(2));
        int i1 = find(characters.begin(), characters.end(), ch1) - characters.begin();
        int i2 = find(characters.begin(), characters.end(), ch2) - characters.begin();
        char op = i.at(3);
        int comp = i.at(4) - '0';
        if (!is_valid(abs(i1 - i2) - 1, comp, op)) {
            return false;
        }
    }
    return true;
}

void dfs(int& answer, const vector<string>& data, vector<string>& characters, vector<bool> is_visited) {
    static const vector<string> preset{"A", "C", "F", "J", "M", "N", "R", "T"};
    if (characters.size() == 8) {
        if (is_answer_incrementable(data, characters)) {
            answer++;
        }
        return;
    }
    for (int i = 0 ; i < preset.size() ; i++) {
        if (is_visited.at(i)) {
            continue;
        }
        is_visited[i] = true;
        characters.push_back(preset.at(i));
        dfs(answer, data, characters, is_visited);
        characters.pop_back();
        is_visited[i] = false;
    }
}

int solution(int n, vector<string> data) {
    int answer = 0;
    vector<string> characters;
    vector<bool> is_visited(8, false);
    dfs(answer, data, characters, is_visited);
    return answer;
}