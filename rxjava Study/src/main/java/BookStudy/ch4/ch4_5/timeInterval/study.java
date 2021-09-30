package BookStudy.ch4.ch4_5.timeInterval;

import BookStudy.common.CommonUtils;
import BookStudy.common.Log;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Timed;

import java.util.concurrent.TimeUnit;

public class study {
    public static void main(String[] args) {
        String[] data = {"1", "3", "7"};

        CommonUtils.exampleStart();  // 현재 시간 저장
        Observable<Timed<String>> source = Observable.fromArray(data)
                .delay(item -> {
                    CommonUtils.doSomething();   // 100ms 미만의 무작위로 뽑아낸 수로 스레드에 sleep() 메서드를 실행하는 것
                    return Observable.just(item);   // delay -> Observable 리턴 타입이므로
                })
                .timeInterval();   // timeInterval 리턴 타입 = Observable<Timed<T>>

        // Timed를 사용하면 발행 사이의 시간을 알 수 있는 것 같다


        source.subscribe(Log::it);
        CommonUtils.sleep(1000);

        System.out.println("////////////////");
        System.out.println("간격 random");
        Observable<String> source2 = Observable.fromArray(data)
                .delay(item -> {
                    CommonUtils.doSomething();   // 100ms 미만의 무작위로 뽑아낸 수로 스레드에 sleep() 메서드를 실행하는 것
                    return Observable.just(item);   // delay -> Observable 리턴 타입이므로
                });
        source2.subscribe(Log::it);

        CommonUtils.sleep(1000);

        System.out.println("////////////////");
        System.out.println("간격 일정");
        Observable<String> source3 = Observable.fromArray(data)   // 이 형식으로 delay 하면 메인스레드에서 돌아간다 why??
                .delay(item -> {
                    Thread.sleep(100);  // 일정 간격 설정
                    return Observable.just(item);   // delay -> Observable 리턴 타입이므로
                });
        source3.subscribe(Log::it);

        CommonUtils.sleep(1000);


        // 이 형태로 하게되면 interval과 비슷한 기능으로 구현이 가능한듯 / 차이점은 인터벌은 별도의 스레드에서 실행
        // 위 delay는 main 스레드 실행
        // 별도의 스레드를 사용하는 interval을 쓰는 것이 더 좋은것인지?

    }
}
