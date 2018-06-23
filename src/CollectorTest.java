import model.Dish;

import java.util.Comparator;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

public class CollectorTest {
    public static void main(String[] args){
        streamMax();
        summingIntTest();
    }
    // Collector란?
    // 이전 예제에서는 collect로 Collector 인터페이스를 구현
    // Multi Level으로 그룹화를 수행할 때 명령형 프로그래밍과 함수형 프로그래밍의 차이점이 더욱 두드러진다.
    // 결과를 수집하는 과정도 간단하면서 유연한 방식으로 정의할 수 있다는 점이 최대 강점

    public static void streamMax(){
        Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
        Optional<Dish> mostCaloriesDish = Dish.menu.stream().collect(maxBy(dishComparator));
        System.out.println(mostCaloriesDish);
    }

    public static void summingIntTest(){
        int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);
    }
}
