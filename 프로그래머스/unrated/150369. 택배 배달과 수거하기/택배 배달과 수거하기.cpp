#include <vector>

using namespace std;

long long solution(int cap, int n, vector<int> deliveries, vector<int> pickups) {
    long long answer = 0;
    long long give = 0;
    long long take = 0;
    for (int i = n - 1 ; i >= 0 ; i--) {
        if (!deliveries.at(i) && !pickups.at(i)) {
            continue;
        }
        long long count = 0;
        while (give < deliveries.at(i) || take < pickups.at(i)) {
            give += cap;
            take += cap;
            count++;
        }
        give -= deliveries.at(i);
        take -= pickups.at(i);
        answer = answer + (i + 1) * count * 2;
    }
    return answer;
}