package threadsinJava;
class Runner extends Thread{
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
/**
 * Created by vn0dht3 on 12/27/16.
 */
public class App {

    public static void main(String[] args) {

        // method 1: to create a thread by extending the thread class
        Runner runner1= new Runner();
        runner1.start();
        Runner runner2= new Runner();
        runner2.start(); // did not call the start method  but instead App class told the
        // Thread class to execute the run the method on it's own thread space.
        // Had the following was done then then it would have run in the main thread and
        // not in a new thread
        //Runner runner3 = new Runner();
        //runner3.run();


    }
}
