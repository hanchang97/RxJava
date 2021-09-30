package BookStudy.ch4.ch4_1.repeat;

import BookStudy.common.CommonUtils;
import BookStudy.common.Log;
import BookStudy.common.OkHttpHelper;
import io.reactivex.rxjava3.core.Observable;
import okhttp3.internal.http.OkHeaders;

import java.util.concurrent.TimeUnit;

public class study {
    public static void main(String[] args) {
        CommonUtils.exampleStart();
        //String serverUrl = "https://api.github.com/zen";

        String serverUrl = "https://api.adviceslip.com/advice";

        // repeat 사용
//        Observable.timer(2, TimeUnit.SECONDS)
//                .map(val -> serverUrl)
//                .map(OkHttpHelper::get)
//                .repeat()
//                .subscribe(res -> Log.it("Ping Result : " + res));
//        CommonUtils.sleep(20000);

        //////////////////////////

         //interval 사용
        Observable.interval(0L,2000L, TimeUnit.MILLISECONDS)
                .map(val -> serverUrl)
                .map(OkHttpHelper::get)
                .subscribe(res-> Log.it("Ping Result : " + res));

        CommonUtils.sleep(20000);
    }
}
