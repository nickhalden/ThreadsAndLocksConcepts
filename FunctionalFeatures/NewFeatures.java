package FunctionalFeatures;

/**
 * Created by vn0dht3 on 12/21/16.
 */
import java.util.function.*;
public class NewFeatures {
    public static void main(String[] args) {
        Predicate<String> strlen= s -> s.length()<10;
        System.out.println(strlen.test("nipunchawla")+ " length of my names is less than 10");

    }
}

