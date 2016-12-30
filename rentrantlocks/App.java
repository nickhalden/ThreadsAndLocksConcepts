package rentrantlocks;

/**
 * Created by vn0dht3 on 12/30/16.
 */
public class App {
    public static void main(String[] args) {
        Runner runner= new Runner();

        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                }catch (InterruptedException ie){

                }
                }
        });

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                }catch (InterruptedException ie){

                }
            }
        });
        t1.start();t2.start();
    }
}
