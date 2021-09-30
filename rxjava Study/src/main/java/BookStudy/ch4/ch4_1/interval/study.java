package BookStudy.ch4.ch4_1.interval;

import BookStudy.common.CommonUtils;
import io.reactivex.rxjava3.core.Observable;


import java.util.concurrent.TimeUnit;

public class study {

    public static void main(String[] args) {

        CommonUtils.exampleStart();
        Observable<Long> source = Observable.interval(100L, TimeUnit.MILLISECONDS) // 처음에도 100L 만큼 쉰다
                .map(data -> (data+1)*100)
                .take(5);

        // source 변수는 100ms 간격으로 0부터 데이터를 발행한다

        source.subscribe(Log::it);
        CommonUtils.sleep(1000);

    }


}

class Log{
    public static void it(Object obj){
        long time = System.currentTimeMillis() - CommonUtils.startTime;
        System.out.println(Thread.currentThread() + " | " + time + " | " + "value " + obj);
    }
}


// interval 함수는 기본적으로 영원히 지속 실행되기 때문에 폴링 용도로 많이 사용

// -->> 폴링? = 서버 or 클라이언트에서 특정요청 반복적으로 하는 것 -> 주기적으로 업데이트 하는 기능? 에 사용하는 듯

//    브라우저가 일정한 주기로 HTTP 요청을 보내는 방식
//    -> 보통 실시간 데이터의 업데이트 주기는 예측하기 어려우므로, 그에 따른 불필요한 서버 및 네트웍 부하가 늘어남