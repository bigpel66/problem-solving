#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    vector<pair<int, int>> intervals;
    int sum = 0;
    int left = 0;
    int right = -1;
    while (true) {
        if (sum < k) {
            if (++right >= sequence.size()) {
                break;
            }
            sum += sequence.at(right);
        } else {
            sum -= sequence.at(left);
            if (++left >= sequence.size()) {
                break;
            }
        }
        if (sum == k) {
            intervals.push_back(pair<int, int>(left, right));
        }
    }
    sort(intervals.begin(), intervals.end(), [](auto&& i, auto&& j) -> bool {
        return i.second - i.first == j.second - j.first ? i.first < j.first : i.second - i.first < j.second - j.first;
    });
    return vector<int>{intervals.at(0).first, intervals.at(0).second};
}