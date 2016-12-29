package threadpools;

import java.util.concurrent.*;

//Thread Pools
class Processor implements  Runnable{
    private int id;
    Processor(int id){
        this.id= id;
    }

    @Override
    public void run() {
        System.out.println("Started thread with id: "+ id);
        try {
            Thread.sleep(100); // eg: can add the server logic which says the thread should accept a connection or do any other operatio
        }catch (InterruptedException ie){

        }
        System.out.println("Ended thread with id: "+ id );
    }
}
public class App {
    public static void main(String[] args) {

        // Giving the task of executing to by spawning two threads at a time
        ExecutorService exObj = Executors.newFixedThreadPool(2);
        for (int i=0;i<100;i++){
            // submit 5 processes object to be submitted to the executor
            exObj.submit(new Processor(i));
        }

        exObj.shutdown();
        System.out.println("All tasks submitted ");
        try {
            exObj.awaitTermination(5, TimeUnit.SECONDS);

        }catch (InterruptedException ie){

        }
        System.out.println("All tasks finished ");


    }

}
