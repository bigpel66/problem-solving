#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<vector<int>> targets) {
    int answer = 1;
    sort(targets.begin(), targets.end(), [](auto&& i, auto&& j) -> bool {
        return i.at(1) == j.at(1) ? i.at(0) < j.at(0) : i.at(1) < j.at(1);
    });
    int overlapped = targets.at(0).at(1);
    for (int i = 0 ; i < targets.size() ; i++) {
        int begin = targets.at(i).at(0);
        int end = targets.at(i).at(1);
        if (begin < overlapped) {
            continue;
        }
        answer++;
        overlapped = end;
        
    }
    return answer;
}