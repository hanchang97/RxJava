package BookStudy.ch4.ch4_1.range;

import io.reactivex.rxjava3.core.Observable;

public class study {
    public static void main(String[] args) {
        // range는 현재 스레드에서 실행되므로 CommonUtils.sleep 호출 x

        Observable<Integer> source = Observable.range(1,10)
                .filter(num -> num % 2 == 0);
        source.subscribe(System.out::println);
    }
}
