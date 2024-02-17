class PrintNumbers implements Runnable {
    int start
    int end
    
    PrintNumbers(int start, int end) {
        this.start = start
        this.end = end
    }
    
    void run() {
        for (int i = start; i <= end; i++) {
            if (Thread.currentThread().name == "odd" && i % 2 != 0) {
                println("Thread ${Thread.currentThread().name}: $i")
            } else if (Thread.currentThread().name == "even" && i % 2 == 0) {
                println("Thread ${Thread.currentThread().name}: $i")
            }
        }
    }
}

def printOdd = new Thread(new PrintNumbers(1, 10), "odd")
def printEven = new Thread(new PrintNumbers(1, 10), "even")

printOdd.start()
printEven.start()

printOdd.join()
printEven.join()
