s = input()
if s[0] != '"' or s[-1] != '"' or len(s) < 3:
    print("CE")
else:
    print(s[1:-1])