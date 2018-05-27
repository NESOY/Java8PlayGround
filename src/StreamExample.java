import java.util.Arrays;
import java.util.List;
public class StreamExample {
    public static void main(String[] args) {
        distinctTest();
        limitTest();
        skipTest();
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
}
