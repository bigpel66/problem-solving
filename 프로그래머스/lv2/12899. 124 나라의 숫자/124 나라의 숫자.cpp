#include <string>

using namespace std;

string solution(int n) {
    static string base(R"(124)");
    string answer;
    while (n) {
        answer.push_back(base.at((n - 1) % 3));
        n = n % 3 == 0 ? n / 3 - 1 : n / 3;
    }
    return string(answer.rbegin(), answer.rend());
}