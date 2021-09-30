package BookStudy.ch3.filter;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;

public class study {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 21, 10, 8, 11);

        Observable<Integer> source = Observable.fromIterable(numbers).    // List는 fromIterable 사용!!
                filter(data -> data % 2 == 0);

        source.subscribe(System.out::println);
    }
}
