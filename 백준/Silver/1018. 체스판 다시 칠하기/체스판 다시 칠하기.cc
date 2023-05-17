#include <iostream>
#include <vector>

int row, col, min;
std::vector<std::string> input_data;

void input()
{
	std::cin >> row >> col;
	input_data.reserve(row);
	for (int i = 0; i < row; i++)
	{
        std::string temp;
		std::cin >> temp;
        input_data.push_back(temp);
	}
}

int get_min()
{
	int min_W = 64, min_B = 64;
	int tmp_W, tmp_B;

	for (int i = 0; i <= row - 8; i++)
	{
		for (int j = 0; j <= col - 8; j++)
		{
			tmp_W = 0;
			tmp_B = 0;
			for (int k = i; k < i + 8; k++)
			{
				for (int p = j; p < j + 8; p++)
				{
					if ((k + p) % 2 == 0)
					{
						if (input_data[k][p] != 'W')
							tmp_W++;
						else
							tmp_B++;
					}
					else if ((k + p) % 2 == 1)
					{
						if (input_data[k][p] != 'B')
							tmp_W++;
						else
							tmp_B++;
					}
				}
			}
			min_W = std::min(min_W, tmp_W);
			min_B = std::min(min_B, tmp_B);
		}
	}
	return (std::min(min_W, min_B));
}

int main()
{
	input();

	min = get_min();
	std::cout << min << std::endl;
	return (0);
}