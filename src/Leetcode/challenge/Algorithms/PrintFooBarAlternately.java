import java.util.concurrent.atomic.AtomicInteger;

class FooBar {
    private int n;
    Semaphore sem = new Semaphore(0); 
    Semaphore sem2 = new Semaphore(1); 
    
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            sem2.acquire();
            printFoo.run();
            sem.release();
        }     
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            sem.acquire();
            printBar.run();
            sem2.release();
        }
        
    }
    
}
