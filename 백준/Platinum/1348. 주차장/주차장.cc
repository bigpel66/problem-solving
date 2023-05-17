#include <iostream>
#include <queue>
#include <string>
#include <vector>

int		result;
int		R;
int		C;

std::string map;
std::queue<std::pair<int, int>> bfs_check;
std::vector<std::pair<int, int>> dir;
std::vector<std::pair<int, int>> park;
std::vector<std::pair<int, int>> cars;
std::vector<std::vector<int>> dis;
std::vector<int> linked;
std::vector<int> visited;
std::vector<bool> matched;

void	input()
{
	std::cin >> R >> C;
	map.resize(R * C);
	result = -1;
	dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	for (int i = 0; i < R * C; i++)
	{
		std::cin >> map[i];
		if (map[i] == 'C')
			cars.push_back(std::make_pair(i / C, i % C));
		if (map[i] == 'P')
			park.push_back(std::make_pair(i / C, i % C));
	}
	dis.resize(cars.size());
	for (size_t i = 0; i < cars.size(); i++)
		dis[i].resize(park.size());
}

void	bfs()
{
	int	x;
	int	y;
	int	next_x;
	int	next_y;

	for (size_t i = 0; i < cars.size(); i++)
	{
		visited = std::vector<int>(R * C, -1);
		bfs_check = std::queue<std::pair<int, int>>();
		bfs_check.push({ cars[i].first, cars[i].second });
		visited[cars[i].first * C + cars[i].second] = 0;
		while (!bfs_check.empty())
		{
			x = bfs_check.front().first;
			y = bfs_check.front().second;
			bfs_check.pop();
			for (int j = 0; j < 4; j++)
			{
				next_x = x + dir[j].first;
				next_y = y + dir[j].second;
				if (next_x >= 0 && next_y >= 0 && next_x < R && next_y < C &&
					map[next_x * C + next_y] != 'X' && visited[next_x * C + next_y] == -1)
				{
					visited[next_x * C + next_y] = visited[x * C + y] + 1;
					bfs_check.push({ next_x, next_y });
				}
			}
		}
		for (size_t k = 0; k < park.size(); k++)
			dis[i][k] = visited[park[k].first * C + park[k].second];
	}
	//출력용
	// for (size_t a = 0 ; a < cars.size() ; a++)
	// {
	// std::cout << "car " << a << " : ";
	// for (size_t b = 0 ; b < park.size() ; b++)
	// {
	// std::cout << dis[a][b] << " ";
	// }
	// std::cout << std::endl;
	// }
}

bool	dfs_matching(int mid, int car)
{
    if(matched[car])
        return (false);
    matched[car] = true;
	for (size_t i = 0; i < park.size(); i++)
	{
		if (dis[car][i] < 1 || mid < dis[car][i])
			continue ;
		if (linked[i] == -1 || dfs_matching(mid, linked[i]))
		{
			linked[i] = car;
			return (true);
		}
	}
	return (false);
}

int		dfs(int mid)
{
	int	cnt;

	cnt = 0;
	linked = std::vector<int>(park.size() + 1, -1);
	for (size_t i = 0; i < cars.size(); i++)
	{
		matched = std::vector<bool>(cars.size() + 1, false);
		if (dfs_matching(mid, i))
			++cnt;
	}
	return (cnt);
}
void	bsearch()
{
	int	left;
	int	mid;
	int	right;

	left = 1;
	right = R * C;
	while (left <= right)
	{
		mid = (left + right) / 2;
		if (dfs(mid) == (int)cars.size())
		{
			result = mid;
			right = mid - 1;
		}
		else
			left = mid + 1;
	}
}

bool	ispossible()
{
	if (!cars.size())
	{
		std::cout << 0;
		return (false);
	}
	if (cars.size() > park.size())
	{
		std::cout << -1;
		return (false);
	}
	return (true);
}

void	output()
{
	std::cout << result;
}

void	solution()
{
	if (!ispossible())
		return ;
	bfs();
	bsearch();
	output();
}

void	preset()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);
}

int		main()
{
	preset();
	input();
	solution();
}