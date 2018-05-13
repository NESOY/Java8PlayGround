import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lamda {
    public static void main(String[] args) {
        //java.util.function.Predicate
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("Hello");
        list.add("");

        List<String> filterList = filter(list, nonEmptyStringPredicate);
        System.out.println(filterList.size()); // 1

        //java.util.function.Consumer
        forEach(
                Arrays.asList(1, 2, 3, 4, 5),
                (Integer i) -> System.out.println(i)
        );

        //java.util.function.Function
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "actions"),
                (String s) -> s.length()
        );

        System.out.println(l); // 7, 2, 7


        // Method Reference
        // inventory.sort(comparing(Apple::getWeight));
        // inventory.sort(comparing(Apple::getWeight).reversed());
        // inventory.sort(comparing(Apple::getWeight)
        //                .reversed()
        //                .thenComparing(Apple::getCountry)
        // );

        // Constructor Reference
//        List<Apple> l = map(
//                Arrays.asList(1, 2, 3),
//                Apple::new
//        );
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                result.add(s);
            }
        }
        return result;
    }


    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T i : list) {
            c.accept(i);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}

//java.util.function.Predicate : T의 객체를 인수로 받아 Boolean을 반환한다.
@FunctionalInterface // 함수형 인터페이스 선언
interface Predicate<T> {
    // negate() : 결과를 반전시킨 객체를 만든다.
    // and() : 두 Predicate를 연결해서 새로운 Predicat 객체를 만든다.
    // or() : 더 복잡한 Predicate 객체를 만든다.
    boolean test(T t);
}

//java.util.function.Consumer : 객체를 인수로 받아서 어떤 동작을 수행하고 싶을 때 Consumer 인터페이스를 사용할 수 있다.
@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

//java.util.function.Function : Generic T를 받아서 Generic R 객체를 반환하는 apply라는 Abstract Method를 정의한다.
@FunctionalInterface
interface Function<T, R> {
    // andThen : 주어진 함수를 먼저 적용한 결과를 다른 함수의 입력으로 전달하는 함수를 반환
    //f = x -> x + 1;
    //g = x -> x * 2;
    //h = f.andThen(g) = g(f(x)) // 그런 다음.

    // compose : 인수로 주어진 함수를 먼저 실행한 다음에 그 결과를 외부 함수의 인수로 제공
    //f = x -> x + 1;
    //g = x -> x * 2;
    //h = f.compose(g) = f(g(x)) // compose : 기초를 이루다.
    R apply(T t);
}
