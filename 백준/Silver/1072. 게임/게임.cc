#include <iostream>

int main()
{
		// by 🐷
		// res 없어도 되어요
    long long save, tmp, X, Y, left, right, mid, res;

    scanf("%lld %lld", &X, &Y);

    save = Y * 100 / X;

    if (save >= 99)
    {
        printf("-1");
        return 0;
    }

    left = 0;
// 1. right 값 수행한 판 수로 바꿔보기
    right = X;

    while (left <= right)
    {
        mid = (left + right) / 2;
        tmp = 100 * (Y + mid) / (X + mid);

        if (save < tmp)
        {
            res = mid;
            right = mid - 1;
        }
        else
            left = mid + 1;
    }

		//이거 mid라고 써서 8트했다 자나깨나 변수조심
    printf("%lld", res);
}