#include <algorithm>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

vector<string> split(string& s, const string& delim) {
    vector<string> vec;
    string temp;
    stringstream ss(s);
    while (ss >> temp) {
        if (temp != delim) {
            vec.push_back(temp);   
        }
    }
    return vec;
}

int to_type_enum(int index, string& s) {
    switch (index) {
        case 0:
            if (s.at(0) == 'c') {
                return 1;
            } else if (s.at(0) == 'j') {
                return 2;
            } else if (s.at(0) == 'p') {
                return 3;
            }
            break;
        case 1:
            if (s.at(0) == 'b') {
                return 1;
            } else if (s.at(0) == 'f') {
                return 2;
            }
            break;
        case 2:
            if (s.at(0) == 'j') {
                return 1;
            } else if (s.at(0) == 's') {
                return 2;
            }
            break;
        case 3:
            if (s.at(0) == 'c') {
                return 1;
            } else if (s.at(0) == 'p') {
                return 2;
            }
            break;
    }
    return 0;
}

void parse_info(vector<int> db[4][3][3][3], vector<string>& info) {
    for (int i = 0 ; i < info.size() ; i++) {
        vector<string>&& vec = split(info.at(i), R"( )");
        int L = to_type_enum(0, vec.at(0));
        int D = to_type_enum(1, vec.at(1));;
        int C = to_type_enum(2, vec.at(2));;
        int F = to_type_enum(3, vec.at(3));;
        int score = stoi(vec.at(4));
        db[L][D][C][F].push_back(score);
        db[L][0][0][0].push_back(score);
        db[0][D][0][0].push_back(score);
        db[0][0][C][0].push_back(score);
        db[0][0][0][F].push_back(score);
        db[L][D][0][0].push_back(score);
        db[L][0][C][0].push_back(score);
        db[L][0][0][F].push_back(score);
        db[0][D][C][0].push_back(score);
        db[0][D][0][F].push_back(score);
        db[0][0][C][F].push_back(score);
        db[L][D][C][0].push_back(score);
        db[L][D][0][F].push_back(score);
        db[L][0][C][F].push_back(score);
        db[0][D][C][F].push_back(score);
        db[0][0][0][0].push_back(score);
    }
}

void sort_all_types(vector<int> db[4][3][3][3]) {
    for (int i = 0 ; i < 4 ; i++) {
        for (int j = 0 ; j < 3 ; j++) {
            for (int k = 0 ; k < 3 ; k++) {
                for (int l = 0 ; l < 3 ; l++) {
                    sort(db[i][j][k][l].begin(), db[i][j][k][l].end());
                }
            }
        }
    }
}

int count_filtered(vector<int>& vec, int score) {
    int count = 0;
    for (auto&& i : vec) {
        if (i >= score) {
            count++;
        }
    }
    return count;
}

vector<int> filter_queries(vector<int> db[4][3][3][3], vector<string> query) {
    vector<int> answer;
    for (int i = 0 ; i < query.size() ; i++) {
        vector<string>&& vec = split(query.at(i), R"(and)");
        int L = to_type_enum(0, vec.at(0));
        int D = to_type_enum(1, vec.at(1));
        int C = to_type_enum(2, vec.at(2));
        int F = to_type_enum(3, vec.at(3));
        answer.push_back(count_filtered(db[L][D][C][F], stoi(vec.at(4))));
    }
    return answer;
}

vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> db[4][3][3][3];
    parse_info(db, info);
    sort_all_types(db);
    return filter_queries(db, query);
}