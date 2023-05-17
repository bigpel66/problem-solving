#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

unordered_map<string, int> generate_dictionary() {
    vector<int> answer;
    unordered_map<string, int> um;
    for (int i = 0 ; i < 26 ; i++) {
        um[string(1, 'A' + i)] = i + 1;
    }
    return um;
}

vector<int> solution(string msg) {
    vector<int> answer;
    unordered_map<string, int>&& um = generate_dictionary();
    string cur;
    for (int i = 0 ; i < msg.length() ; i++) {
        cur.push_back(msg.at(i));
        if (um.find(cur) == um.end()) {
            answer.push_back(um[cur.substr(0, cur.length() - 1)]);
            um[cur] = um.size() + 1;
            cur = cur.substr(cur.length() - 1);
        }
    }
    answer.push_back(um[cur]);
    return answer;
}