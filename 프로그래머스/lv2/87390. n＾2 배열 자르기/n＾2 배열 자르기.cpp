#include <cmath>
#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer(right - left + 1);
    for (auto&& i : answer) {
        i = max(left % n + 1, left / n + 1);
        left++;
    }
    return answer;
}