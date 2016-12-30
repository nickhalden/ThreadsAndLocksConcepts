package lowlevelThreads2;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by vn0dht3 on 12/30/16.
 */
public class Processor {
    private LinkedList<Integer> list= new LinkedList<>();
    private  final int LIMIT=10;
    private  Object lock= new Object();

    public void produce() throws InterruptedException{

        int value=0;
        while (true){
            synchronized (lock){
                while (list.size()==LIMIT){
                    lock.wait();// goes to sleep
                }
            }
            list.add(value++);

        }

    }
    public void consume() throws InterruptedException{
        Random random = new Random();
            while (true){
                synchronized (lock) {
                    System.out.print("List size is " + list.size());
                    int value = list.removeFirst();
                    System.out.println("; value is: " + value);
                    lock.notify(); // wakes up the other thread
                }
                Thread.sleep(random.nextInt(1000));
            }


    }
}
