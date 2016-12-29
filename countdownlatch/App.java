package countdownlatch;

import sun.jvm.hotspot.debugger.ThreadAccess;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// usage: eg: can be used for inter thread communications
// no need of synchronized keyword as it is a Thread-Safe  class

class Processor implements Runnable{
    private CountDownLatch latch;
    public Processor(CountDownLatch latch){
        this.latch= latch;


    }
    @Override
    public void run() {
        System.out.println("Started");
        try {
            // some processing in the form of sleep
            Thread.sleep(3000);
        }catch (InterruptedException ie){

        }
        latch.countDown();// value is count down
        System.out.println("Finished");
    }
}

public class App {
    public static void main(String[] args) {
        CountDownLatch countDownLatch= new CountDownLatch(3);
        ExecutorService executor= Executors.newFixedThreadPool(3);
        for ( int i =0;i<3;i++){
            executor.submit(new Processor(countDownLatch));
        }
        executor.shutdown();
        try {
            countDownLatch.await();

        }catch (InterruptedException ie){

        }
        System.out.println("Completed");
    }
}
