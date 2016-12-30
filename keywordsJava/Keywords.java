package keywordsJava;

/**
 * Created by vn0dht3 on 12/30/16.
 */
public class Keywords {
}

class FinalizeExample{
    public void finalize(){System.out.println("finalize called");}
    public static void main(String[] args){
        FinalizeExample f1=new FinalizeExample();
        FinalizeExample f2=new FinalizeExample();
        f1=null;
        f2=null;
        System.gc();
        System.out.println("First this statement executed then finalize called");
    }}


class FinallyExample{
    public static void main(String[] args){
        try{
            int x=300;
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            System.out.println("finally block is executed");
        }
    }}

class FinalExample{
public static void main(String[] args){
final int x=100;
        //x=200;//Compile Time Error
}}