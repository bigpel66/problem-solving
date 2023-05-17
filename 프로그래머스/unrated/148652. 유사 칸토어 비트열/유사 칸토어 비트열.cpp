#include <cmath>

using namespace std;

int number_of_default_one(int index) {
    switch (index) {
        case 0:
            return 0;
        case 1:
            return 1;
        case 2:
            return 2;
        case 3:
            return 2;
        case 4:
            return 3;
    }
    return 0;
}

int count(int n, long long index) {
    if (n <= 1) {
        return number_of_default_one(index);
    }
    long long quotient = index / static_cast<long long>(pow(5, n - 1));
    long long remainder = index % static_cast<long long>(pow(5, n - 1));
    long long acc = pow(static_cast<long long>(4), n - 1);
    if (quotient >= 3) {
        acc *= (quotient - 1);
    } else {
        acc *= quotient;
    }
    if (quotient == 2) {
        return acc;
    }
    return acc + count(n - 1, remainder);
}

int solution(int n, long long l, long long r) {
    return count(n, r) - count(n, l - 1);
}