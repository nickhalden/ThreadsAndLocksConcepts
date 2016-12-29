package producerconsumer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Thread safe classes in concurrent packages
// so not a problem to worry about updating the data structures
// Each time a producer thread would produce some output and
// the consumer would consume the output based on certain condition
// can be used where you have messages  coming in for a client and
// then want to send them a reply every random(t) seconds

// notice I have not created a new class but instead created two threads
// that call the functions directly from inside the runnable run method

// producer consumer pattern using the array blocking queue
public class App {
    private static BlockingQueue<Integer> queue= new ArrayBlockingQueue(10);
    static Random rn=new Random();
    public static void main(String[] args) {
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                }catch (InterruptedException ie){

                }
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();

                }catch (InterruptedException ie){

                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException ie){

        }

    }
    public static void producer() throws InterruptedException{
        while (true){
            queue.put(rn.nextInt(100));

        }

    }
    public static void consumer() throws InterruptedException{
        while (true){
            Thread.sleep(100);
            if (rn.nextInt(10)==0) {
                Integer value=queue.take();
                System.out.println("Value taken out: "+ value+ "Queue size: "+queue.size());
            }

        }
    }
}
