#include <algorithm>
#include <vector>
#include <map>

using namespace std;

int solution(int k, vector<int> tangerine) {
    map<int, int> countMap;
    vector<pair<int, int>> countVec; 
    for (auto&& i : tangerine) {
        countMap[i]++;
    }
    for (auto&& i : countMap) {
        countVec.push_back(i);
    }
    sort(countVec.begin(), countVec.end(), [](auto&& i, auto&& j) -> bool {
      return i.second > j.second;
    });
    int answer = 0;
    for (auto&& i = countVec.begin() ; i != countVec.end() ; i++) {
        answer++;
        k -= i->second;
        if (k <= 0) {
            break;
        }
    }
    return answer;
}