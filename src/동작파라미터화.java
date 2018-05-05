import java.util.ArrayList;
import java.util.List;

public class 동작파라미터화 {

    public static void main(String[] args) {
//        Thread t = new Thread(()->{
//            System.out.println("Hello World");
//        });

        List<Apple> applesList = new ArrayList<>();
        applesList.add(new Apple(10, "red"));
        applesList.add(new Apple(25, "green"));

        List<Apple> result = filterApples(applesList,(Apple apple) -> "red".equals(apple.color));
        System.out.println(result);

        result = filterApples(applesList,(Apple apple) -> apple.weight > 10);
        System.out.println(result);
    }

    static <T> List<T> filterApples(List<T> list, Filter<T> f){
        List<T> filterList = new ArrayList<>();
        for(T e: list){
            if(f.filter(e)){
                filterList.add(e);
            }
        }
        return filterList;
    }

}

class Apple{
    int weight;
    String color;

    public Apple(int weight, String color){
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString(){
        return weight + " " + color;
    }
}

interface Filter<T>{
    boolean filter(T t);
}