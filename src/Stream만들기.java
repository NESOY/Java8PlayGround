import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by nesoy on 2018-06-11.
 */
public class Stream만들기 {
	public static void main(String[] args){
		valueStream();
		arrayStream();
		iterateStream();
		generateStream();
	}

	public static void valueStream(){
		Stream<String> stream = Stream.of("Java 8", "Lamdas", "In", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);
	}

	public static void arrayStream(){
		int[] numbers = {2,3,4,5,6,7,8,11};
		int sum = Arrays.stream(numbers).sum();
		System.out.println(sum);
	}

	public static void iterateStream(){
		Stream
				.iterate(0, n-> n +2)
				.limit(10)
				.forEach(System.out::println);
	}

	public static void generateStream(){
		//병렬 코드에서는 공급자에 상태가 있으면 안전하지 않다는 것.
		Stream
				.generate(Math::random)
				.limit(10)
				.forEach(System.out::println);
	}
}
