package demo2;

/**
 * Created by vn0dht3 on 12/27/16.
 */

class Runner implements Runnable{
    @Override
    public void run() {
        for (int i =0;  i <10;i++){
            System.out.println("Hello "+i);
            try{
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
}
public class App  {
    public static void main(String[] args) {

        // method2: to create a thread implement Runnable class and pass it to the constructor of thread class
        Thread t1= new Thread( new Runner());
        Thread t2= new Thread( new Runner());

        t1.start();
        t2.start();
    }
}
