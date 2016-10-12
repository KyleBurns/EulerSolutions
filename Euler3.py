#An old ProjectEuler solution from when I just begun programming in 2013.

def primecheck(n):
    
    factor = 2
    check = 0
    while factor < n:
        if n % factor == 0 and check == 0:
            check = 1
        factor = factor + 1
    if check == 0:
        print n
    
def factorcheck(n):
    counter = 1
    while counter <= n:
        if n % counter == 0:
            primecheck(counter)
        counter = counter + 1

a = input("Enter your number ")
factorcheck(a)
