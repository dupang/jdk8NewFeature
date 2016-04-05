package jdk8Test;

import java.util.function.Predicate;

/**
 * Created by dupang on 16-4-5.
 */
public class PredicateTest {
    public static void main(String[] args) {

        Predicate<String> lengthPredicate = x-> x.length()>3;

        Predicate<String> startPredicate = x->x.startsWith("d");

        String str = "dupang";

        System.out.println(lengthPredicate.test(str));
        System.out.println(startPredicate.test(str));

    }
}
