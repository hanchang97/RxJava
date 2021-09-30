package BookStudy.ch2.Observable.fromCallable;

import io.reactivex.rxjava3.core.Observable;

import java.sql.Time;
import java.util.concurrent.Callable;

public class study {
    public static void main(String[] args) {

        Callable<String> callable = () -> {
          Thread.sleep(1500);
          return "Hi Callable, sleep 1500ms";
        };

        Observable<String> source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }
}
