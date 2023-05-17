#include <vector>
#include <queue>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    priority_queue<int, vector<int>, greater<int>> pq;
    int answer = 0;
    for (int i = 0 ; i < enemy.size() ; i++) {
        pq.push(enemy.at(i));
        if (pq.size() > k) {
            n -= pq.top();
            pq.pop();
        }
        if (n < 0) {
            break;
        }
        answer++;
    }
    return answer;
}