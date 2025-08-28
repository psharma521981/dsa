package others.b_java;
import java.util.function.Predicate;

public class JavaLambdaPredicate {
    public static void main(String s[]) {
        Predicate<Integer> predicateLessThen = (i) -> i < 10;
        Predicate<Integer> predicateGreaterThen = (i) -> i > 5;

        System.out.println(predicateLessThen.and(predicateGreaterThen).test(7));
        System.out.println(predicateLessThen.and(predicateGreaterThen).test(11));

    }

}
