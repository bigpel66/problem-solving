#include <queue>
#include <vector>

using namespace std;

queue<int> convert_and_sum(vector<int>& vec, long long& sum) {
    queue<int> q;
    for (auto&& i : vec) {
        sum += i;
        q.push(i);
    }
    return q;
}

int solution(vector<int> queue1, vector<int> queue2) {
    long long sum1 = 0;
    long long sum2 = 0;
    auto&& q1 = convert_and_sum(queue1, sum1);
    auto&& q2 = convert_and_sum(queue2, sum2);
    long long goal = (sum1 + sum2) / 2;
    int answer = 0;
    while (true) {
        if (answer > 2 * (q1.size() + q2.size())) {
            return -1;
        }
        if (sum1 < sum2) {
            int value = q2.front();
            q1.push(value);
            sum1 += value;
            sum2 -= value;
            q2.pop();
        } else if (sum1 > sum2) {
            int value = q1.front();
            sum1 -= value;
            sum2 += value;
            q2.push(value);
            q1.pop();
        } else {
            return answer;
        }
        answer++;
    }
}