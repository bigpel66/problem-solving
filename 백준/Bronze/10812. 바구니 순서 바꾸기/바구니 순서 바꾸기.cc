#include <iostream>
#include <vector>

using namespace std;

class t_sol {
    private:
        int number_of_basket;
        int number_of_query;
        int begin, end, mid;
        vector<int> vec;
        
        void stream(void) {
            cin.tie(nullptr);
            ios_base::sync_with_stdio(false);
        }
    
        void get_input(void) {
            cin >> number_of_basket >> number_of_query;
            vec = vector<int>(number_of_basket + 1, 0);
            for (int i = 1 ; i < number_of_basket + 1 ; i++) {
                vec[i] = i;
            }
        }
        
        void solve(void) {
            vector<int> temp;
            for (int i = 0 ; i < number_of_query ; i++) {
                cin >> begin >> end >> mid;
                for (int j = mid ; j <= end ; j++) {
                    temp.push_back(vec.at(j));
                }
                for (int j = begin ; j < mid ; j++) {
                    temp.push_back(vec.at(j));
                }
                for (int j = 0 ; j < temp.size() ; j++) {
                    vec[begin + j] = temp.at(j);
                }
                temp.clear();
            }
            for (int i = 1 ; i < vec.size() ; i++) {
                cout << vec.at(i) << ' ';
            }
        }
    
    public:
        t_sol(void) {
            stream();
            get_input();
            solve();
        }
};

int main(void) {
    t_sol s;
    return 0;
}