package multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class test {
    public static void main(String[] args) throws InterruptedException {
        maker mak = new maker();
        comsumer comsum = new comsumer();
        Thread thread = new Thread(mak);
        Thread thread2 = new Thread(comsum);
        thread2.start();
        thread.start();

    }
    static resource resource = new resource();
    static class maker implements Runnable{
        @Override
        public void run() {
            try {
                while(true) {
                    resource.changefood(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("make this");
        }
    }

    static class comsumer implements Runnable{
        @Override
        public void run() {
            try {
                while(true) {
                    resource.changefood(-1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class resource{
        private int food = 0;
        private Object lock = new Object();
        public void changefood(int temp) throws InterruptedException {
            synchronized (lock){
                if(food <= 0 && temp == -1){
                    lock.wait();
                } else if(food > 0 && temp == -1){
                    food --;
                    System.out.println("comsume this");
                } else if(food < 1 && temp == 1){
                    food ++;
                    System.out.println("make this");
                    lock.notify();
                }
            }
        }
    }
}
