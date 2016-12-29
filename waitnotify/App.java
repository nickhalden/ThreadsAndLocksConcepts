package waitnotify;

/**
 * Created by vn0dht3 on 12/28/16.
 */
public class App {
    public static void main(String[] args) {

        Processor processor= new Processor();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.producer();
                }catch (InterruptedException ie){

                }
            }
        });

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.consumer();
                }catch (InterruptedException ie ){

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
}
