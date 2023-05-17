#include <iostream>
#include <algorithm>
#include <climits>
#include <cmath>
#include <string>
#include <string_view>
#include <regex>
#include <vector>

using namespace std;

string_view compress_string(int unit, string_view& sv) {
    string result;
    string_view&& temp = sv.substr(0, unit);
    int count = 0;
    for (int i = 0 ; i < sv.length() ; i += unit) {
        if (sv.substr(i, unit) == temp) {
            count++;
        } else {
            if (count > 1) {
                result += to_string(count);
            }
            result += string(temp);
            temp = sv.substr(i, unit);
            count = 1;
        }
    }
    if (count > 1) {
        result += to_string(count);
    }
    result += string(temp);
    return string_view(result);
}

int solution(string s) {
    size_t answer = s.length();
    string_view sv(s);
    for (int i = 1 ; i <= s.length() / 2 ; i++) {
        const string_view&& compressed = compress_string(i, sv);
        answer = min(compressed.length(), answer);
    }
    return answer;
}