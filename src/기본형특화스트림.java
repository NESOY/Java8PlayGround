import java.util.stream.IntStream;

/**
 * Created by nesoy on 2018-06-11.
 */
public class 기본형특화스트림 {
	public static void main(String[] args) {
		특화StreamTest();
		numberRange();
	}

	public static void 특화StreamTest() {
		// 특화스트림은 오직 Boxing, Unboxing과정에서 일어나는 효율성과 관련 있으며 스트림에 추가 기능을 제공하지 않는다는 사실.
		// int 요소에 특화된 IntStream
		// double 요소에 특화된 DoubleStream
		//		int calories =
		//				menu
		//						.stream() // Stream<Dish> 반환
		//						.mapToInt(Dish::getCalories) // IntStream 반환
		//						.sum();

		// 객체 스트림으로 복원하기
		//Stream<Integer> stream = new IntStream().boxed();

		// 기본형 특화 스트림 버전도 제공.
		// OptionalInt
		// OptionalDouble
		// OptionalLong

	}

	public static void numberRange(){
		IntStream oddNumbers = IntStream.range(1,100).filter(n -> n%2 != 0); // 1, 100을 포함하지 않는다.
		IntStream evenNumbers = IntStream.rangeClosed(1,100).filter(n -> n%2 == 0);  // 1, 100을 포함한다.
		System.out.println(evenNumbers.count());
	}
}
