#include <bitset>

using namespace std;

int solution(int n) {
    bitset<32> bit(n);
    return bit.count();
}