#An old ProjectEuler solution from when I just begun programming in 2013.

n1 = 1
n2 = 0
n3 = 0
scip = 0
while n3 < 4000000:
    n3 = n1 + n2
    n1 = n2     
    n2 = n3
    if n3 % 2 == 0:
        scip = scip + n3
print scip
