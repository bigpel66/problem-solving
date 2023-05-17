#include <unordered_map>
#include <vector>

using namespace std;

unordered_map<int, int> init_group(vector<int>::iterator&& begin, vector<int>::iterator&& end) {
    unordered_map<int, int> group;
    while (begin != end) {
        group[*begin++]++;
    }
    return group;
}

int solution(vector<int> topping) {
    int answer = 0;
    auto&& group1 = init_group(topping.begin(), topping.begin() + 1);
    auto&& group2 = init_group(topping.begin() + 1, topping.end());
    auto&& iter = topping.begin();
    while (true) {
        if (group1.size() == group2.size()) {
            answer++;
        }
        if (++iter == topping.end()) {
            break;
        }
        group1[*iter]++;
        if (group2.at(*iter) - 1 <= 0) {
            group2.erase(*iter);
        } else {
            group2[*iter]--;
        }
    }
    return answer;
}