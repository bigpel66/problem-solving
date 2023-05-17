#include <algorithm>
#include <climits>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class sol {
    private:
        int n;
        double avg;
        int min_val, max_val;
        vector<int> v;
        vector<int> r;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
        
        void get_input(void) {
            cin >> n;
            avg = 0;
            min_val = INT_MAX;
            max_val = INT_MIN;
            r = vector<int>(8001, 0);
        }
    
        int find_freq(void) {
            int freq = *max_element(r.begin(), r.end(), less<int>());
            int count = 0;
            int target;
            for (size_t i = 0 ; i < r.size() ; i++) {
                if (r.at(i) == freq) {
                    target = i - 4000;
                    if (++count == 2) {
                        return target;
                    }
                }
            }
            return target;
        }
        
        void solve(void) {
            int temp;
            for (int i = 0 ; i < n ; i++) {
                cin >> temp;
                min_val = min(min_val, temp);
                max_val = max(max_val, temp);
                avg += static_cast<double>(temp);
                v.push_back(temp);
                r[temp + 4000]++;
            }
            avg /= n;
            if (avg < 0 && avg > -1) {
                avg = 0;
            }
            sort(v.begin(), v.end(), less<int>());
            temp = find_freq();
            cout << round(avg) << '\n' << v.at(v.size() / 2) << '\n' << temp << '\n' << max_val - min_val;
        }

    public:
        sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    sol ve;
    return 0;
}