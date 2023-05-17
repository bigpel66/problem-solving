#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> fiboVec(size_t size) {
    vector<int> vec(size);
    vec[1] = 1;
    for (int i = 2 ; i < size ; i++) {
        vec[i] = (vec.at(i - 2) + vec.at(i - 1)) % 1234567;
    }
    return vec;
}

int solution(int n) {
    vector<int> vec = fiboVec(100'001);
    return vec.at(n);
}