#include <vector>
#include <set>
#include <string>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    set<string> spoken;
    for (int i = 0 ;  i < words.size() ; i++) {
        if (spoken.count(words.at(i)) != 0) {
            return vector<int>{(i % n) + 1, i / n + 1};
        }
        spoken.insert(words.at(i));
    }
    for (int i = 0 ; i < words.size() - 1 ; i++) {
        string s1 = words.at(i);
        string s2 = words.at(i + 1);
        if (s1.at(s1.length() - 1) != s2.at(0)) {
            return vector<int>{(i + 1) % n + 1, (i + 1) / n  + 1};
        }
    }
    return vector<int>{0, 0};
}