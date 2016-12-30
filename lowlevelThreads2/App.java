package lowlevelThreads2;


/**
 * Created by vn0dht3 on 12/30/16.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Processor processor= new Processor();
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.produce();
                }catch (Exception e){

                }

            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consume();
                }catch (Exception e){

                }

            }
        });
        t1.start();t2.start();
        t1.join();t2.join();


    }
}
