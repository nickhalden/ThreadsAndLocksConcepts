package volatile1;

import java.util.Scanner;

//  volatile keyword helps solve the problem of solving the problem of
//  cached variable(integers or booleans) by thread

class Processor extends Thread{
    private volatile boolean running = true; // this variable is cached and can
    // be changed by the other thread; so our thread which would assume while running in the
    // run method that the variable running would not be modified in the
    // now knows that the variable can be updated  so it has to stop
    // hence ensures this would make it work on all the systems;

    @Override
    public void run() {
            while (running) {
                System.out.println("printing from the infinite thread");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
    }
    // shuts down the thread by setting the running variable to fals
    public void shutdown(){
        running=false;
    }

}
public class App {
    public static void main(String[] args) {
        Processor proc1= new Processor();
        proc1.start();
        System.out.print("Press enter to stop ...");
        Scanner scanner= new Scanner(System.in);
        scanner.nextLine(); // waits for the return ke and is blocked here
        // part of main thread updating the running variable
        proc1.shutdown(); // need to call the shutdown method; unlike run(we did not call run; we called staet instead)

    }


}
