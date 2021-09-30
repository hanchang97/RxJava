package BookStudy.ch3.flatMap;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Function;

public class study {
    public static void main(String[] args) {
        // 함수를 별도로 정의하는 것이 첫번째 할 일!
        Function<String, Observable<String>> getDoubleDiamonds =
                ball -> Observable.just(ball + "<>", ball + "<>");

        String[] balls = {"1", "2", "3"};

        Observable<String> source = Observable.fromArray(balls)
                .flatMap(getDoubleDiamonds);

        source.subscribe(System.out::println);
    }
}
