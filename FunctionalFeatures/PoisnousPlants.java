package FunctionalFeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by vn0dht3 on 12/26/16.
 */
public class PoisnousPlants {

}
 class Solution {
     static int previousSize;

     public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc= new Scanner(System.in);
        int number_of_plants=sc.nextInt();
        sc.nextLine();
        String line=sc.nextLine();
        ArrayList<Integer> al= new ArrayList();

        //List<Integer> al= new ArrayList();
        for (String i : line.split(" ")){
            al.add(Integer.parseInt(i));
        }
        previousSize=0;
        poisnousPlans(al);
    }
    //[6, 5, 8, 4, 7, 10, 9]
     //[6, 5, ]
    public static void poisnousPlans(ArrayList al){

         Stack surviours = new Stack();

        int no_ops=0;
        ArrayList temp= new ArrayList();
        for (int i =0; i<al.size();i++){
            if (surviours.isEmpty()){
                surviours.add(al.get(i));
            }else {
                if ((Integer)surviours.peek()>(Integer)al.get(i)){
                    surviours.add(al.get(i));
                }else {
                    System.out.println(surviours);
                    no_ops=no_ops+1;
                }
            }
        }
        System.out.println(no_ops/2);

    }
}