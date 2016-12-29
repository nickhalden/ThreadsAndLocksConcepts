package interleavingThreads;

/**
 * Created by vn0dht3 on 12/27/16.
 */
public class App {
    private  int count =0;
    public synchronized   void increment(){  // a thread has to wait until the intrinsic lock is removed
        // form the object; intrinsic lock is similar to the mutex ( here mutex functionality ) a thread can
        // only update the variable if it has the lock ( or else waits).
        count++;
    }
    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }
    public void doWork(){
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
              for (int i=0; i<10000;i++){
//                  count++;//count =count +1; there steps happening
                  increment ();
              }
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<10000;i++){
//                    count++;
                    increment();
                }
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
        System.out.println("count is : "+count);

    }
}
