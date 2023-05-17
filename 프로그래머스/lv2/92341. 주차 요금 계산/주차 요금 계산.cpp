#include <cmath>
#include <iostream>
#include <regex>
#include <string>
#include <vector>
#include <map>

using namespace std;

vector<string> resplit(string s, regex r) {
    vector<string> result;
    regex_token_iterator<string::iterator> iter(s.begin(), s.end(), r, -1);
    regex_token_iterator<string::iterator> end;
    while (iter != end) {
        result.push_back(*iter++);
    }
    return result;
}

int duration(string s) {
     vector<string> spec = resplit(s, regex(R"(:)"));
    return stoi(spec.at(0)) * 60 + stoi(spec.at(1));
}


int duration_diff(string in, string out) {
    return duration(out) - duration(in);
}

map<string, int> generate_parking_map(vector<string>& records) {
    map<string, string> parking;
    map<string, int> result;
    for (auto&& i : records) {
        vector<string> vec = resplit(i, regex(R"(\s+)"));
        if (parking.find(vec.at(1)) != parking.end()) {
            string in = parking[vec.at(1)];
            parking.erase(vec.at(1));
            result[vec.at(1)] += duration_diff(in, vec.at(0));
        } else {
            parking[vec.at(1)] = vec.at(0);
        }
    }
    for (auto&& i : parking) {
        result[i.first] += duration_diff(i.second, "23:59");
    }
    return result;
}

vector<int> parking_to_cost(vector<int> fees, map<string, int> parking) {
    vector<int> answer;
    int default_duration = fees.at(0);
    int default_cost = fees.at(1);
    int unit_duration = fees.at(2);
    int unit_cost = fees.at(3);
    for(auto&& i : parking) {
        int cost = ceil((static_cast<double>(i.second) - default_duration) / unit_duration) * unit_cost;
        answer.push_back(cost < 0 ? default_cost : default_cost + cost);
    }
    return answer;
}

vector<int> solution(vector<int> fees, vector<string> records) {
    map<string, int>&& parking = generate_parking_map(records);
    return parking_to_cost(fees, parking);
}