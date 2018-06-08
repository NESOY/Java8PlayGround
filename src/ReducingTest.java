import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by nesoy on 2018-06-08.
 */
public class ReducingTest {
	public static void main(String[] arg){
		reduceTest();
		findMax();
		findMin();
		parrelStream();
	}

	// 메뉴에서 가장 칼로리가 높은 요리는?
	// 이러한 질의를 수행하려면 Integer 같은 결과가 나올 때까지 스트림의 모든 요소를 반복적으로 처리해야 한다.
	// Reduce : 모든 스트림 요소를 처리해서 값으로 도출하는 과정
	public static void reduceTest(){
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		int sum = numbers
				.stream()
				.reduce(0, (a,b)->a+b); // Default Value, Function Parameter
		System.out.println(sum);

		sum = numbers
				.stream()
				.reduce(0, Integer::sum); // 직접 구현할 필요가 없다.
		System.out.println(sum);

		Optional<Integer> optionalSum = numbers // Optional 객체로 지정하게 되면 Default Value가 없어도 된다.
				.stream()
				.reduce(Integer::sum);
		System.out.println(optionalSum);
	}

	public static void findMax(){
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println(max);
	}

	public static void findMin(){
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		Optional<Integer> max = numbers.stream().reduce(Integer::min);
		System.out.println(max);
	}

	public static void parrelStream(){
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7);
		Optional<Integer> sum = numbers.parallelStream().reduce(Integer::sum);
		System.out.println(sum);
	}

	// map과 reduce를 연결하는 기법을 map-reduce Pattern
	// 장점 : 쉽게 병렬화하는 특징 덕분에 구글이 웹 검색에 적용하면서 유명해지기 시작함
	// 반복적인 합계에서는 sum 변수를 공유해야 하므로 쉽게 병렬화하기 어렵다.
	// 강제적으로 동기화 시켜도 병렬화를 통해 얻어야 할 장점들이 Thread 경쟁으로 인해 다 상쇄된다.
	// 그렇기 때문에 입력도 분할하고 분할된 입력을 더한 다음에 더한 값을 합쳐야 한다.
	// 넘겨준 Lamda의 상태(인스턴스 변수 같은)가 바뀌지 말아야 하며. 연산이 어떤 순서로 실행되더라도 결과가 바뀌지 않는 구조여야 한다.
}
