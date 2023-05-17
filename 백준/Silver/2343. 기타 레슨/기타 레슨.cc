#include <iostream>
#include <vector>

using namespace std;

vector<int> br;

int main()
{
    int i, N, M, tmp, sum, max, cnt;
    int mid, left, right, res;
    
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);
    std::cout.tie(NULL);

    cin >> N >> M;
    // scanf("%d %d", &N, &M);

    sum = 0;
		
		// by 🐷
		// max를 전역 변수로 둔다면 초기화를 하지 않았기 때문에
		// 메모리 영역의 BSS 영역에 박히면서 0으로 초기화를 해줍니다.
		// 반면에 지역 변수는 스택에 쌓이고, 별도의 초기화가 없으면 원래는 그 값을 갖지 않은 상태거나 쓰레기 값이 됩니다.
		// 오류가 안 났던 이유는
		// 1. 이 프로그램을 실행하면서 할당 받은 메모리의 공간에 쓰레기 값이 없어서 NULL인 상태였거나 
		// 2. 0이라는 값을 유지 중이었거나
		// 둘 중 하나 입니다.
    max = 0; //max 초기화 안하고 냈다가 틀렸음... 테스트해보니까 돌아가기는 하던데 ㅎㅎ

    br.resize(N);
    for (i = 0; i < N; i++)
    {
        cin >> br[i];
        //scanf("%d", &br[i]);
        if (max < br[i])
            max = br[i];
        sum += br[i];
    }

    left = max;
    right = sum;

    while (left <= right)
    {
        tmp = 0;
        cnt = 1;
        mid = (left + right) / 2;

        for (i = 0; i < N; i++)
        {
            if (tmp + br[i] > mid)
            {
                tmp = 0;
                cnt++;
            }
            tmp += br[i];
        }
        //if (tmp != 0)
        //    cnt++;

        if (cnt > M)
        {
            left = mid + 1;
        }
        else{
            right = mid - 1;
            res = mid;
        }
    }
    cout << res;
//    printf("%d", res);
}