package multiThreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class p1114 {
    class Foo {         //原子类
        public AtomicInteger mark = new AtomicInteger(0);
        public Foo() {

        }
        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            mark.incrementAndGet();
        }
        public void second(Runnable printSecond) throws InterruptedException {
            while(mark.get()!=1){}
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            mark.incrementAndGet();

        }
        public void third(Runnable printThird) throws InterruptedException {
            while(mark.get()!=2){}
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        }
    }

    class Foo2 {         //信号量
        public Semaphore two = new Semaphore(0);
        public Semaphore three = new Semaphore(0);
        public Foo2() {

        }
        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            two.release();
        }
        public void second(Runnable printSecond) throws InterruptedException {
            two.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            three.release();

        }
        public void third(Runnable printThird) throws InterruptedException {
            three.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
