#include <string>

using namespace std;

string to_n_base(int base, int value) {
    if (value == 0) {
        return "0";
    }
    static string set("0123456789ABCDEF");
    string result;
    while (value != 0) {
        result.push_back(set[value % base]);
        value /= base;
    }
    return string(result.rbegin(), result.rend());
}

string solution(int n, int t, int m, int p) {
    string answer;
    string temp;
    for (int i = 0 ; i < t * m ; i++) {
        string s = to_n_base(n, i);
        temp.append(s.begin(), s.end());
    }
    for (int i = 0 ; i < temp.length() ; i++) {
        if (i % m == p - 1) {
            answer.push_back(temp.at(i));
        }
        if (answer.length() == t) {
            break;
        }
    }
    return answer;
}