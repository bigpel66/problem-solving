for _ in range(int(input())) :
    s = input()
    print("Do-it" if s[len(s) // 2 - 1] == s[len(s) // 2] else "Do-it-Not")