package BookStudy.ch4.ch4_1.timer;

import BookStudy.common.CommonUtils;
import BookStudy.common.Log;
import io.reactivex.rxjava3.core.Observable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class study {
    public static void main(String[] args) {
        // timer는 interval 함수와 유사하지만 한 번만 실행하는 함수
        // 일정 시간 지난 후 한 개의 데이터를 발행하고 onComplete 이벤트 발생한다

        CommonUtils.exampleStart();
        Observable<String> source = Observable.timer(500L, TimeUnit.MILLISECONDS) //timer 호출하여 500ms 후에 다음 동작 실행
                .map(notUsed -> {
                    return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                            .format(new Date());
                });
        source.subscribe(Log::it);
        CommonUtils.sleep(1000);
    }
}


