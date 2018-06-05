import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class 검색과매칭 {
	public static void main(String[] args){
		anyMatchTest();
		allMatchTest();
		noneMatchTest();

	}
	// java 8 short circuit
	// 표현식에서 하나라도 거짓이라는 결과가 나오면 나머지 표현식의 결과와 상관없이 전체 결과도 거짓이 된다

	public static void anyMatchTest(){
		//일부만 검사한다
		List<Integer> evenData = Arrays.asList(1,2,3,4,5,6,7,8);
		List<Integer> oddData = Arrays.asList(1,3,5,7);
		System.out.println("ODD " + oddData
				.stream()
				.anyMatch(number -> number%2==0) // false -> odd numbers
		);

		System.out.println("Even " + evenData
				.stream()
				.anyMatch(number -> number%2==0) // true -> even numbers
		);
	}

	public static void allMatchTest(){
		//전체를 검사한다
		List<Integer> Data = Arrays.asList(2,4,6,8,9);
		System.out.println("data " + Data
				.stream()
				.allMatch(number -> number%2==0) // false -> 9
		);
	}

	public static void noneMatchTest(){
		// allMatch와 반대 연산을 수행한다
		List<Integer> Data = Arrays.asList(2,4,6,8);
		System.out.println("data " + Data
				.stream()
				.noneMatch(number -> number%2 != 0) // true
		);
	}


	public static void findAnyTest(){
		//결과를 찾는 즉시 종료한다
//		Optional<Apple> apple = menu.stream()
//				.filter(Dish::isVegetarian)
//				.findAny();
	}


	public static void OptionalTest(){
		//Optional이란
		// 값의 존재나 부재 여부를 표현하는 컨테이너 클래스
		Optional<Integer> number;
//		number.isPresent(); // Optional이 값을 포함하면 true, 값을 포함하지 않으면 false
//		number.ifPresent(); // 값이 있으면 주어진 블록을 실행한다
//		number.get(); // 값이 존재하면 Return Or NoSuchElementException 발생
//		number.orElse(); // 값이 있으면 값을 반환하고 null인지 검사할 필요가 없어졌다
	}
}
