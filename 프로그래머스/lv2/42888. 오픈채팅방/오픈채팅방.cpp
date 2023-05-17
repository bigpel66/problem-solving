#include <iostream>
#include <regex>
#include <string>
#include <unordered_map>
#include <vector>

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

void parse_records(const vector<string>& record, unordered_map<string, string>& nicknames, vector<string>& events) {
    for (auto&& i : record) {
        vector<string> split = resplit(i, regex(R"(\s+)"));
        if (split.at(0) == "Enter") {
            nicknames[split.at(1)] = split.at(2);
            events.push_back(split.at(1) + "!!님이 들어왔습니다.");
        } else if (split.at(0) == "Change") {
            nicknames[split.at(1)] = split.at(2);
        } else {
            events.push_back(split.at(1) + "!!님이 나갔습니다.");
        }
    }
}

void reflect_nicknames_to_events(unordered_map<string, string>& nicknames, vector<string>& events) {
    for (auto&& i : events) {
        vector<string> split = resplit(i, regex(R"(!!)"));
        i = nicknames[split.at(0)] + split.at(1);
    }
}

vector<string> solution(vector<string> record) {
    unordered_map<string, string> nicknames;
    vector<string> events;
    parse_records(record, nicknames, events);
    reflect_nicknames_to_events(nicknames, events);
//     for (auto&& i : nicknames) {
//         cout << i.first << " " << i.second << endl;
        
//     }
//     for (auto&& i : events) {
//         cout << i << endl;
//     }
    return events;
}