package rentrantlocks;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by vn0dht3 on 12/30/16.
 */
public class Runner {
    private  int count=0;
    private  Lock lock= new ReentrantLock();
    private Condition cond=lock.newCondition();

    void incremnent(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }

    void firstThread() throws  InterruptedException{
        lock.lock();
        System.out.println("Waiting .... ");
        cond.await();
        System.out.println("Woken up");
        try {
            incremnent();
        }finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException{
        Thread.sleep(1000);
        lock.lock();
        System.out.println("Press Enter Key");
        //PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(20,Collections.reverseOrder());
        new Scanner(System.in).nextLine();
        System.out.println("Got return key");

        cond.signal(); // not until the code block is finished

        try {
            incremnent();
        }finally {
            lock.unlock();
        }

    }
}
