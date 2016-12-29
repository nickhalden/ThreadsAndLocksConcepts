package FunctionalFeatures;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by vn0dht3 on 12/21/16.
 */
public class EverythingAboutCollections {

    public static void main(String[] args) {
        //interfaces

        //----------------------------//
        //linked list
        List<String> some_list = new LinkedList<>();
        some_list.add("nipun");
        some_list.add("tom");
        some_list.add("cherry");
        System.out.println(some_list.subList(0,3));

        //java8 feature added: uses timsort to sort the linkedlist
        Collections.sort(some_list);
        System.out.println(some_list);

        //Iterator
        Iterator<String > it= some_list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("----------SortedSet-----------");
        //---------------------------//
        //set
        // Tree set:- Elements stored in the order of smallest first or lexicographic ordering
        SortedSet<String> some_set= new TreeSet<>();
        some_set.add("nipun");
        some_set.add("john");
        some_set.add("alexa");
        some_set.add("sophie");
        some_set.add("superman");
        some_set.add("lisa");
        System.out.println(some_set);// everything in the set

        System.out.println(some_set.subSet("john","superman"));//subset
        System.out.println(some_set.first());//first
        System.out.println(some_set.last());//last
        System.out.println(some_set.headSet("sophie"));//head
        System.out.println(some_set.tailSet("lisa"));// tail

        System.out.println("----------NavigableSet-----------");
        //Navigable set extends sorted set
        NavigableSet<Float> float_set= new TreeSet<>();
        float_set.add(1.2f);
        float_set.add(1.222f);
        System.out.println(float_set);
        //did not specify the data-type while creating the set still works fine
        //NavigableSet supports the retrieval of elements based on the closest match to a given value or values
        NavigableSet original = new TreeSet();
        original.add(1.3);
        original.add(1.4);
        original.add(1.2);
        original.add(1.6);
        System.out.println(original);
        System.out.println(original.headSet(1.5)); //head until the value is less than
        System.out.println(original.tailSet(1.6,true)); // inclusive set to true  returns NavigableSet


        //lower and floor
        //Floor: Searches the set for the largest element e such that e <= obj.
        System.out.println(original.floor(1.9));// Value less than or equal to <=1.9
        //E lower(E obj) Searches the set for the largest element e such that e < obj. If
        System.out.println(original.lower(1.6)); //<1.6

        NavigableSet sub= (NavigableSet)original.subSet(1.2,1.9);
        System.out.println("subset"+ sub);


        NavigableSet desc=original.descendingSet(); //descending order returns NavigableSet
        System.out.println(desc);


        System.out.println(original.pollFirst());
        while (original.size()!=0){
            System.out.println(original.pollFirst());
            System.out.println(original.pollLast());
        }

        Stack sc= new Stack();











    }


}
