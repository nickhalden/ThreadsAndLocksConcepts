package lowlevelthreads;

import waitnotify.Processor;

// process1  waits for the process2 to notify
// about the lock being available
//
public class Processor1 implements Runnable {

    static public Object lock= new Object();
    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("executing process1");
                lock.wait();
                System.out.println("Wait ended for process1");
            } catch (Exception ie) {
                ie.printStackTrace();
            }
        }

    }
}
class Processor2 implements Runnable{

    @Override
    public void run() {
        synchronized (Processor1.lock) {
            try {
                System.out.println("executing process2");
                Processor1.lock.notifyAll();
                System.out.println("Process2 Notifying  all Process about the releasing the lock being held");
                Thread.sleep(5000);

            } catch (Exception ie) {
            }
        }
    }
}

class Processor3 implements Runnable{
    @Override
    public void run() {
        synchronized (Processor1.lock){
            try {
                Thread.sleep(4000);
                System.out.println("executing process3");
                System.out.println("Finished process3");

            }catch (Exception ie){

            }
        }
    }
}

class  App{
    public static void main(String[] args)  throws  InterruptedException{
        Thread t1= new Thread(new Processor1());
        Thread t2= new Thread(new Processor2());
        Thread t3 = new Thread(new Processor3());
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t3.start();
        t1.join();
        t2.join();
        t3.join();


    }
}
