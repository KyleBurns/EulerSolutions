#Simple command-line Minesweeper game I made in my 1st year of uni.

import random

def genGrid(x1,y1):
    grid = []
    for x in range(x1):
        for y in range(y1):
            grid += [[x,y]]
    return grid

def genMines(no, firstClick):
    mineList = []
    x = 0
    while x < no:
        mine = [random.randrange(0,9),random.randrange(0,9)]
        if mine not in mineList and mine != firstClick:
            mineList += [mine]
            x = x + 1
    mineList = sorted(mineList)
    
    return mineList

def checkNearby(coord,grid,mines):
    xc = coord[0]
    yc = coord[1]
    count = 0
    coordList = []
    for n in range(3):
        for y in range(3):
            if xc-1+n >= 0 and xc-1+n <= 8 and yc-1+y >= 0 and yc-1+y <= 8 and [xc-1+n,yc-1+y] != [xc,yc] and [xc-1+n,yc-1+y] in grid:
                coordList += [[xc-1+n,yc-1+y]]
            if [xc-1+n,yc-1+y] in mineList:
                count += 1
    formatgrid[-yc-1][xc] = str(count)
    return [count,coordList]


def doStuff(cord,grid,mineList):
    near = checkNearby(cord,grid,mineList)
    if cord in grid:
        grid.remove(cord)
    if near[0] == 0:
        for n in range(len(near[1])):
            doStuff(near[1][n],grid,mineList)

formatgrid = [[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "],[" "," "," "," "," "," "," "," "," "]]
grid = genGrid(9,9)
loss = False
for n in range(len(formatgrid)):
    print 9-n, formatgrid[n]
print "    1    2    3    4    5    6    7    8    9"
print " "
    
firstClick = list(input("Enter a co-ordinate on the grid. "))
firstClick[0] -= 1
firstClick[1] -= 1
mineList = genMines(20,firstClick)
doStuff(firstClick,grid,mineList)
if grid == mineList:
     print "You win!"
     loss = True
     
while loss == False:
    print "\n" * 100
    for n in range(len(formatgrid)):
        print 9-n, formatgrid[n]
    print "    1    2    3    4    5    6    7    8    9"
    print " "
    userInput = list(input("Enter a co-ordinate on the grid. "))
    userInput[0] -= 1
    userInput[1] -= 1
    if userInput in grid:
        if userInput in mineList:
            formatgrid[-userInput[1]-1][userInput[0]] = "X"
            print "\n" * 100
            for n in range(len(formatgrid)):
                print 9-n, formatgrid[n]
            print "    1    2    3    4    5    6    7    8    9"
            print " "
            print "BOOM! Game over."
            loss = True
        else:
            doStuff(userInput,grid,mineList)   
    else:
        print "Co-ordinate not found in grid."
    if grid == mineList:
        print "\n" * 100
        for n in range(len(formatgrid)):
            print 9-n, formatgrid[n]
        print "    1    2    3    4    5    6    7    8    9"
        print " "
        print "You win!"
        loss = True
        
