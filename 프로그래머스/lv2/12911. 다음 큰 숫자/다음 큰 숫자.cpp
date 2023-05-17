#include <bitset>

using namespace std;

int solution(int n) {
    bitset<32> bit(n);
    int count = bit.count();
    while (true) {
        bitset<32> target(++n);
        if (target.count() == count) {
            return n;
        }
    }
}