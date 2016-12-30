package FunctionalFeatures;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by vn0dht3 on 12/29/16.
 */
public class QueueUsingAStack {
        static  Stack<ArrayList> integerStack= new Stack<>();

        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner scanner= new Scanner(System.in);
            scanner.nextLine();
            while (scanner.hasNextLine()){
                QueueUsingStack(scanner.nextLine());
            }


        }
        /*
        1 x: Enqueue element  into the end of the queue.
        2: Dequeue the element at the front of the queue.
        3: Print the element at the front of the queue.
         */
        public static  void QueueUsingStack(String line){

            if (line.startsWith("1 ")){ // add the elemnent to the end of the queue or top of the stack
                ArrayList<Integer> al = new ArrayList<>();

                if (integerStack.isEmpty()){
                    al.add(Integer.parseInt(line.split("1 ")[1]));
                    integerStack.push(al);
                }else {
                    al=integerStack.peek();
                    al.add(Integer.parseInt(line.split("1 ")[1]));
                    integerStack.push(al);
                }

            }
            if (line.startsWith("3")){
                if (!integerStack.isEmpty()){
                    System.out.println(integerStack.peek().get(0));
                }
            }
            if (line.startsWith("2")){
                if (!integerStack.isEmpty()){
                    ArrayList<Integer> al=integerStack.pop();
                    int last=al.size()-1;
                    if (al.size()>1){

                    }
                        //ArrayList al1= new ArrayList<Integer>(keys.subList(0,last);
//
                        //integerStack.push();

                }
            }
        }
}

/*
10
1 42
2
1 14
3
1 28
3
1 60
1 78
2
2

 */