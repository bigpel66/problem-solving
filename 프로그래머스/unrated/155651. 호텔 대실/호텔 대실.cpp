#include <algorithm>
#include <string>
#include <utility>
#include <vector>

using namespace std;

int duration(string& s) {
    int v0 = s.at(0) - '0';
    int v1 = s.at(1) - '0';
    int v3 = s.at(3) - '0';
    int v4 = s.at(4) - '0';
    return 60 * (v0 * 10 + v1) + (v3 * 10 + v4);
}

vector<pair<int, int>> convert_ordered_duration(vector<vector<string>>& book_time) {
    vector<pair<int, int>> converted;
    for (auto&& i : book_time) {
        int&& begin = duration(i.at(0));
        int&& end = duration(i.at(1));
        converted.push_back({begin, end});
    }
    sort(converted.begin(), converted.end(), [](auto&& i, auto&& j) -> bool {
       return i.first == j.first ? i.second < j.second : i.first < j.first; 
    });
    return converted;
}

int solution(vector<vector<string>> book_time) {
    vector<int> plans;
    vector<pair<int, int>>&& converted = convert_ordered_duration(book_time);
    for (auto&& i : converted) {
        if (plans.size() == 0) {
            plans.push_back(i.second);
            continue;
        }
        bool is_req = true;
        int index = -1;
        for (int j = 0 ; j < plans.size() ; j++) {
            if (plans.at(j) + 10 <= i.first) {
                is_req = false;
                index = j;
                break;
            }
        }
        if (is_req) {
            plans.push_back(i.second);
        } else {
            plans[index] = i.second;
        }
    }
    return plans.size();
}