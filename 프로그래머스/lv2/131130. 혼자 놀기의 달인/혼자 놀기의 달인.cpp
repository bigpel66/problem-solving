#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> cards) {
    vector<int> answer;
    vector<bool> is_visited(cards.size(), false);
    while (true) {
        int count = 0;
        int number = -1;
        for (int i = 0 ; i < is_visited.size() ; i++) {
            if (!is_visited[i]) {
                number = i;
                break;
            }
        }
        if (number == -1) {
            break;
        }
        while (true) {
            number = cards.at(number) - 1;
            if (is_visited[number]) {
                break;
            }
            count++;
            is_visited[number] = true;
        }
        answer.push_back(count);
    }
    sort(answer.begin(), answer.end(), greater<int>());
    return answer.size() == 1 ? 0 : answer.at(0) * answer.at(1);
}