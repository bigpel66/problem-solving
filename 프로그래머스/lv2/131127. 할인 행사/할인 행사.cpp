#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

bool is_available(int current, vector<string>& discount, unordered_map<string, int> requirement) {
    for (int i = current ; i < current  + 10 ; i++) {
        if (requirement.find(discount.at(i)) != requirement.end()) {
            requirement[discount.at(i)]--;
        }
    }
    for (auto&& i : requirement) {
        if (i.second > 0) {
            return false;
        }
    }
    return true;
}

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    unordered_map<string, int> requirement;
    for (int i = 0 ; i < want.size() ; i++) {
        requirement[want[i]] = number[i];
    }
    for (int i = 0 ;  i < discount.size() - 9 ; i++) {
        if (is_available(i, discount, requirement)) {
            answer++;
        }
    }
    return answer;
}