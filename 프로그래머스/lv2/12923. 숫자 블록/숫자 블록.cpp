#include <cmath>
#include <vector>

using namespace std;

int biggest_divisor(long long number) {
    if (number == 1) {
        return 0;
    }
    vector<long long> candidates;
    for (int i = 2 ; i <= sqrt(number) ; i++) {
        if (number % i == 0) {
            candidates.push_back(i);
            if (number / i <= 10'000'000) {  
                return number / i;
            }
        }
    }
    if (!candidates.empty()) {
        long long v1 = candidates.at(candidates.size() - 1);
        long long v2 = number / candidates.at(candidates.size() - 1);
        if (v1 > 10'000'000 && v2 <= 10'000'000) {
            return v2;
        } else if (v2 > 10'000'000 && v1 <= 10'000'000) {
            return v1;
        } else if (v1 <= 10'000'000 && v2 <= 10'000'000) {
            return v1 > v2 ? v1 : v2;
        }
    }
    return 1;
}

vector<int> solution(long long begin, long long end) {
    vector<int> answer;
    for (long long i = begin ; i <= end ; i++) {
        answer.push_back(biggest_divisor(i));
    }
    return answer;
}