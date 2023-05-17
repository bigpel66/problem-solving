#include <iostream>
#include <algorithm>

int T[16] = {0,};
int P[16] = {0,};
int DP[16] = {0,};
int number;
int max;

int solutionDP1(int day)
{
    if(day == number + 1) return 0;
    
    if(day > number + 1) return -987654321;
    
    if(DP[day] > 0) return DP[day];
    
    return DP[day] = std::max(solutionDP1(day + 1), solutionDP1(day + T[day]) + P[day]);
}

//int solutionDP2()
//{
//
//}

//void solutionDFS()
//{
//
//}

void makeInput()
{
    std::cin >> number;
    
    for(int i = 1; i <= number; i++)
    {
        std::cin >> T[i] >> P[i];
    }
}

void initializeDPArray()
{
    for(int i = 0; i <16; i++)
    {
        DP[i] = 0;
    }
}

int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    
    makeInput();
    
    std::cout << solutionDP1(1);
    initializeDPArray();
    
//    std::cout << solutionDP2();
//    initializeDPArray();
//
//    std::cout << max;
//    initializeDPArray();
    
    return 0;
}