#include <vector>

using namespace std;

vector<int> generate(int n) {
    vector<int> vec;
    for (int i = 0 ; i < n ; i++) {
        vec.push_back(i + 1);
    }
    return vec;
}

long long factorial(int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial(n - 1);
}

vector<int> solution(int n, long long k) {
    vector<int> answer;
    vector<int>&& seq = generate(n);
    long long&& fac = factorial(n - 1);
    k--;
    while (--n > 0) {
        long long index = k / fac;
        k %= fac;
        answer.push_back(seq.at(index));
        seq.erase(seq.begin() + index);
        fac /= n;
    }
    answer.push_back(seq.at(0));
    return answer;
}