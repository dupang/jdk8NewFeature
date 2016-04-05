package jdk8Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by dupang on 16-4-5.
 */
public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<String> consumer = x->x.length();
        Function<String,String> upFunction = x->x.toUpperCase();

        Function<String,String> subStrFunction = x->x.substring(0,2);
        Optional<String> optional = Optional.of("Dupang");
        System.out.println(optional.map(subStrFunction.andThen(upFunction)).get());

    }

}
