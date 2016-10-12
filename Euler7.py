#An old ProjectEuler solution from when I just begun programming in 2013.

def primecheck(n):
    for x in xrange(2, int((n**0.5)+1)):
        if n%x == 0:
            return False
    return True

c = 0
n = 0
while c <= 10001:
    n += 1
    if primecheck(n) == True:
        c += 1

print n



