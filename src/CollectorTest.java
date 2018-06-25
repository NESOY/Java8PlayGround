import model.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class CollectorTest {
	public static void main(String[] args) {
		//streamMax();
		//summingIntTest();
		//joiningTest();
		//groupingByTest();
		//multiLevelGroupingByTest();
		partitioningTest();
	}
	// Collector란?
	// 이전 예제에서는 collect로 Collector 인터페이스를 구현
	// Multi Level으로 그룹화를 수행할 때 명령형 프로그래밍과 함수형 프로그래밍의 차이점이 더욱 두드러진다.
	// 결과를 수집하는 과정도 간단하면서 유연한 방식으로 정의할 수 있다는 점이 최대 강점

	public static void streamMax() {
		Comparator<Dish> dishComparator = Comparator.comparing(Dish::getCalories);
		Optional<Dish> mostCaloriesDish = Dish.menu.stream().collect(maxBy(dishComparator));
		System.out.println(mostCaloriesDish);
	}

	public static void summingIntTest() {
		int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
	}

	public static void joiningTest() {
		String menuString = Dish.menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(menuString);
	}

	// collect와 reduce의 차이점?
	// collect : Method는 도출하려는 결과를 누적하는 컨테이너를 바꾸도록 설계된 Method
	// reduce : 두 Value를 하나의 Value로 도출하는 불변형 연산 Mehtod
	// 주의할 점 : 누적자로 사용된 List를 변환시키는 행위는 reduce Method를 잘못 사용하면 실용성 문제가 생긴다.
	// 여러 Thread가 동시에 같은 데이터 구조체를 고치면 List 자체가 망가져버리므로 Reducing 연산을 병렬로 수행할 수 없다.

	public static void groupingByTest() {
		// classification function
		Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);
	}

	enum CaloricLevel {
		DIET, NORMAL, FAT
	}

	public static void multiLevelGroupingByTest() {
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
				Dish.menu.stream().collect(
						groupingBy(Dish::getType,
								groupingBy(dish -> {
									if (dish.getCalories() <= 400) {
										return CaloricLevel.DIET;
									} else if (dish.getCalories() <= 700) {
										return CaloricLevel.NORMAL;
									}
									return CaloricLevel.FAT;
								}))
				);
		System.out.println(dishesByTypeCaloricLevel);
	}
	//Collectors.collectingAndThen으로 컬렉터가 Optional로 Wrapping된 부분을 제거할 수 있다.
	//reducing  collector는 절대 Optional.empty()를 반환하지 않으므로 안전한 코드이다.

	public static void partitioningTest() {
		Map<Boolean, List<Dish>> partitionMenu = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(partitionMenu);
	}

	// Collector 인터페이스

	// supplier : 새로운 결과 컨테이너 만들기.
	// 수집 과정에서 빈 누적자 인스턴스를 만드는 파라미터가 없는 함수
	//public Supplier<List<T>> supplier(){
	//	return () -> new ArrayList<T>();
	//}

	// accumulator : 결과 컨테이너에 요소 추가하기
	// public BiConsumer<List<T>, T> accumulator(){
	// return List::add;
	//}

	// finisher : 최종 변환값을 결과 컨테이너로 적용하기
	// 누적자 객체를 최종 결과로 변환하면서 누적 과정을 끝낼 때 호출할 함수를 반환해야 한다.
	// 누적자 객체가 최종 결과인 상황인 경우 항등 함수를 반환.
	// public Function<List<T>, List<T>> finisher() {
	// return Function.identity();
	// }

	// combiner : 두 결과 컨테이너 병합
	// public BinaryOperator<List<T>> combiner(){
	//      return (list1, list2) -> { list1.addAll(list2); return list1; }
	//}

}
