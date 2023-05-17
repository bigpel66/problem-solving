#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int get_timestamp(string& s) {
    int v0 = s.at(0) - '0';
    int v1 = s.at(1) - '0';
    int v3 = s.at(3) - '0';
    int v4 = s.at(4) - '0';
    return 60 * (v0 * 10 + v1) + (v3 * 10 + v4);
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    vector<pair<string, pair<int, int>>> db;
    vector<pair<string, pair<int, int>>> on;
    sort(plans.begin(), plans.end(), [](auto&& i, auto&& j) -> bool {
       return i.at(1) < j.at(1);
    });
    for (auto&& i : plans) {
        db.push_back({i.at(0), {get_timestamp(i.at(1)), stoi(i.at(2))}});
    }
    int delta = -1;
    int index = 0;
    while (++delta < 2440) {
        if (index < db.size() && db.at(index).second.first == delta) {
            on.push_back(db.at(index++));
        }
        if (on.size() != 0) {
            on[on.size() - 1].second.second--;
            if (!on.at(on.size() - 1).second.second) {
                answer.push_back(on.at(on.size() - 1).first);
                on.pop_back();
            }
        }
    }
    for (auto iter = on.rbegin() ; iter != on.rend() ; iter++) {
        answer.push_back(iter->first);
    }
    return answer;
}