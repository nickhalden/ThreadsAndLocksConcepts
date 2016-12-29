package multipleLocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vn0dht3 on 12/27/16.
 */
public class Worker {

    private Random rn= new Random();
    private Object lock1=new Object();
    private Object lock2=new Object();
     List l1= new ArrayList();
     List l2= new ArrayList();
    // if these methods were synchronized the output would be correct but a thread which is executing either of these methods
    // would acquire an intrinsic/monitor lock on the worker object
    // and thus the second thread would have to wait until the second thread finishes and takes more time.
    //SOLUTION: put the code in synchronized blocks ; so as they are not writing to the same data they can execute concurrently
    // this reduces the time to half

    public  void stepOne(){
        synchronized (lock1) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            l1.add(rn.nextInt(100));
        }
    }

     void stepTwo(){
        synchronized (lock2) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();

            }
            l2.add(rn.nextInt(100));
        }
    }


    void  process(){
        for (int i=0 ;i<100;i++){
            stepOne();
            stepTwo();
        }

    }

    void main(){
        System.out.println("Hello from Worker");
        long start=System.currentTimeMillis();
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println("Size of list1: "+ l1.size()+" and of list2: "+l2.size());

    }
}
