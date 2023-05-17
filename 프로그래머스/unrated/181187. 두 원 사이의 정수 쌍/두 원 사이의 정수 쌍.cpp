#include <cmath>

using namespace std;

int count(bool is_inner, int current, int radius) {
    double count = sqrt(pow(static_cast<double>(radius), 2) - pow(static_cast<double>(current), 2));
    int cut_down = floor(count);
    if (is_inner && count == static_cast<double>(cut_down)) {
        return cut_down - 1;
    }
    return cut_down;
}

long long solution(int r1, int r2) {
    long long answer = 0;
    for (int i = 1; i < r2 ; i++) {
        if (i < r1) {
            answer += (count(false, i , r2) - count(true, i , r1));
        } else {
            answer += count(false, i, r2);
        }
    }
    answer *= 4;
    answer += (r2 - r1 + 1) * 4;
    return answer;
}