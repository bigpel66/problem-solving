#include <cmath>
#include <string>
#include <vector>

using namespace std;

string to_n_base(long long number, int base) {
    static const string set("0123456789ABCDEF");
    string s;
    while (number) {
        s += set[number % base];
        number /= base;
    }
    return string(s.rbegin(), s.rend());
}

string pad_zero(string&& s) {
    size_t full_length = pow(2, floor(log2(s.length()) + 1)) - 1;
    return string(full_length - s.length(), '0') + s;
}

bool is_all_zero(string& s) {
    for (auto&& i : s) {
        if (i != '0') {
            return false;
        }
    }
    return true;
}

bool is_valid(string& s) {
    if (s.length() == 1 || is_all_zero(s)) {
        return true;
    }
    int mid = s.length() / 2;
    if (s.at(mid) == '0') {
        return false;
    }
    string&& left = s.substr(0, mid);
    string&& right = s.substr(mid + 1);
    return is_valid(left) && is_valid(right);
}

vector<int> solution(vector<long long> numbers) {
    vector<int> answer;
    for (auto&& i : numbers) {
        string&& bin = pad_zero(to_n_base(i, 2));
        answer.push_back(is_valid(bin));
    }
    return answer;
}