def factorial(n) {
    if (n <= 1) {
        return 1
    } else {
        return n * factorial(n - 1)
    }
}

def result = factorial(7)

println("Factorial of 7 is => $result")
