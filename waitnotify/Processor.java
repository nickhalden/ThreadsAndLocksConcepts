package waitnotify;


// low level notify and wait method
//we put an intrinsic/ monitor lock the processor object of the same  class in the
public class Processor {
    // you can also lock this(Processor) object
    private  Object lock1= new Object();
//    private Object lock2= new Object();

    public void producer() throws InterruptedException{

            synchronized (lock1){
                System.out.println(" Producer exucuting ");
                lock1.wait();
                System.out.println("Producer finshed");
            }
        }


    public void consumer() throws InterruptedException{

        // only after the synchronized block the lock is removed
        synchronized (lock1) {
            Thread.sleep(4000);
            System.out.println("Consumer Executing ");
            lock1.notifyAll(); //Note: intrinsic lock is removed from the object but the other thread does not know until
            // the Synchronized block finishes it's execution
            System.out.println("Consumer Finshed ");
        }

    }
}
