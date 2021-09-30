package BookStudy.ch5.ch5_1;

import BookStudy.common.Log;
import io.reactivex.rxjava3.core.Observable;

public class study1 {
    public static void main(String[] args) {
        Observable.just("hello!", "RxJava!")
                .subscribe(Log::i);   // 메인스레드에서 동작


        // 실무에서는 요구사항에 맞게 비동기로 동작할 수 있도록 이를 바꿔야 한다!
    }
}
