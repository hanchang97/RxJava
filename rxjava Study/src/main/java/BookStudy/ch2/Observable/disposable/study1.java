package BookStudy.ch2.Observable.disposable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class study1 {
    public static void main(String[] args) {

        Observable<String> source = Observable.just("A", "B", "C");

        Disposable d = source.subscribe(
                v -> System.out.println("onNext(), value : " + v), // 데이터 개수 만큼  onNext 호출
                err -> System.out.println("onError(), err : " + err.getMessage()),
                () -> System.out.println("onComplete(), ")
        );

        System.out.println("isDisposed(), d :  " + d.isDisposed());

    }
}
