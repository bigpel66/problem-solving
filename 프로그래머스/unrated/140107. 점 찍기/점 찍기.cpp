#include <cmath>
#include <vector>

using namespace std;

int count_availability(long long i, long long d) {
    return static_cast<int>(sqrt(d * d - i * i));
}

long long solution(int k, int d) {
    long long answer = 0;
    for (int i = 0 ; i <= d ; i += k) {
        int count = count_availability(i, d);
        answer += count / k + 1;
    }
    return answer;
}