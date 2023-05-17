#include <unordered_map>
#include <vector>

using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    unordered_map<double, int> um;
    for (auto&& i : weights) {
        double val = static_cast<double>(i);
        answer += um[val] + um[val / 2] + um[val * 2] + um[val * 3 / 4] + um[val * 4 / 3] + um[val * 2 / 3] + um[val * 3 / 2];
        um[val]++;
    }
    return answer;
}