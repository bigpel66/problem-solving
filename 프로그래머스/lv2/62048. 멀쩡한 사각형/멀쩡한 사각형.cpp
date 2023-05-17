#include <cmath>

using namespace std;

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

long long solution(int w,int h) {
    int common = gcd(w, h);
    return static_cast<long long>(w) * h - (w + h - common);
}