package BookStudy.ch3.reduce;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;

public class study {
    public static void main(String[] args) { //reduce -> 발행된 데이터 합치기
        String[] balls = {"1", "3", "5"};
        Maybe<String> source = Observable.fromArray(balls)
                .reduce((ball1, ball2) -> ball2 + "(" + ball1 + ")");

        source.subscribe(System.out::println);
    }
}
