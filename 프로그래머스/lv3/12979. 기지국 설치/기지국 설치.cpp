#include <vector>

using namespace std;

int solution(int n, vector<int> stations, int w) {
    int answer = 0;
    int index = 0;
    int start = 1;
    while (start <= n) {
        if (start >= stations[index] - w && start <= stations[index] + w) {
            start = stations[index++] + w;
        } else {
            start += 2 * w;
            answer++;
        }
        start++;
    }
    return answer;
}