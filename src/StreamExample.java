import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamExample {
    public static void main(String[] args) {
        distinctTest();
        limitTest();
        skipTest();
        flatMapTest();
    }


    public static void distinctTest() {
        // 구별하는 Method 지원
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    public static void limitTest() {
        // 전체를 실행하는 것이 아니라 일부분만 실행하여 결과물이 나온다면 멈춘다.
        List<String> menu = Arrays.asList("Hello", "Nesoy", "Pizza", "Couple", "Taxi", "Bus");
        menu.stream()
                .filter(d -> d.length() > 5)
                .limit(3)
                .forEach(System.out::println);
    }

    public static void skipTest(){
        List<String> menu = Arrays.asList("Hello", "Nesoy", "Pizza", "Couple", "Taxi", "Bus");
        menu.stream()
                .filter(d -> d.length() > 5)
                .skip(1) // 앞에 두개를 생략한다.
                .forEach(System.out::println);
    }

    public static void flatMapTest(){
        //flatMap : 스트림의 각 값을 다른 스트림으로 만든 다음에 모든 스트림을 하나의 스트림으로 연결하는 기능을 수행한다.

        //요구사항
        // 1,2,3,4,5 -> 1,4,9,16,25
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.stream()
            .map(i->i*i)
            .collect(Collectors.toList());


        //요구사항
        // (1,2,3) (3,4) -> (1,3)(2,3)(3,3)(1,4)(2,4)(3,4)
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        numbers1.stream()
            .flatMap(i -> number2.stream.map(j->new int[]{i, j}))
            .collect(Collectors.toList());

    }
}
