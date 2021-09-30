package BookStudy.ch4.ch4_5.delay;

import BookStudy.common.CommonUtils;
import BookStudy.common.Log;
import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class study {
    // delay 함수는 interval과 다르게 데이터 발행 전에 처음 한 번만 쉰다

    public static void main(String[] args) {
        String data[] = {"1", "7", "2", "3", "4"};

        Observable<String> source = Observable.fromArray(data)
                .delay(100L, TimeUnit.MILLISECONDS);
        source.subscribe(Log::it);

        CommonUtils.sleep(1000);

        System.out.println("////////////////");

        // no delay
        System.out.println("no delay");
        Observable<String> source2 = Observable.fromArray(data);
        source2.subscribe(Log::it);

        System.out.println("////////////////");


        Observable<String> source3 = Observable.fromArray(data)
                .delay(item -> {
                    return Observable.just(item);   // delay -> Observable 리턴 타입이므로
                });
        source3.subscribe(Log::it);

        CommonUtils.sleep(1000);

        System.out.println("////////////////");


        Observable<String> source4 = Observable.fromArray(data)
                .delay(100L, TimeUnit.MILLISECONDS);
        source4.subscribe(Log::it);

        CommonUtils.sleep(1000);
    }
}
