//package FunctionalFeatures;

import jdk.internal.util.xml.impl.Pair;

import java.io.*;
import java.util.*;

/**
 * Created by vn0dht3 on 12/26/16.
 */
public class StackQuestions {

}



class Solution {
    static Stack stack= new Stack();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        //   Scanner in = new Scanner(System.in);
        //float T = Float.parseFloat(in.nextLine());
        //int N = Integer.parseInt(in.nextLine());

        while(sc.hasNextLine()){
            stackOperations(sc.nextLine());
        }
    //test();
    }
    public static void test(){
        Stack newStack = new Stack();

        List newArrayList= new ArrayList();
        newArrayList.add(10);
        newArrayList.add(30);
        newArrayList.add(90);

        newStack.add(newArrayList);
        System.out.println(newStack);
        newArrayList.add(10);
        newArrayList.add(30);
        newArrayList.add(90);
        newStack.add(newArrayList);
        System.out.println(newStack);



    }
    // find the max element in O(1) time
    public static void stackOperations(String line){

        if ((line.split(" ").length)==2){
            Integer to_be_pushed=Integer.parseInt(line.split(" ")[1]);
            //System.out.println(to_be_pushed);
            List newArrayList= new ArrayList();
            int maxVal;
            if (!stack.isEmpty()){
                ArrayList  newal=(ArrayList)stack.peek();
                maxVal = (to_be_pushed > (Integer)newal.get(1)? to_be_pushed :  (Integer) newal.get(1));

            }else {
                maxVal=to_be_pushed;
            }
            newArrayList.add(to_be_pushed);
            newArrayList.add(maxVal);

            stack.push(newArrayList);
        }
        else{
            //2    -Delete the element present at the top of the stack.
            //3    -Print the maximum element in the stack.
            if (Integer.parseInt(line.split("")[0])==2){
                if  (stack.size()!=0){
                    stack.pop();
                }
            }
            else if (Integer.parseInt(line.split(" ")[0])==3){
                ArrayList peeklist= (ArrayList)stack.peek();
                System.out.println((Integer)peeklist.get(1));
            }

        }
    }
    public static void Balanced_Brackets(){

    }



}


//44
//        44
//        1
//        1
//        3
//        29
//        73
//        73
//        73
//        73
//        73
//        73
//        73
//        73
//        73
//        85
//        85
//        85
//        86
//        86
//        100
//        100
//        100