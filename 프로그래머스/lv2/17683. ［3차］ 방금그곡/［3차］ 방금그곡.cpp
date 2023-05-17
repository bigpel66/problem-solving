#include <algorithm>
#include <climits>
#include <cmath>
#include <string>
#include <regex>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

vector<string> re_split(string s, const regex& r) {
    vector<string> vec;
    regex_token_iterator<string::iterator> iter(s.begin(), s.end(), r, -1);
    regex_token_iterator<string::iterator> end;
    while (iter != end) {
        vec.push_back(*iter++);
    }
    return vec;
}

int re_count(string s, const regex& r) {
    regex_iterator<string::iterator> iter(s.begin(), s.end(), r);
    regex_iterator<string::iterator> end;
    return distance(iter, end);
}

string replace_all(const string& s, const string& old_s, const string& new_s) {
    string replaced(s);
    size_t pos = 0;
    size_t offset = 0;
    while ((pos = replaced.find(old_s)) != string::npos) {
        replaced = replaced.replace(replaced.begin() + pos, replaced.begin() + pos + old_s.size(), new_s);
        offset = pos + new_s.size();
    }
    return replaced;
}

string replace_rounds(const string& s)  {
    string result(s);
    result = replace_all(result, "C#", "c");
    result = replace_all(result, "D#", "d");
    result = replace_all(result, "F#", "f");
    result = replace_all(result, "G#", "g");
    result = replace_all(result, "A#", "a");
    return result;
}

int duration(const string& s) {
    int v0 = s.at(0) - '0';
    int v1 = s.at(1) - '0';
    int v3 = s.at(3) - '0';
    int v4 = s.at(4) - '0';
    return (v0 * 10 + v1) * 60 + (v3 * 10 + v4);
}

int duration_diff(const string& s1, const string& s2) {
    return duration(s2) - duration(s1);
}

string repeat(const string& s, int count) {
    string result;
    while (--count >= 0) {
        result += s;
    }
    return result;
}

unordered_map<string, pair<int, int>> generate_playlist(const vector<string>& musicinfos, unordered_map<string, string>& notes) {
    unordered_map<string, pair<int, int>> playlist;
    for (int i = 0 ; i < musicinfos.size() ; i++) {
        vector<string>&& m = re_split(musicinfos.at(i), regex(R"(,)"));
        string note = replace_rounds(m.at(3));
        int diff = duration_diff(m.at(0), m.at(1));
        int count = re_count(note, regex(R"(C|c|D|d|E|F|f|G|g|A|a|B)"));
        if (diff < count) {
            note = note.substr(0, diff % count);
        } else {
            string temp = repeat(note, diff / count);
            temp += note.substr(0, diff % count);
            note = temp;
        }
        playlist[m.at(2)] = pair<int, int>(i, diff);
        notes[m.at(2)] = note;
    }
    return playlist;
}

unordered_set<string> find_candidates(const string& s, const unordered_map<string, string> notes) {
    unordered_set<string> result;
    for (auto&& i : notes) {
        if (i.second.find(s) != string::npos) {
            result.insert(i.first);
        }
    }
    return result;
}

string find_target(unordered_set<string>& candidates, unordered_map<string, pair<int, int>>& playlist) {
    int value = INT_MIN;
    for (auto&& i : candidates) {
        value = max(value, playlist[i].second);
    }
    unordered_set<string> temp;
    for (auto&& i : candidates) {
        if (playlist[i].second == value) {
            temp.insert(i);
        }
    }
    int index = INT_MAX;
    for (auto&& i : temp) {
        index = min(index, playlist[i].first);
    }
    for (auto&& i : temp) {
        if (playlist[i].first == index) {
            return i;
        }
    }
    return "(None)";
}

string solution(string m, vector<string> musicinfos) {
    m = replace_rounds(m);
    unordered_map<string, string> notes;
    unordered_map<string, pair<int, int>>&& playlist = generate_playlist(musicinfos, notes);
    unordered_set<string>&& candidates = find_candidates(m, notes);
    return find_target(candidates, playlist);
}