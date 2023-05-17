#include <algorithm>
#include <bitset>
#include <vector>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    // vector<long long> answer;
    // for (auto&& i : numbers) {
    //     long long temp = i + 1;
    //     while (true) {
    //         long long ex = temp ^ i;
    //         bitset<64> b(ex);
    //         if (b.count() == 1 || b.count() == 2) {
    //             break;
    //         }
    //         temp++;
    //     }
    //     answer.push_back(temp);
    // }
    // return answer;
    vector<long long> answer;
    for (auto&& i : numbers) {
        bitset<64> b(i);
        for (int j = 0 ; j < b.size() ; j++) {
            if (!b[j]) {
                b[j] = true;
                if (j - 1 >= 0) {
                    b[j - 1] = false;
                } 
                break;
            }   
        }
        answer.push_back(static_cast<long long>(b.to_ullong()));
    }
    return answer;
}