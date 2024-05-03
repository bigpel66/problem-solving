while True:
    X, Y = map(float, input().split())
    if X == 0 and Y == 0:
        print("AXIS")
        break
    if X == 0 or Y == 0:
        print("AXIS")
    else:
        print("Q1" if X > 0 and Y > 0 else "Q3" if X < 0 and Y < 0 else "Q2" if X < 0 < Y else "Q4")
