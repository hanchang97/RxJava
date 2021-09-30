package BookStudy.ch4.ch4_5.math;

import BookStudy.common.Log;
import hu.akarnokd.rxjava3.math.MathFlowable;
import hu.akarnokd.rxjava3.math.MathObservable;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class mathFunc {
    public static void main(String[] args) {

        Integer[] data = {0,1,2,3,4};

        // 1. count  -> 결과가 1개의 값이므로 Sigle<Long>을 발행한다
        Single<Long> source  = Observable.fromArray(data)
                .count();
        source.subscribe(count -> Log.i("count is " + count));


        // 2. max() & min()

        //  수학관련 함수는 RxJavaMath를 쓰면되지만 RxJava 2.x부터는 지원을 안하기 때문에 다음을 설정
        //  implementation "com.github.akarnokd:rxjava3-extensions:3.0.1" 해줘야 MathFlowable 사용 가능

        Flowable.fromArray(data)
                .to(MathFlowable::max)
                .subscribe(max -> System.out.println("max is " + max));

        // to 함수??
        // 다른 타입으로 변환해주기 위한 함수
        // -> 공식사이트 : convert an Observable into another object or data structure
        // -> max, min 원형을 보면 Flowable<T> 가 리턴타입

        Flowable.fromArray(data)
                .to(MathFlowable::min)
                .subscribe(min -> System.out.println("min is " + min));


        // 3. sum & average

        // 교재 예제코드에서는 MathFlowable 사용
        // MathFlowable 수학 함수들 원형 = Flowable  / MathObservable도 존재 / 둘의 차이는 Flowable 과 Observable이 차이로 생각..??
        // -> 수학적 연산 처리 과정에서 생기는 배압 이슈 때문?

        // Observable
        Observable<Integer> observable1 = Observable.fromArray(data)
                .to(MathObservable::sumInt);
        observable1.subscribe(sum -> System.out.println("observable / sum is " + sum));


        // Flowable
        Flowable<Integer> flowable1 = Flowable.fromArray(data)
                .to(MathFlowable::sumInt);
        flowable1.subscribe(sum -> System.out.println("flowable / sum is " + sum));


        // average
        Flowable<Double> flowable2 = Observable.fromArray(data)
                .toFlowable(BackpressureStrategy.BUFFER)
                .to(MathFlowable::averageDouble);
        flowable2.subscribe(avgD -> System.out.println("1 avg double is " + avgD));

        // toFlowable을 통해 Observable을 Flowable로 변경할 수 있다는 것을 보여주기 위함??
        // toFlowable() ? -> 인자로 배압 전략이 들어가야 한다

        Flowable<Double> flowable3 = Flowable.fromArray(data)
                .to(MathFlowable::averageDouble);
        flowable3.subscribe(avgD -> System.out.println("2 avg double is " + avgD));


        Flowable<Double> flowable4 = Observable.fromArray(data)
                .to(MathObservable::averageDouble)   // 수학함수를 처리해줄 수 있는 형태로 변환하는 것 같음
                .toFlowable(BackpressureStrategy.BUFFER);
        flowable4.subscribe(avgD -> System.out.println("3 avg double is " + avgD));

        // to 원형을 보면 Observable, Flowable로 나누어진다
        // Observable을 Flowable로 바꾸는 것은 toFlowable로 해야한다
        // to 로는 불가한것으로 보임

    }
}
